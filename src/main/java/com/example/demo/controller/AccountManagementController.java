package com.example.demo.controller;

import com.example.demo.dto.ActivationRequest;
import com.example.demo.dto.AuthenticationRequest;
import com.example.demo.dto.AuthenticationResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.User;
import com.example.demo.response.GenericResponse;
import com.example.demo.service.AccountManagementService;
import com.example.demo.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/account")
@RequiredArgsConstructor
public class AccountManagementController {

    private final AccountManagementService accountManagementService;

    @PostMapping("/register")
    public ResponseEntity<Object> register(
            @RequestBody RegisterRequest registerRequest
    ) {
        try {
            this.accountManagementService.register(registerRequest);
        } catch (UsernameNotFoundException exception) {
            return GenericResponse.generateResponse(exception.getMessage(), HttpStatus.OK, null);
        }

        return GenericResponse.generateResponse(
                "Successfully created user: {user}".replace("{user}", registerRequest.getUsername()),
                HttpStatus.OK,
                null
        );
    }

    @PostMapping("manageIsActive")
    public ResponseEntity<Object> manageIsActive(
            @RequestBody ActivationRequest activationRequest
    ) {
        try {
            accountManagementService.manageIsActive(activationRequest);
        } catch (UsernameNotFoundException exception) {
            return GenericResponse.generateResponse(exception.getMessage(), HttpStatus.OK, activationRequest);
        }

        return GenericResponse.generateResponse("Save went successfully", HttpStatus.OK, activationRequest);
    }
}
