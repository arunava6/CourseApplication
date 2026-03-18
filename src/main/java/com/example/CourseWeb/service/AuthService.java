package com.example.CourseWeb.service;

import com.example.CourseWeb.Payloads.LoginRequest;
import com.example.CourseWeb.Payloads.LoginResponse;
import com.example.CourseWeb.Payloads.SignupRequest;
import com.example.CourseWeb.Security.JwtUtil;
import com.example.CourseWeb.model.User;
import com.example.CourseWeb.repositories.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepo userRepo;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public String signUp(SignupRequest signupRequest) {
        User newUser = new User();
        newUser.setEmail(signupRequest.getEmail());
        newUser.setName(signupRequest.getName());
        newUser.setPassword(passwordEncoder.encode(signupRequest.getPassword()));

        userRepo.save(newUser);

        return "User Sign Up Successfully";
    }

    public LoginResponse login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
        );

        String email = authentication.getName();
        User user = userRepo.findByEmail(email).orElseThrow(
                () -> new RuntimeException("email not found")
        );
        String token = jwtUtil.generateToken(user.getEmail());

        return LoginResponse.builder()
                .token(token)
                .issuedAt(LocalDateTime.now())
                .build();
    }
}
