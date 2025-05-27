package com.reservation.adminmonitoringservice;

import java.util.List;

/**
 * @author : El-Merjani Mohamed
 * Date : 5/27/2025
 */
@RestController
@RequestMapping("/monitoring")
public class MonitoringController {
    private final MonitoringService monitoringService;

    @GetMapping("/stats")
    public MonitoringStatsResponse getStats() {
        return monitoringService.aggregateStats();
    }
    @GetMappint("/logs")
    public List<MetricLog> getAllLogs(){
        return monitoringService.getAllLogs();
    }


}
