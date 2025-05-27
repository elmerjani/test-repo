package com.reservation.payment;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author : El-Merjani Mohamed
 * Date : 5/26/2025
 */
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    private String id;

    @Column(nullable = false)
    private Long reservationId;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime processedAt;




}
