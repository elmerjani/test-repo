package com.reservation.eventservice;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author : El-Merjani Mohamed
 * Date : 5/26/2025
 */
@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String location;
    private int numberOfPlacesAvailable;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Long organizerId;
    private String category;
    private LocalDate createdAt;
    private LocalDate updatedAt;



}

