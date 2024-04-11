package com.backend.programming.learning.system.auth.service.domain;

import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.domain.DomainConstants;
import com.backend.programming.learning.system.domain.event.publisher.DomainEventPublisher;
import lombok.extern.slf4j.Slf4j;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Slf4j
public class AuthDomainServiceImpl implements AuthDomainService {
    @Override
    public void createUser(User user) {
        user.initializeUser();
        log.info("User with id: {} is initiated", user.getId().getValue());
    }
}
