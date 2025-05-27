package com.reservation.adminmonitoringservice;

import org.springframework.stereotype.Service;

/**
 * @author : El-Merjani Mohamed
 * Date : 5/27/2025
 */
@Service
@RequiredArgsConstructor
public class AdminService {
    private final UserClient userClient;
    private final EventClient eventClient;
    private final StreamClient streamClient;

    public void banUser(Long id) {
        userClient.ban(id);
    }


    public void stopStream(Long id) {
        streamClient.stop(id);
    }
}
