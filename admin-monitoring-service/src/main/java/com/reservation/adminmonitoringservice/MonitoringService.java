package com.reservation.adminmonitoringservice;

import org.springframework.stereotype.Service;

/**
 * @author : El-Merjani Mohamed
 * Date : 5/27/2025
 */
@Service
@RequiredArgsConstructor
public class MonitoringService {

    private final MetricLogRepository repository;

    public MonitoringStatsResponse getStats() {
        return null;
    }
    public List<MetricLog> getAllLogs(){
        return null;
    }

}
