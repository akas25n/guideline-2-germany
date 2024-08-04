package com.guideline2germany.config;

import com.guideline2germany.entity.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;

public class CustomUserDetails extends org.springframework.security.core.userdetails.User {

    private String firstName;
    private String lastName;

    public CustomUserDetails(User user) {
        super(
                user.getEmail(),
                user.getPassword(),
                Collections.singletonList(
                        new SimpleGrantedAuthority(user.getRole().name())
                )
        );
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
