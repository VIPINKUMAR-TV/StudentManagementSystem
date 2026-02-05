package com.school.sms.identityaccess.application.usecase;


import com.school.sms.identityaccess.domain.model.User;
import com.school.sms.identityaccess.domain.repository.UserRepository;
import com.school.sms.identityaccess.domain.valueobject.Password;
import com.school.sms.identityaccess.domain.valueobject.Username;
import com.school.sms.identityaccess.infrastructure.security.JwtUtil;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@org.junit.jupiter.api.extension.ExtendWith(MockitoExtension.class)
class LoginUseCaseTest {

    @Mock
    private UserRepository repository;

    @Mock
    private JwtUtil jwtUtil;

    @InjectMocks
    private LoginUseCase useCase;

    @Test
    void shouldReturnTokenWhenCredentialsAreValid() {

        User user = new User(new Username("admin"),
                             new Password("admin123"),
                             "ADMIN");

        when(repository.findByUsername(new Username("admin")))
                .thenReturn(Optional.of(user));

        when(jwtUtil.generate("admin", "ADMIN"))
                .thenReturn("fake-token");

        String token = useCase.execute("admin", "admin123");

        assertEquals("fake-token", token);
    }
}

