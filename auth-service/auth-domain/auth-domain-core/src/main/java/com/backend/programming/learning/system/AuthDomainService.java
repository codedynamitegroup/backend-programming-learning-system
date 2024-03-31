package com.backend.programming.learning.system;

import com.backend.programming.learning.system.entity.User;
import com.backend.programming.learning.system.event.UserCreatedEvent;

public interface AuthDomainService {
    UserCreatedEvent createUser(User user);
}
