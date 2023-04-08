package com.example.demo.service;


import com.example.demo.dto.ActivationRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface AccountManagementServiceInterface {
    public void register(RegisterRequest registerRequest) throws UsernameNotFoundException;

    public void manageIsActive(ActivationRequest activationRequest, boolean is_active) throws UsernameNotFoundException;
}
