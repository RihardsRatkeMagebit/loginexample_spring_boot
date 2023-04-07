package com.example.demo.service;


import com.example.demo.dto.TokenValidationRequest;
import com.example.demo.exception.InvalidTokenDataException;
import com.example.demo.model.User;
import lombok.RequiredArgsConstructor;
import com.example.demo.config.JwtService;
import com.example.demo.dto.AuthenticationRequest;
import com.example.demo.config.SecurityConfiguration;
import com.example.demo.dto.AuthenticationResponse;
import com.example.demo.model.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
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
            if (user.getFailedAttempts() > SecurityConfiguration.MAX_FAILED_ATTEMPTS) {
                user.setFailedAttempts(failedAttemptCount);
                user.setActive(false);
            } else {
                user.setFailedAttempts(failedAttemptCount + 1);
            }
            repository.save(user);

            return AuthenticationResponse.builder().build();
        }

        User user = repository.findByUsername(authenticationRequest.getUsername()).orElseThrow();

        String jwtToken = jwtService.generateToken(user);

        if (!user.isActive) {
            jwtToken = null;
        } else {
            user.setFailedAttempts(0);
            repository.save(user);
        }

        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .role(user.getRole())
                .build();
    }
}
