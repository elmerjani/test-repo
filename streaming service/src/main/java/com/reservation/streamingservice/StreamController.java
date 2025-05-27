package com.reservation.streamingservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author : El-Merjani Mohamed
 * Date : 5/26/2025
 */
@RestController
@RequestMapping("/streams")
public class StreamController {

    @Autowired
    private StreamService streamService;

    @GetMapping("/{id}")
    public ResponseEntity<StreamDto> getStream(@PathVariable String id) {
        // check if stream is LIVE
        // return HLS URL or WebRTC signaling info
        return streamService.get(id);
    }

    @PostMapping
    public ResponseEntity<StreamDto> createStream(@RequestBody StreamDto StreamDto) {
        return streamService.create(StreamDto);
    }

    @PostMapping("/start")
    public ResponseEntity<Void> startStream(@RequestBody String streamKey) {
        // validate stream key
        // mark stream as LIVE
        return streamService.startStream(streamKey);
    }

    @PostMapping("/stop")
    public ResponseEntity<Void> stopStream(@RequestBody String streamKey) {
        // mark stream as ENDED
        return streamService.stopStream(streamKey);
    }
}
