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
@RequiredArgsConstructor
public class AccountManagementService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public void register(RegisterRequest registerRequest) throws UsernameNotFoundException {
        if (repository.findByUsername(registerRequest.getUsername()).isPresent()) {
            throw new UsernameNotFoundException("Username already taken");
        }

        User user = User.builder().username(registerRequest.getUsername()).password(passwordEncoder.encode(registerRequest.getPassword())).isActive(true).role(Role.valueOf(registerRequest.getRole())).build();

        try {
            repository.save(user);
        } catch (RuntimeException e) {
            throw new UsernameNotFoundException("User cannot be created");
        }
    }

    public void manageIsActive(ActivationRequest activationRequest) throws UsernameNotFoundException {
        Optional<User> user = repository.findByUsername(activationRequest.getUsername());

        if (user.isEmpty()) {
            throw new UsernameNotFoundException("user with such username doesn't exist");
        }

        try {
            user.ifPresent(loadedUser -> {
                loadedUser.setActive(activationRequest.is_activate());
                repository.save(loadedUser);
            });
        } catch (RuntimeException exception) {
            throw new UsernameNotFoundException("Cannot save user");
        }
    }
}
