package com.backend.programming.learning.system.core.service.domain.ports.output.repository;

import com.backend.programming.learning.system.core.service.domain.entity.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    Optional<User> findUser(UUID userId);
    Optional<User> findUserByEmail(String email);
    User save(User user);
    Optional<User> findByUsername(String username);
}
