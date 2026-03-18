package com.example.CourseWeb.controller;

import com.example.CourseWeb.Payloads.LoginRequest;
import com.example.CourseWeb.Payloads.SignupRequest;
import com.example.CourseWeb.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<?> userSignUp(@RequestBody SignupRequest signupRequest){
        return ResponseEntity.status(HttpStatus.OK).body(authService.signUp(signupRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<?> userLogin(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.status(HttpStatus.OK).body(authService.login(loginRequest));
    }


}
