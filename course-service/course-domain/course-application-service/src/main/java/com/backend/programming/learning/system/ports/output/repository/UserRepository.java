package com.backend.programming.learning.system.ports.output.repository;

import com.backend.programming.learning.system.entity.User;

public interface UserRepository {
    User saveUser(User user);
}
