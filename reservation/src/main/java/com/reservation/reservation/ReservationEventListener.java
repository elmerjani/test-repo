package com.reservation.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

/**
 * @author : El-Merjani Mohamed
 * Date : 5/27/2025
 */
@Configuration
public class ReservationEventListener {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private EventPublisher eventPublisher;

    @Bean
    public Consumer<PaymentEvent> paymentEventConsumer(){
        return event -> {

            Reservation reservation = reservationRepository.getReferenceById(event.getReservationId());

            if(event.getType()=="Created") {
                reservation.setStatus(ReservationStatus.CONFIRMED);
            }
            else{
                reservation.setStatus(ReservationStatus.PAYMENT_FAILED);
            }
            eventPublisher.publish(reservation);
        };
    }
}
