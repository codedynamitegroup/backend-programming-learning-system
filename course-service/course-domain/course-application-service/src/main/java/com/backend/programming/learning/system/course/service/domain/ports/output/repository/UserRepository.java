package com.backend.programming.learning.system.course.service.domain.ports.output.repository;

import com.backend.programming.learning.system.course.service.domain.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    User save(User user);

    Optional<User> findUser(UUID userId);

    Optional<User> findUserByEmail(String email);

    Optional<User> findByUserIdMoodle(Integer userIdMoodle);

    List<User> findAll();
}
