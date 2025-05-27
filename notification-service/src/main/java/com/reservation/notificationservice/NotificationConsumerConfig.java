package com.reservation.notificationservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

/**
 * @author : El-Merjani Mohamed
 * Date : 5/27/2025
 */
@Configuration
public class NotificationConsumerConfig {

    @Autowired
    private final NotificationService notificationService;

    @Bean
    public Consumer<NotificationEvent> eventConsumer(){
        return event ->{
            notificationService.processEvent(event);
        };
    }
}
