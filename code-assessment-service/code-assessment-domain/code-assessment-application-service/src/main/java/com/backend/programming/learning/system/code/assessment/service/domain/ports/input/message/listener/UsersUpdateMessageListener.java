package com.backend.programming.learning.system.code.assessment.service.domain.ports.input.message.listener;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.message.UsersUpdate;

public interface UsersUpdateMessageListener {
    void createUser(UsersUpdate usersUpdate);
    void updateUser(UsersUpdate usersUpdate);
    void deleteUser(UsersUpdate usersUpdate);

}
