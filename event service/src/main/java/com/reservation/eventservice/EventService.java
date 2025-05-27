package com.reservation.eventservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * @author : El-Merjani Mohamed
 * Date : 5/26/2025
 */
@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventPublisher eventPublisher;


    public Event createEvent(Event event) {

        var createdEvent =  eventRepository.save(event);
        eventPublisher.send("event.created", event);
        return createdEvent;
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Optional<Event> getEventById(Long id) {
        return eventRepository.findById(id);
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    public List<Event> getEventsBetween(LocalDateTime from, LocalDateTime to) {
        return eventRepository.findByStartTimeBetween(from, to);
    }
}

