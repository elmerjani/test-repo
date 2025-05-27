package com.reservation.notificationservice;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.management.Notification;

/**
 * @author : El-Merjani Mohamed
 * Date : 5/27/2025
 */
public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
