package com.reservation.streamingservice;

import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 * @author : El-Merjani Mohamed
 * Date : 5/27/2025
 */

@Entity
@Table(name = "streams")
public class Stream {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String streamKey;

    private String hlsUrl;

    private String status; // LIVE, ENDED, UPCOMING

    private LocalDateTime startTime;

    private LocalDateTime endTime;

}

