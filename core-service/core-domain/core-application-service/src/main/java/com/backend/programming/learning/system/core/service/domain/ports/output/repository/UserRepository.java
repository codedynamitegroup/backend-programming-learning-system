package com.backend.programming.learning.system.core.service.domain.ports.output.repository;

import com.backend.programming.learning.system.domain.entity.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findUserByEmail(String email);
    Optional<User> findUserInformation(User user);
}
