package com.backend.programming.learning.system.auth.service.domain;

import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.delete.DeleteUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.delete.DeleteUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryUserResponse;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthNotFoundException;
import com.backend.programming.learning.system.auth.service.domain.mapper.UserDataMapper;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Component
public class UserCommandHandler {

    private final UserCreateHelper userCreateHelper;
    private final UserDeleteHelper userDeleteHelper;
    private final UserDataMapper userDataMapper;
    private final UserRepository userRepository;

    public UserCommandHandler(UserCreateHelper userCreateHelper, UserDeleteHelper userDeleteHelper, UserDataMapper userDataMapper, UserRepository userRepository) {
        this.userCreateHelper = userCreateHelper;
        this.userDeleteHelper = userDeleteHelper;
        this.userDataMapper = userDataMapper;
        this.userRepository = userRepository;
    }

    public CreateUserResponse createUser(CreateUserCommand createOrderCommand) {
        User userCreated = userCreateHelper.persistUser(createOrderCommand);
        log.info("User is created with id: {}", userCreated.getId().getValue());
        return userDataMapper.userToCreateUserResponse(userCreated,
                "User created successfully");
    }

    @Transactional(readOnly = true)
    public QueryUserResponse queryUser(QueryUserCommand queryUserCommand) {
        Optional<User> userResult =
                userRepository.findById(new UserId(queryUserCommand.getUserId()));
        if (userResult.isEmpty()) {
            log.warn("Could not find user with user id: {}", queryUserCommand.getUserId());
            throw new AuthNotFoundException("Could not find user with user id: " +
                    queryUserCommand.getUserId());
        }
        return userDataMapper.userToQueryUserResponse(userResult.get());
    }

    public DeleteUserResponse deleteUser(DeleteUserCommand deleteUserCommand) {
        userDeleteHelper.deleteUser(deleteUserCommand);
        log.info("User is deleted with id: {}", deleteUserCommand.getUserId());
        return DeleteUserResponse.builder()
                .message("User deleted successfully")
                .build();
    }
}
