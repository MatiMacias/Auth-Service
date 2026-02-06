package com.projects.auth_service.controller;

import com.projects.auth_service.dto.AuthResponse;
import com.projects.auth_service.dto.LoginRequest;
import com.projects.auth_service.dto.RegisterRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok("dummy-token");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok("dummy-token");
    }

}
