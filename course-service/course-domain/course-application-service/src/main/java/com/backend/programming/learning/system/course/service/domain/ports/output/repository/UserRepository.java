package com.backend.programming.learning.system.course.service.domain.ports.output.repository;

import com.backend.programming.learning.system.course.service.domain.entity.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    User saveUser(User user);

    Optional<User> findUser(UUID userId);
}
