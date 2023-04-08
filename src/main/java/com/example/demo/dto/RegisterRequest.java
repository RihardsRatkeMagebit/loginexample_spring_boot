package com.example.demo.dto;

import com.example.demo.anotation.ValueOfEnum;
import com.example.demo.model.Role;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank(message = "Username is a required field")
    @Pattern(regexp = "[a-z]{2,}", message = "Username must be at-least 2 chars long and all lowercase")
    private String username;

    @NotBlank(message = "password is a required field")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "Password must contain at-least 8 characters and 1 lower case letter and 1 upper case latter and 1 symbol"
    )
    private String password;

    @NotBlank(message = "Role is a required field")
    @ValueOfEnum(enumClass = Role.class, message = "Invalid role")
    private String role;
}
