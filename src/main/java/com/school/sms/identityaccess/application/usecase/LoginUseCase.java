package com.school.sms.identityaccess.application.usecase;

import org.springframework.stereotype.Service;

import com.school.sms.identityaccess.domain.model.User;
import com.school.sms.identityaccess.domain.repository.UserRepository;
import com.school.sms.identityaccess.domain.valueobject.Username;
import com.school.sms.identityaccess.infrastructure.security.JwtUtil;

@Service
public class LoginUseCase {

    private final UserRepository repository;
    private final JwtUtil jwtUtil;

    public LoginUseCase(UserRepository repository, JwtUtil jwtUtil) {
        this.repository = repository;
        this.jwtUtil = jwtUtil;
    }

    public String execute(String username, String password) {

        User user = repository.findByUsername(new Username(username))
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().value().equals(password))
            throw new RuntimeException("Invalid credentials");

        return jwtUtil.generate(user.getUsername().value(), user.getRole());
    }
}

