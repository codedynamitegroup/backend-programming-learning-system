package com.backend.programming.learning.system.course.service.domain.ports.input.service.user;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.user.CreateUserCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.user.CreateUserResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.user.UpdateUserCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.user.UpdateUserResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.user.UserSubmissionAssignmentResponseEntity;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

public interface UserApplicationService {
    CreateUserResponse createUser(@Valid CreateUserCommand createUserCommand);
    UpdateUserResponse updateUser(@Valid UpdateUserCommand updateUserCommand);

    List<UserSubmissionAssignmentResponseEntity> queryAllUserByAssignmentId(UUID assignmentId);
}
