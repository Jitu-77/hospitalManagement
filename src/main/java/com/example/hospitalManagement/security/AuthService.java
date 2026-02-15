package com.example.hospitalManagement.security;

import com.example.hospitalManagement.dto.LoginRequestDto;
import com.example.hospitalManagement.dto.LoginResponseDto;
import com.example.hospitalManagement.dto.SignUpResponseDto;
import com.example.hospitalManagement.entity.User;
import com.example.hospitalManagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final AuthUtil authUtil;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public LoginResponseDto login(LoginRequestDto loginRequestDto) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(), loginRequestDto.getPassword())
        );
        User user = (User) authentication.getPrincipal();

        String token = authUtil.generateAccessToken(user);

        return  new LoginResponseDto(token,user.getId());

    }

    public SignUpResponseDto signup(LoginRequestDto signupRequestDto) {
        System.out.println("signupRequestDto ---- "+signupRequestDto);
        User user = userRepository.findByUsername(signupRequestDto.getUsername()).orElse(null);
        if(user != null) throw new IllegalArgumentException("User already exists");
        System.out.println("signupRequestDto inside user ---- "+user);
        user = userRepository.save(
                User.builder()
                        .username(signupRequestDto.getUsername())
                        .password(passwordEncoder.encode(signupRequestDto.getPassword()))
                        .build()
        ) ;
        // we need to return via model mapper
        //but as now there is no model mapper we will return via creating new Object
        return  new SignUpResponseDto(user.getId(), user.getUsername());

    }
}
