package com.reservation.adminmonitoringservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.function.Consumer;

/**
 * @author : El-Merjani Mohamed
 * Date : 5/27/2025
 */
public class MetricConsumer {

    private final Path logFilePath = Paths.get(System.getProperty("user.dir"), "logs", "metrics.log");
    private ObjectOutputStream logStream = new ObjectOutputStream(Files.newOutputStream(logFilePath));

    @Bean
    public Consumer<MetricLog> consumeMetricLog() {
        return log -> {
            try {

                // Format log entry
                String logLine = log.toString() + System.lineSeparator();

                logStream.writeObject(log);

                // Optionally print to console
                System.out.println("Logged: " + logLine);

            } catch (IOException e) {
                e.printStackTrace(); // Or use a logger
            }
        };
    }
}
