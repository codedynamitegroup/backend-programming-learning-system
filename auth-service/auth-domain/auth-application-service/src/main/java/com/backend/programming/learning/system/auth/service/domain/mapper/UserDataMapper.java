package com.backend.programming.learning.system.auth.service.domain.mapper;

import com.backend.programming.learning.system.auth.service.domain.dto.method.create.user.CreateUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.user.CreateUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.delete.user.DeleteUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.message.user.UserRequest;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.user.QueryAllUsersResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.update.user.UpdateUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.update.user.UpdateUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.response_entity.user.UserEntityResponse;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.event.user.UserCreatedEvent;
import com.backend.programming.learning.system.auth.service.domain.event.user.UserCreatedFailEvent;
import com.backend.programming.learning.system.auth.service.domain.event.user.UserDeletedEvent;
import com.backend.programming.learning.system.auth.service.domain.event.user.UserEvent;
import com.backend.programming.learning.system.auth.service.domain.event.user.UserUpdatedEvent;
import com.backend.programming.learning.system.auth.service.domain.outbox.model.user.UserEventPayload;
import com.backend.programming.learning.system.domain.DomainConstants;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.util.List;
import java.util.UUID;

@Component
public class UserDataMapper {
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
                .userId(user.getId().getValue())
                .email(user.getEmail())
                .message(message)
                .build();
    }

    public UserEventPayload userCreatedEventToUserEventPayload(UserCreatedEvent userCreatedEvent) {
        User user = userCreatedEvent.getUser();
        return UserEventPayload.builder()
                .userId(user.getId().getValue().toString())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phone(user.getPhone())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .isDeleted(user.getDeleted())
                .copyState(CopyState.CREATING.name())
                .build();
    }

    public UserEventPayload userUpdatedEventToUserEventPayload(UserUpdatedEvent userUpdatedEvent) {
        User user = userUpdatedEvent.getUser();
        return UserEventPayload.builder()
                .userId(user.getId().getValue().toString())
                .dob(user.getDob())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phone(user.getPhone())
                .address(user.getAddress())
                .avatarUrl(user.getAvatarUrl())
                .updatedAt(user.getUpdatedAt())
                .copyState(CopyState.UPDATING.name())
                .build();
    }

    public UserEventPayload userDeletedEventToUserEventPayload(UserDeletedEvent userDeletedEvent) {
        User user = userDeletedEvent.getUser();
        return UserEventPayload.builder()
                .userId(user.getId().getValue().toString())
                .isDeleted(user.getDeleted())
                .copyState(CopyState.DELETING.name())
                .build();
    }

    public UserEntityResponse userToUserResponse(User user) {
        return UserEntityResponse.builder()
                .userId(user.getId().getValue())
                .email(user.getEmail())
                .dob(user.getDob())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phone(user.getPhone())
                .address(user.getAddress())
                .avatarUrl(user.getAvatarUrl())
                .lastIp(user.getLastIp())
                .lastLogin(user.getLastLogin())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .isDeleted(user.getDeleted())
                .build();
    }

    public QueryAllUsersResponse usersToQueryAllUsers(Page<User> users) {
        List<UserEntityResponse> userEntityResponses = users
                .map(this::userToUserResponse).getContent();
        return QueryAllUsersResponse.builder()
                .users(userEntityResponses)
                .currentPage(users.getNumber())
                .totalPages(users.getTotalPages())
                .totalItems(users.getTotalElements())
                .build();
    }

    public User updateUserCommandToUser(UpdateUserCommand updateUserCommand) {
        return User.builder()
                .id(new UserId(updateUserCommand.getUserId()))
                .dob(updateUserCommand.getDob())
                .firstName(updateUserCommand.getFirstName())
                .lastName(updateUserCommand.getLastName())
                .phone(updateUserCommand.getPhone())
                .address(updateUserCommand.getAddress())
                .avatarUrl(updateUserCommand.getAvatarUrl())
                .build();
    }

    public DeleteUserResponse deleteUserResponse(UUID userId, String message) {
        return DeleteUserResponse.builder()
                .userId(userId)
                .message(message)
                .build();
    }

    public UpdateUserResponse userToUpdateUserResponse(User userUpdated, String message) {
        return UpdateUserResponse.builder()
                .userId(userUpdated.getId().getValue())
                .message(message)
                .build();
    }

    public User userCreateRequestToUser(UserRequest userRequest) {
        return User.builder()
                .id(new UserId(UUID.fromString(userRequest.getUserId())))
                .email(userRequest.getEmail())
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .phone(userRequest.getPhone())
                .createdAt(userRequest.getCreatedAt().atZone(ZoneId.of(DomainConstants.UTC)))
                .updatedAt(userRequest.getUpdatedAt().atZone(ZoneId.of(DomainConstants.UTC)))
                .isDeleted(userRequest.getIsDeleted())
                .build();
    }

    public  UserEventPayload userEventToUserEventPayload(UserEvent userEvent, CopyState copyState) {
        return UserEventPayload.builder()
                .userId(userEvent.getUser().getId().getValue().toString())
                .copyState(copyState.name())
                .build();
    }

    public User userUpdateRequestToUser(UserRequest userUpdateRequest) {
        return User.builder()
                .id(new UserId(UUID.fromString(userUpdateRequest.getUserId())))
                .firstName(userUpdateRequest.getFirstName())
                .lastName(userUpdateRequest.getLastName())
                .address(userUpdateRequest.getAddress())
                .avatarUrl(userUpdateRequest.getAvatarUrl())
                .dob(userUpdateRequest.getDob().atZone(ZoneId.of(DomainConstants.UTC)))
                .phone(userUpdateRequest.getPhone())
                .updatedAt(userUpdateRequest.getUpdatedAt().atZone(ZoneId.of(DomainConstants.UTC)))
                .build();
    }
}
