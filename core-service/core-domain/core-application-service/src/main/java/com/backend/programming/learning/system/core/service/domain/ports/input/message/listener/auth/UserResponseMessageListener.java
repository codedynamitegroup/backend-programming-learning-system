package com.backend.programming.learning.system.core.service.domain.ports.input.message.listener.auth;

public interface UserResponseMessageListener {
//    void userCreated(UserModel userModel);
//    void userUpdated(UserModel userModel);
    void userDeleted(String userId);
}
