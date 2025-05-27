package com.reservation.usermanagement;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author : El-Merjani Mohamed
 * Date : 5/26/2025
 */
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String username;
    private String password;
    private String email;
    private String role;
    private String phone;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}