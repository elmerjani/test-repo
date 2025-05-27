package com.reservation.notificationservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : El-Merjani Mohamed
 * Date : 5/27/2025
 */
@Service
public class NotificationService {

    @Autowired
    private final NotificationRepository repository;

    @Autowired
    private final EmailSender emailSender;

    public void processEvent(NotificationEvent event) {
        String subject = event.getSubject();
        String message = event.getMessage();

        // Default templates if not provided
        if (subject == null || message == null) {
            switch (event.getEventType()) {
                case "RESERVATION_CONFIRMED" -> {
                    subject = "Your reservation is confirmed!";
                    message = "Thank you for booking your seat.";
                }
                case "PAYMENT_SUCCESS" -> {
                    subject = "Payment Successful";
                    message = "Your payment has been processed.";
                }
                case "EVENT_CANCELLED" -> {
                    subject = "Event Cancelled";
                    message = "We regret to inform you that the event has been cancelled.";
                }
                default -> {
                    subject = "Notification";
                    message = "You have a new update.";
                }
            }
        }

        try {
            emailSender.send(event.getUserEmail(), subject, message);
            //Save the notification status for audit
            repository.save(Notification.builder()
                    .to(event.getUserEmail())
                    .subject(subject)
                    .message(message)
                    .type("EMAIL")
                    .sentAt(LocalDateTime.now())
                    .success(true)
                    .build());
        } catch (Exception e) {
            e.printStackTrace();
            repository.save(Notification.builder()
                    .to(event.getUserEmail())
                    .subject(subject)
                    .message(message)
                    .type("EMAIL")
                    .sentAt(LocalDateTime.now())
                    .success(false)
                    .build());
        }
    }
}

