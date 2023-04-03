package com.example.demo.service;


import com.example.demo.config.JwtService;
import com.example.demo.config.SecurityConfiguration;
import com.example.demo.dto.AuthenticationRequest;
import com.example.demo.dto.AuthenticationResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationRequest.getUsername(),
                            authenticationRequest.getPassword()
                    )
            );
        } catch (AuthenticationException exception) {
            User user = repository.findByUsername(authenticationRequest.getUsername()).orElseThrow();
            int failedAttemptCount = user.getFailedAttempts();
            if (user.getFailedAttempts() > SecurityConfiguration.MAX_FAILED_ATTEMPTS){
                user.setFailedAttempts(failedAttemptCount);
                user.setActive(false);
            }else {
                user.setFailedAttempts(failedAttemptCount + 1);
            }
            repository.save(user);
            return AuthenticationResponse.builder().build();
        }

        User user = repository.findByUsername(authenticationRequest.getUsername()).orElseThrow();

        String jwtToken = jwtService.generateToken(user);

        if (!user.isActive){
            jwtToken = null;
        }else {
            user.setFailedAttempts(0);
            repository.save(user);
        }

        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse register(RegisterRequest registerRequest) {
        User user = User
                .builder()
                .username(registerRequest.getUsername())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .isActive(true)
                .role(Role.USER)
                .build();

        if (repository.findByUsername(registerRequest.getUsername()).isPresent()) {
            return AuthenticationResponse.builder().build();
        }

        repository.save(user);
        String jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .build();
    }
}
