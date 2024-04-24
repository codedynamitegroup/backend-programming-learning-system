package com.backend.programming.learning.system.auth.service.domain.ports.input.message.listener;

import com.backend.programming.learning.system.auth.service.domain.dto.method.message.UserResponse;

public interface CoreServiceUserResponseMessageListener {
    void userUpdatedFail(UserResponse userResponse);
    void userUpdatedSuccess(UserResponse userResponse);
    void userCreateFail(UserResponse userResponse);
    void userCreateSuccess(UserResponse userResponse);
    void userDeleteFail(UserResponse userResponse);
    void userDeleteSuccess(UserResponse userResponse);
}
