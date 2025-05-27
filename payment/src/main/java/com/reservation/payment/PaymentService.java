package com.reservation.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author : El-Merjani Mohamed
 * Date : 5/26/2025
 */

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private EventPublisher eventPublisher;

    public Payment processPayment(PaymentDTO paymentDTO) {
        Payment payment = new Payment(paymentDTO.getReservationId(), paymentDTO.getUserId(), paymentDTO.getAmount(), paymentDTO.getPaymentMethod());
        payment.setStatus(PaymentStatus.PROCESSING);
        payment = paymentRepository.save(payment);

        // Simulate payment processing
        try {
            // Call external payment gateway
            boolean paymentSuccess = processWithPaymentGateway(payment);

            if (paymentSuccess) {
                payment.setStatus(PaymentStatus.COMPLETED);
                payment.setProcessedAt(LocalDateTime.now());
                payment = paymentRepository.save(payment);

                eventPublisher.publish("payment.completed",payment);
            } else {
                payment.setStatus(PaymentStatus.FAILED);
                payment.setFailureReason("Payment gateway declined");
                payment = paymentRepository.save(payment);

                eventPublisher.publish("payment.failed",payment);
            }
        } catch (Exception e) {
            payment.setStatus(PaymentStatus.FAILED);
            payment.setFailureReason(e.getMessage());
            payment = paymentRepository.save(payment);

            eventPublisher.publish("payment.failed",payment);
        }

        return payment;
    }

    private boolean processWithPaymentGateway(Payment payment) {
        // Simulate external payment gateway call
        // In real implementation, this would call Stripe, PayPal, etc.
        return Math.random() > 0.1; // 90% success rate
    }



    public Payment getPayment(Long id) {
        return paymentRepository.findById(id).orElseThrow();
    }

    public List<Payment> getAllPayment() {
        return paymentRepository.findAll();
    }
}