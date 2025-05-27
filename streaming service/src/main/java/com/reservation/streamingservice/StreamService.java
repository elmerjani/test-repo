package com.reservation.streamingservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author : El-Merjani Mohamed
 * Date : 5/26/2025
 */
@Service
public class StreamService {

    @Autowired
    private StreamRepository repository;

    public Stream startStream(Long eventId) {
        return null;
    }

    public Stream stopStream(Long eventId) {
        return null;
    }



    public Stream get(String id) {
        return null;
    }

    public Stream create(StreamDto streamDto) {
        return null;
    }
}

