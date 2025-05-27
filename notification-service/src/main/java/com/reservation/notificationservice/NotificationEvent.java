package com.reservation.notificationservice;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : El-Merjani Mohamed
 * Date : 5/27/2025
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "notifications")
public class NotificationEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "event_type", nullable = false)
    private String eventType;     // e.g., "RESERVATION_CONFIRMED"

    @Column(name = "user_email", nullable = false)
    private String userEmail;     // Target recipient

    @Column(nullable = true)
    private String subject;       // Optional override

    @Column(columnDefinition = "TEXT", nullable = true)
    private String message;       // Optional override
}
