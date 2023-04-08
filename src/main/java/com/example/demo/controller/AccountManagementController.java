package com.example.demo.controller;

import com.example.demo.dto.ActivationRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.response.GenericResponse;
import com.example.demo.service.AccountManagementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/account")
@RequiredArgsConstructor
public class AccountManagementController {

    private final AccountManagementService accountManagementService;
    private final Logger logger = LoggerFactory.getLogger(AccountManagementController.class);

    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<Object> register(
            @Valid @RequestBody  RegisterRequest registerRequest
    ) {
        try {
            this.accountManagementService.register(registerRequest);
        } catch (UsernameNotFoundException exception) {
            logger.warn(exception.getMessage());
            return GenericResponse.generateResponse(exception.getMessage(), HttpStatus.OK, null);
        }

        return GenericResponse.generateResponse(
                "Successfully created user: {user}".replace("{user}", registerRequest.getUsername()),
                HttpStatus.OK,
                null
        );
    }

    @PostMapping("activate")
    @ResponseBody
    public ResponseEntity<Object> activate(
            @RequestBody ActivationRequest activationRequest
    ) {
        try {
            accountManagementService.manageIsActive(activationRequest, true);
        } catch (UsernameNotFoundException exception) {
            logger.warn(exception.getMessage());
            return GenericResponse.generateResponse(exception.getMessage(), HttpStatus.OK, activationRequest);
        }

        return GenericResponse.generateResponse("Activated user successfully", HttpStatus.OK, activationRequest);
    }

    @PostMapping("disable")
    @ResponseBody
    public ResponseEntity<Object> disable(
            @RequestBody ActivationRequest activationRequest
    ) {
        try {
            accountManagementService.manageIsActive(activationRequest, false);
        } catch (UsernameNotFoundException exception) {
            logger.warn(exception.getMessage());
            return GenericResponse.generateResponse(exception.getMessage(), HttpStatus.OK, activationRequest);
        }

        return GenericResponse.generateResponse("Disabled user successfully", HttpStatus.OK, activationRequest);
    }
}
