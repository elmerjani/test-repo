package com.reservation.usermanagement;

import com.reservation.usermanagement.dto.JwtResponse;
import com.reservation.usermanagement.dto.LoginRequest;
import com.reservation.usermanagement.dto.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author : El-Merjani Mohamed
 * Date : 5/26/2025
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(userService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        String token = userService.login(request);
        return ResponseEntity.ok(new JwtResponse(token));
    }


}

