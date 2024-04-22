package com.backend.programming.learning.system.core.service.domain.implement.message.listener.user;

import com.backend.programming.learning.system.core.service.domain.dto.method.message.UserRequest;
import com.backend.programming.learning.system.core.service.domain.ports.input.message.listener.auth.UserRequestMessageListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
public class UserRequestMessageListenerImpl implements UserRequestMessageListener {
    @Override
    public void userCreateSuccess(UserRequest userRequest) {

    }
}
