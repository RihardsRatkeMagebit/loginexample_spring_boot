package com.example.demo.dto;

import com.example.demo.model.User;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class UserDTO {
    @NotBlank(message = "username is required field")
    public String username;

    public String password;

    /**
     * Converts User into UserDTO
     *
     * @param user
     * @return self
     */
    public UserDTO convert(User user) {
        this.setUsername(user.getUsername());
        this.setPassword("********");

        return this;
    }
}

