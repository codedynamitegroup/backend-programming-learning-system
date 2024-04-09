package com.backend.programming.learning.system;

import com.backend.programming.learning.system.entity.User;
import com.backend.programming.learning.system.event.UserCreatedEvent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthDomainServiceImpl implements AuthDomainService {


    @Override
    public UserCreatedEvent createUser(User user) {
        return null;
    }
}
