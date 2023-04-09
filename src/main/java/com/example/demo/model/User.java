package com.example.demo.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document("users")
public class User implements UserDetails {
    public static final String FIELD_USERNAME = "username";
    public static final String FIELD_PASSWORD = "password";
    private static final String ROLE_PREFIX = "ROLE_";

    @Id
    public ObjectId id;

    @Min(value = 2, message = "Username must contain at least 2 characters")
    @Max(value = 20, message = "Username cannot exceed 20 characters")
    @Indexed(unique = true)
    public String username;

    public String password;

    @Field(name = "is_active")
    public boolean isActive;

    @Field(name = "failed_attempt_counter")
    public int failedAttempts;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String slug;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(ROLE_PREFIX + role.name()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isActive;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }

}

