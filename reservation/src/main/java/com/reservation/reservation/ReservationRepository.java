package com.reservation.reservation;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : El-Merjani Mohamed
 * Date : 5/26/2025
 */
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
