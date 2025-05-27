package com.reservation.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

/**
 * @author : El-Merjani Mohamed
 * Date : 5/26/2025
 */
@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private RestTemplate restTemplate;


    public Reservation createReservation(ReservationDTO reservationDTO) {
        Event event = restTemplate.getForObject("http://localhost:8082/events/" + reservationDTO.getEventId(), Event.class);

        if(event.getAvailableSeats() < reservationDTO.getNumberOfTickets()){
            throw new RuntimeException("Number of tickets exceeds number of seats");
        }
        Reservation reservation = new Reservation(reservationDTO.getUserId(), reservationDTO.getEventId(), reservationDTO.getNumberOfTickets(), reservationDTO.getTotalAmount());
        reservation.setStatus(ReservationStatus.PENDING);
        reservation.setReservationDate(LocalDateTime.now());
        reservation.setExpirationDate(LocalDateTime.now().plusMinutes(20));
        reservation = reservationRepository.save(reservation);

        return reservation;
    }



    public void cancelReservation(Long reservationId, String reason) {
        Reservation reservation = reservationRepository.findById(reservationId).orElseThrow();
        reservation.setStatus(ReservationStatus.CANCELLED);
        reservationRepository.save(reservation);

        eventPublisher.publish("reservation.cancelled",
                new ReservationCancelledEvent(reservationId, reason));
    }

    public Reservation getReservation(Long id) {
        return reservationRepository.findById(id).orElseThrow();
    }

    public void deleteReservation(Long id) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow();
        reservation.setStatus(ReservationStatus.CANCELLED);
        reservationRepository.save(reservation);
    }
}

