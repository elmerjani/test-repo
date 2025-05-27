package com.reservation.usermanagement.dto;

import java.time.LocalDate;

/**
 * @author : El-Merjani Mohamed
 * Date : 5/26/2025
 */
public class RegisterRequest {

    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String username;
    private String password;
    private String email;
    private String role;
    private String phone;
}
