package com.example.demo.dto;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    @Pattern(regexp = "[a-z]{2,}", message = "username must be at-least 2 chars long and all lowercase")
    private String username;

    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "Password must contain at-least 8 characters and 1 lower case letter and 1 upper case latter and 1 symbol"
    )
    private String password;

    private String role;
}
