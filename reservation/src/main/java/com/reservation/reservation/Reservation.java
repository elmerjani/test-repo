package com.reservation.reservation;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author : El-Merjani Mohamed
 * Date : 5/26/2025
 */

@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long eventId;

    @Column(nullable = false)
    private Integer numberOfTickets;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal totalAmount;

    @Enumerated(EnumType.STRING)
    private ReservationStatus status;

    @Column(nullable = false)
    private LocalDateTime reservationDate;

    @Column
    private LocalDateTime expirationDate;

}