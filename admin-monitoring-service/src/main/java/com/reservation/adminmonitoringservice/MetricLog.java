package com.reservation.adminmonitoringservice;

/**
 * @author : El-Merjani Mohamed
 * Date : 5/27/2025
 */
@Entity
public class MetricLog {
    @Id
    @GeneratedValue
    private Long id;

    private String service;
    private String type;
    private String payload;
    private LocalDateTime timestamp;
}
