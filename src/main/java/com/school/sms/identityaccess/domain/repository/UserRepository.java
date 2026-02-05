package com.school.sms.identityaccess.domain.repository;


import com.school.sms.identityaccess.domain.model.User;
import com.school.sms.identityaccess.domain.valueobject.Username;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByUsername(Username username);
}

