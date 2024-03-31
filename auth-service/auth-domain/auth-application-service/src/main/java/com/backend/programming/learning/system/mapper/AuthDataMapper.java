package com.backend.programming.learning.system.mapper;

import com.backend.programming.learning.system.dto.create.CreateUserCommand;
import com.backend.programming.learning.system.dto.create.CreateUserResponse;
import com.backend.programming.learning.system.entity.User;
import org.springframework.stereotype.Component;

@Component
public class AuthDataMapper {
    public User createUserCommandToUser(CreateUserCommand createUserCommand) {
        return User.builder()
                .email(createUserCommand.getEmail())
                .password(createUserCommand.getPassword())
                .firstName(createUserCommand.getFirstName())
                .lastName(createUserCommand.getLastName())
                .phone(createUserCommand.getPhone())
                .build();
    }

    public CreateUserResponse userToCreateUserResponse(User user, String message) {
        return CreateUserResponse.builder()
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phone(user.getPhone())
                .createdAt(user.getCreatedAt())
                .message(message)
                .build();
    }
}
