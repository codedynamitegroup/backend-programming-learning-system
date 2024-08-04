package com.backend.programming.learning.system.auth.service.domain.mapper;

import com.backend.programming.learning.system.auth.service.domain.dto.method.create.user.CreateSocialLoginUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.user.CreateUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.user.CreateUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.user.RegisterUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.delete.user.DeleteUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.message.user.UserRequest;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.user.QueryAllUsersResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.update.user.UpdateUserByAdminCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.update.user.UpdateUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.response_entity.organization.OrganizationEntityResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.response_entity.user.UserEntityResponse;
import com.backend.programming.learning.system.auth.service.domain.entity.Organization;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.event.user.auth_to_any_services.UserCreatedEvent;
import com.backend.programming.learning.system.auth.service.domain.event.user.auth_to_any_services.UserDeletedEvent;
import com.backend.programming.learning.system.auth.service.domain.event.user.UserEvent;
import com.backend.programming.learning.system.auth.service.domain.event.user.auth_to_any_services.UserUpdatedEvent;
import com.backend.programming.learning.system.auth.service.domain.outbox.model.user.UserEventPayload;
import com.backend.programming.learning.system.domain.DomainConstants;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.domain.valueobject.OrganizationId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class UserDataMapper {
    private final RoleDataMapper roleDataMapper;
    private final String DEFAULT_PASSWORD = "Hh123456@";

    public UserDataMapper(RoleDataMapper roleDataMapper) {
        this.roleDataMapper = roleDataMapper;
    }

    public User createUserCommandToUser(CreateUserCommand createUserCommand) {
        return User.builder()
                .email(createUserCommand.getEmail())
                .username(createUserCommand.getUsername())
                .firstName(createUserCommand.getFirstName())
                .lastName(createUserCommand.getLastName())
                .organization(createUserCommand.getOrganizationId() == null ? null :
                        Organization.builder()
                                .id(new OrganizationId(createUserCommand.getOrganizationId()))
                                .build())
                .phone(createUserCommand.getPhone())
                .build();
    }


    public UpdateUserByAdminCommand userCommandToUpdateUserByAdminCommand(User user, String roleName) {
        return UpdateUserByAdminCommand.builder()
                .userId(user.getId().getValue())
                .dob(user.getDob())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phone(user.getPhone())
                .address(user.getAddress())
                .roleName(roleName)
                .avatarUrl(user.getAvatarUrl())
                .isDeleted(user.getDeleted())
                .build();
    }

    public CreateUserCommand userCommandToCreateUserCommand(User user, String roleName) {
        return CreateUserCommand.builder()
                .email(user.getEmail())
                .username(user.getUsername())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .password(DEFAULT_PASSWORD)
                .organizationId(user.getOrganization() == null ? null : user.getOrganization().getId().getValue())
                .phone(user.getPhone())
                .roleName(roleName)
                .build();
    }

    public User registerUserCommandToUser(RegisterUserCommand registerUserCommand) {
        return User.builder()
                .email(registerUserCommand.getEmail())
                .firstName(registerUserCommand.getFirstName())
                .lastName(registerUserCommand.getLastName())
                .phone(registerUserCommand.getPhone())
                .build();
    }

    public User createSocialLoginUserCommandToUser(CreateSocialLoginUserCommand createSocialLoginUserCommand) {
        return User.builder()
                .email(createSocialLoginUserCommand.getEmail())
                .username(createSocialLoginUserCommand.getUsername())
                .firstName(createSocialLoginUserCommand.getFirstName())
                .lastName(createSocialLoginUserCommand.getLastName())
                .avatarUrl(createSocialLoginUserCommand.getAvatarUrl())
                .isLinkedWithGoogle(createSocialLoginUserCommand.getProvider().equals("google"))
                .isLinkedWithMicrosoft(createSocialLoginUserCommand.getProvider().equals("microsoft"))
                .isLinkedWithSystemAccount(false)
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
                .organizationId(user.getOrganization() == null ? null : user.getOrganization().getId().getValue().toString())
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

    public UserEventPayload userCreatedEventToUserEventPayloadWithRoleName(UserCreatedEvent userCreatedEvent, String roleName, Integer userIdMoodle) {
        User user = userCreatedEvent.getUser();
        return UserEventPayload.builder()
                .userId(user.getId().getValue().toString())
                .organizationId(user.getOrganization() == null ? null : user.getOrganization().getId().getValue().toString())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phone(user.getPhone())
                .username(user.getUsername())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .isDeleted(user.getDeleted())
                .copyState(CopyState.CREATING.name())
                .roleName(roleName)
                .userIdMoodle(userIdMoodle)
                .build();
    }

    public UserEventPayload userUpdatedEventToUserEventPayload(UserUpdatedEvent userUpdatedEvent) {
        User user = userUpdatedEvent.getUser();
        return UserEventPayload.builder()
                .userId(user.getId().getValue().toString())
                .organizationId(user.getOrganization() == null ? null : user.getOrganization().getId().getValue().toString())
                .dob(user.getDob())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phone(user.getPhone())
                .address(user.getAddress())
                .avatarUrl(user.getAvatarUrl())
                .updatedAt(user.getUpdatedAt())
                .copyState(CopyState.UPDATING.name())
                .isDeleted(user.getDeleted())
                .build();
    }

    public UserEventPayload userUpdatedEventToUserEventPayloadWithRoleName(
            UserUpdatedEvent userUpdatedEvent, String roleName) {
        User user = userUpdatedEvent.getUser();
        return UserEventPayload.builder()
                .userId(user.getId().getValue().toString())
                .organizationId(user.getOrganization() == null ? null : user.getOrganization().getId().getValue().toString())
                .dob(user.getDob())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phone(user.getPhone())
                .address(user.getAddress())
                .avatarUrl(user.getAvatarUrl())
                .updatedAt(user.getUpdatedAt())
                .copyState(CopyState.UPDATING.name())
                .isDeleted(user.getDeleted())
                .roleName(roleName)
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

    public OrganizationEntityResponse organizationToOrganizationEntityResponse(Organization organization) {
        return OrganizationEntityResponse.builder()
                .organizationId(organization.getId().getValue())
                .createdBy(null)
                .updatedBy(null)
                .email(organization.getEmail())
                .description(organization.getDescription())
                .name(organization.getName())
                .phone(organization.getPhone())
                .address(organization.getAddress())
                .apiKey(organization.getApiKey())
                .moodleUrl(organization.getMoodleUrl())
                .createdAt(organization.getCreatedAt())
                .updatedAt(organization.getUpdatedAt())
                .isDeleted(organization.getDeleted())
                .build();
    }

    public UserEntityResponse userToUserResponse(User user) {
        Organization organizationEntityResponse = user.getOrganization();
        return UserEntityResponse.builder()
                .userId(user.getId().getValue())
                .email(user.getEmail())
                .dob(user.getDob())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phone(user.getPhone())
                .address(user.getAddress())
                .avatarUrl(user.getAvatarUrl())
                .lastLogin(user.getLastLogin())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .organization(organizationEntityResponse != null ? organizationToOrganizationEntityResponse(organizationEntityResponse) : null)
                .isDeleted(user.getDeleted())
                .isLinkedWithGoogle(user.getLinkedWithGoogle())
                .isLinkedWithMicrosoft(user.getLinkedWithMicrosoft())
                .roles(user.getRoles() == null ? null : user.getRoles().stream().map(roleDataMapper::roleToRoleResponse).collect(Collectors.toSet()))
                .isLinkedWithSystemAccount(user.getLinkedWithSystemAccount())
                .emailLinkedGoogle(user.getEmailLinkedGoogle())
                .emailLinkedMicrosoft(user.getEmailLinkedMicrosoft())
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
                .organization(userRequest.getOrganizationId() == null ? null :
                        Organization.builder()
                                .id(new OrganizationId(userRequest.getOrganizationId()))
                                .build())
                .email(userRequest.getEmail())
                .username(userRequest.getUsername())
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .phone(userRequest.getPhone())
                .createdAt(userRequest.getCreatedAt().atZone(ZoneId.of(DomainConstants.UTC)))
                .updatedAt(userRequest.getUpdatedAt().atZone(ZoneId.of(DomainConstants.UTC)))
                .isDeleted(userRequest.getIsDeleted())
                .build();
    }

    public UserEventPayload userEventToUserEventPayload(UserEvent userEvent, CopyState copyState) {
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
                .username(userUpdateRequest.getUsername())
                .address(userUpdateRequest.getAddress())
                .avatarUrl(userUpdateRequest.getAvatarUrl())
                .dob(userUpdateRequest.getDob().atZone(ZoneId.of(DomainConstants.UTC)))
                .phone(userUpdateRequest.getPhone())
                .updatedAt(userUpdateRequest.getUpdatedAt().atZone(ZoneId.of(DomainConstants.UTC)))
                .build();
    }
}
