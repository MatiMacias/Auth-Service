package com.projects.auth_service.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final PasswordEncoder passwordEncoder;

    public AuthService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public String register(String email, String password){

        String hashedPassword = passwordEncoder.encode(password)

        return "dommy-token";
    }

    public String login(String username, String password){

        String storedHash = "hash-falso";

        boolean matches = passwordEncoder.matches(password, storedHash);

        if(!matches){
            throw new RuntimeException("Credenciales invalidas");
        }

        return "dommy-token";
    }
}
