package com.example.hospitalManagement.controllers;

import com.example.hospitalManagement.dto.LoginRequestDto;
import com.example.hospitalManagement.dto.LoginResponseDto;
import com.example.hospitalManagement.dto.SignUpResponseDto;
import com.example.hospitalManagement.security.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto){
        return ResponseEntity.ok(authService.login(loginRequestDto));
    }

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseDto> signup(@RequestBody LoginRequestDto signupDto){
        System.out.println("HERE IN CONTROLLER");
        return ResponseEntity.ok(authService.signup(signupDto));
    }

    @PostMapping("/test")
    public String test() {
        System.out.println("HERE IN CONTROLLER 2");
        return "Auth controller working!";
    }

}
