package com.backend.programming.learning.system.code.assessment.service.domain.ports.input.message.listener;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.message.user.UserRequest;

public interface UserRequestMessageListener {
    void userCreated(UserRequest userCreateRequest);
    void userUpdated(UserRequest userUpdateRequest);
    void userDeleted(UserRequest userDeleteRequest);
}
