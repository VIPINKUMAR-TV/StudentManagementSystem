package com.school.sms.identityaccess.presentation;


import com.school.sms.identityaccess.application.usecase.LoginUseCase;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final LoginUseCase loginUseCase;

    public AuthController(LoginUseCase loginUseCase) {
        this.loginUseCase = loginUseCase;
    }

    /**
     * Login endpoint for Admin and Student
     * Returns JWT token if credentials are valid
     */
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password) {

        return loginUseCase.execute(username, password);
    }
}

