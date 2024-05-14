package com.backend.programming.learning.system.auth.service.domain.ports.input.message.listener.user;

import com.backend.programming.learning.system.auth.service.domain.dto.method.message.user.UserRequest;
import org.springframework.stereotype.Component;

@Component
public interface UserRequestMessageListener {
    void userCreated(UserRequest userCreateRequest);
    void userUpdated(UserRequest userUpdateRequest);
    void userDeleted(UserRequest userDeleteRequest);
}
