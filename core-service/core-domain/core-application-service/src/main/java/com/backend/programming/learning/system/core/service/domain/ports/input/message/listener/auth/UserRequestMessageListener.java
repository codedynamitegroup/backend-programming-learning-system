package com.backend.programming.learning.system.core.service.domain.ports.input.message.listener.auth;

import com.backend.programming.learning.system.core.service.domain.dto.method.message.UserRequest;

public interface UserRequestMessageListener {
    void userCreateSuccess(UserRequest userRequest);
}
