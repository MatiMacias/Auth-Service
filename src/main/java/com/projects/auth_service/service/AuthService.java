package com.projects.auth_service.service;

import com.projects.auth_service.dto.RegisterRequest;
import com.projects.auth_service.model.Role;
import com.projects.auth_service.model.User;
import com.projects.auth_service.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtService jwtService;

    public AuthService(PasswordEncoder passwordEncoder, UserRepository userRepository, JwtService jwtService) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    public String register(RegisterRequest request){

        if(userRepository.findByUsername(request.getUsername()).isPresent()){
            throw new RuntimeException("The user is already exists");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.USER);

        userRepository.save(user);

        return "The user has successfully registered";
    }

    public String login(String username, String password){

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        boolean matches = passwordEncoder.matches(password, user.getPassword());

        if(!matches){
            throw new RuntimeException("Invalid credentials");
        }

        return jwtService.generateToken(user);
    }
}
