package com.backend.programming.learning.system.auth.service.domain.implement.user;

import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.delete.DeleteUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.delete.DeleteUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryUserResponse;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.event.UserCreatedEvent;
import com.backend.programming.learning.system.auth.service.domain.event.UserDeletedEvent;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthNotFoundException;
import com.backend.programming.learning.system.auth.service.domain.mapper.UserDataMapper;
import com.backend.programming.learning.system.auth.service.domain.ports.output.message.publisher.user.UserCreatedMessagePublisher;
import com.backend.programming.learning.system.auth.service.domain.ports.output.message.publisher.user.UserDeletedMessagePublisher;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class UserCommandHandler {

    private final UserCreateHelper userCreateHelper;
    private final UserDeleteHelper userDeleteHelper;
    private final UserDataMapper userDataMapper;
    private final UserRepository userRepository;
    private final UserCreatedMessagePublisher userCreatedMessagePublisher;
    private final UserDeletedMessagePublisher userDeletedMessagePublisher;

    public UserCommandHandler(UserCreateHelper userCreateHelper, UserDeleteHelper userDeleteHelper, UserDataMapper userDataMapper, UserRepository userRepository, UserCreatedMessagePublisher userCreatedMessagePublisher, UserDeletedMessagePublisher userDeletedMessagePublisher) {
        this.userCreateHelper = userCreateHelper;
        this.userDeleteHelper = userDeleteHelper;
        this.userDataMapper = userDataMapper;
        this.userRepository = userRepository;
        this.userCreatedMessagePublisher = userCreatedMessagePublisher;
        this.userDeletedMessagePublisher = userDeletedMessagePublisher;
    }

    public CreateUserResponse createUser(CreateUserCommand createOrderCommand) {
        UserCreatedEvent userCreatedEvent = userCreateHelper.persistUser(createOrderCommand);
        log.info("User is created with id: {}", userCreatedEvent.getUser().getId().getValue());
        userCreatedMessagePublisher.publish(userCreatedEvent);
        return userDataMapper.userToCreateUserResponse(userCreatedEvent.getUser(),
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

    @Transactional(readOnly = true)
    public List<QueryUserResponse> queryAllUsers() {
        return userRepository.findAll().stream()
                .map(userDataMapper::userToQueryUserResponse)
                .toList();
    }


    public DeleteUserResponse deleteUser(DeleteUserCommand deleteUserCommand) {
        UserDeletedEvent userDeletedEvent = userDeleteHelper.deleteUser(deleteUserCommand);
        log.info("User is deleted with id: {}", deleteUserCommand.getUserId());
        userDeletedMessagePublisher.publish(userDeletedEvent);
        return DeleteUserResponse.builder()
                .message("User deleted successfully")
                .build();
    }
}
