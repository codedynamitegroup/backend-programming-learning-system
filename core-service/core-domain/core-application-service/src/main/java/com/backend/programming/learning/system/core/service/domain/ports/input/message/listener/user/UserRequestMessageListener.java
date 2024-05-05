package com.backend.programming.learning.system.core.service.domain.ports.input.message.listener.user;

import com.backend.programming.learning.system.core.service.domain.dto.method.message.user.UserRequest;

public interface UserRequestMessageListener {
    void userCreated(UserRequest userCreateRequest);
    void userUpdated(UserRequest userUpdateRequest);
    void userDeleted(UserRequest userDeleteRequest);
}
