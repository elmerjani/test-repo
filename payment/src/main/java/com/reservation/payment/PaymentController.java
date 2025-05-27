package com.reservation.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : El-Merjani Mohamed
 * Date : 5/27/2025
 */
@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public Payment payment(@RequestBody Payment paymentDTO) {
       return  paymentService.processPayment(paymentDTO);
    }

    @GetMapping
    public List<Payment> getPayments() {
        return paymentService.getAllPayment();
    }
}
