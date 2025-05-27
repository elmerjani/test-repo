package com.reservation.usermanagement.dto;

/**
 * @author : El-Merjani Mohamed
 * Date : 5/26/2025
 */

public class JwtResponse {

    private String token;
    private String type = "Bearer"; // optional, often useful for frontend
    private String username;
    private String role;

    public JwtResponse(String token, String username, String role) {
        this.token = token;
        this.username = username;
        this.role = role;
    }

    public JwtResponse(String token) {
    }
}
