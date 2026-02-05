package com.school.sms.identityaccess.infrastructure.persistence;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.school.sms.identityaccess.domain.model.User;
import com.school.sms.identityaccess.domain.repository.UserRepository;
import com.school.sms.identityaccess.domain.valueobject.Password;
import com.school.sms.identityaccess.domain.valueobject.Username;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository jpa;

    public UserRepositoryImpl(UserJpaRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public Optional<User> findByUsername(Username username) {
        return jpa.findById(username.value())
                .map(e -> new User(new Username(e.getUsername()),
                                   new Password(e.getPassword()),
                                   e.getRole()));
    }
}
