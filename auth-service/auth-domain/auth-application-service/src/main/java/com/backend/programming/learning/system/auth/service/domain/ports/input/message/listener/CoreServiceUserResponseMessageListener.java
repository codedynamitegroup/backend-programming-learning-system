package com.backend.programming.learning.system.auth.service.domain.ports.input.message.listener;

import com.backend.programming.learning.system.auth.service.domain.dto.method.message.UserResponse;

public interface CoreServiceUserResponseMessageListener {
    void userCreatedUpdatedOrDeletedFail(UserResponse userResponse);
    void userCreatedUpdatedOrDeletedSuccess(UserResponse userResponse);
}
