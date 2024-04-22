package com.backend.programming.learning.system.auth.service.domain.ports.input.message.listener;

import com.backend.programming.learning.system.auth.service.domain.dto.method.message.UserResponse;

public interface CoreServiceUserResponseMessageListener {
    void userUpdatedFail(UserResponse userRequest);
    void userUpdatedSuccess(UserResponse userRequest);
    void userCreateFail(UserResponse userRequest);
    void userCreateSuccess(UserResponse userRequest);
    void userDeleteFail(UserResponse userRequest);
    void userDeleteSuccess(UserResponse userRequest);
}
