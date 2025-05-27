package com.reservation.adminmonitoringservice;

/**
 * @author : El-Merjani Mohamed
 * Date : 5/27/2025
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;

    @PostMapping("/ban-user/{id}")
    public ResponseEntity<Void> banUser(@PathVariable Long id) {
        adminService.banUser(id);
        return ResponseEntity.ok().build();
    }


    @PostMapping("/stop-stream/{id}")
    public ResponseEntity<Void> stopStream(@PathVariable Long id) {
        adminService.stopStream(id);
        return ResponseEntity.ok().build();
    }
}
