package com.reservation.payment;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : El-Merjani Mohamed
 * Date : 5/26/2025
 */
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
