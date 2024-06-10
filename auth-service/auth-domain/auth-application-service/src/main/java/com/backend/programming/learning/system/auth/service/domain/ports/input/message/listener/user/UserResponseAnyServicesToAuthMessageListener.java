package com.backend.programming.learning.system.auth.service.domain.ports.input.message.listener.user;

import com.backend.programming.learning.system.auth.service.domain.dto.method.message.user.UserResponse;

public interface UserResponseAnyServicesToAuthMessageListener {
    void userCreatedUpdatedOrDeletedFail(UserResponse userResponse);
    void userCreatedUpdatedOrDeletedSuccess(UserResponse userResponse);
}
