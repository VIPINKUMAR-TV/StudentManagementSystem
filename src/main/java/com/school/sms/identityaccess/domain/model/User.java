package com.school.sms.identityaccess.domain.model;

import com.school.sms.identityaccess.domain.valueobject.Username;
import com.school.sms.identityaccess.domain.valueobject.Password;

public class User {

    private final Username username;
    private final Password password;
    private final String role; // ADMIN or STUDENT

    public User(Username username, Password password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Username getUsername() { return username; }
    public Password getPassword() { return password; }
    public String getRole() { return role; }
}
