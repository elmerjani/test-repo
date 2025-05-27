package com.reservation.eventservice;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : El-Merjani Mohamed
 * Date : 5/26/2025
 */
public interface EventRepository extends JpaRepository<Event, Long> {
}
