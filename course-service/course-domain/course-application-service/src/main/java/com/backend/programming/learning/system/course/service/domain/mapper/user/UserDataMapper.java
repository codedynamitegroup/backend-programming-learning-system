package com.backend.programming.learning.system.course.service.domain.mapper.user;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.user.CreateUserCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.user.CreateUserResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.message.user.UserRequest;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.user.UpdateUserCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.user.UpdateUserResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.user.UserModel;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.submission_assignment.SubmissionAssignmentUserResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.user.UserResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.user.UserSubmissionAssignmentResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.Organization;
import com.backend.programming.learning.system.course.service.domain.entity.SubmissionAssignment;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.event.user.UserCreatedEvent;
import com.backend.programming.learning.system.course.service.domain.event.user.UserEvent;
import com.backend.programming.learning.system.course.service.domain.event.user.UserUpdatedEvent;
import com.backend.programming.learning.system.course.service.domain.mapper.submission_assignment.SubmissionAssignmentDataMapper;
import com.backend.programming.learning.system.course.service.domain.outbox.model.user.UserEventPayload;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.SubmissionAssignmentRepository;
import com.backend.programming.learning.system.domain.DomainConstants;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.domain.valueobject.OrganizationId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.util.List;
import java.util.UUID;

@Component
public class UserDataMapper {
    private final SubmissionAssignmentRepository submissionAssignmentRepository;

    private final SubmissionAssignmentDataMapper submissionAssignmentDataMapper;

    public UserDataMapper(SubmissionAssignmentRepository submissionAssignmentRepository, SubmissionAssignmentDataMapper submissionAssignmentDataMapper) {
        this.submissionAssignmentRepository = submissionAssignmentRepository;
        this.submissionAssignmentDataMapper = submissionAssignmentDataMapper;
    }

    public UserResponseEntity userToUserResponseEntity(User user) {
        return UserResponseEntity.builder()
                .userId(user.getId().getValue())
                .roleMoodleId(user.getRoleMoodle() == null ? null : user.getRoleMoodle().getId().getValue().toString())
                .avatarUrl(user.getAvatarUrl())
                .fullName(user.getFirstName() + " " + user.getLastName())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .build();
    }

    public User userCreateRequestToUser(UserRequest userRequest) {
        return User.builder()
                .id(new UserId(UUID.fromString(userRequest.getUserId())))
                .organization(userRequest.getOrganizationId() == null ? null : Organization.builder()
                        .id(new OrganizationId(UUID.fromString(userRequest.getOrganizationId())))
                        .build())
                .email(userRequest.getEmail())
                .username(userRequest.getUserName())
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .phone(userRequest.getPhone())
                .createdAt(userRequest.getCreatedAt().atZone(ZoneId.of(DomainConstants.UTC)))
                .updatedAt(userRequest.getUpdatedAt().atZone(ZoneId.of(DomainConstants.UTC)))
                .isDeleted(userRequest.getIsDeleted())
                .build();
    }

    public User userUpdateRequestToUser(UserRequest userUpdateRequest) {
        return User.builder()
                .id(new UserId(UUID.fromString(userUpdateRequest.getUserId())))
                .organization(userUpdateRequest.getOrganizationId() == null ? null : Organization.builder()
                        .id(new OrganizationId(UUID.fromString(userUpdateRequest.getOrganizationId())))
                        .build())
                .firstName(userUpdateRequest.getFirstName())
                .lastName(userUpdateRequest.getLastName())
                .address(userUpdateRequest.getAddress())
                .avatarUrl(userUpdateRequest.getAvatarUrl())
                .dob(userUpdateRequest.getDob().atZone(ZoneId.of(DomainConstants.UTC)))
                .phone(userUpdateRequest.getPhone())
                .updatedAt(userUpdateRequest.getUpdatedAt().atZone(ZoneId.of(DomainConstants.UTC)))
                .isDeleted(userUpdateRequest.getIsDeleted())
                .build();
    }

    public User userDeleteRequestToUser(UserRequest userDeleteRequest) {
        return User.builder()
                .id(new UserId(UUID.fromString(userDeleteRequest.getUserId())))
                .isDeleted(userDeleteRequest.getIsDeleted())
                .build();
    }

    public UserEventPayload userEventToUserEventPayload(UserEvent userEvent, CopyState copyState) {
        return UserEventPayload.builder()
                .userId(userEvent.getUser().getId().getValue().toString())
                .copyState(copyState.name())
                .failureMessages(userEvent.getFailureMessages())
                .build();
    }

    public UserEventPayload userEventToUserEventPayloadWithTime(UserEvent userEvent, CopyState copyState, Boolean isDeleted) {
        return UserEventPayload.builder()
                .id(userEvent.getUser().getId().getValue().toString())
                .userId(userEvent.getUser().getId().getValue().toString())
                .dob(null)
                .organizationId(userEvent.getUser().getOrganization().getId().getValue().toString())
                .userName(userEvent.getUser().getName())
                .email(userEvent.getUser().getEmail())
                .firstName(userEvent.getUser().getFirstName())
                .lastName(userEvent.getUser().getLastName())
                .phone(userEvent.getUser().getPhone())
                .address(userEvent.getUser().getAddress())
                .avatarUrl(userEvent.getUser().getAvatarUrl())
                .updatedAt(userEvent.getUser().getUpdatedAt())
                .createdAt(userEvent.getUser().getCreatedAt())
                .copyState(copyState.name())
                .isDeleted(isDeleted)
                .build();
    }

    public CreateUserResponse userToCreateUserResponse(User user, String message) {
        return CreateUserResponse.builder()
                .userId(user.getId().getValue())
                .email(user.getEmail())
                .message(message)
                .build();
    }
    public User createUserCommandToUser(CreateUserCommand createUserCommand, Organization organization) {
        return User.builder()
                .email(createUserCommand.getEmail())
                .organization(organization)
                .username(createUserCommand.getUsername())
                .userIdMoodle(createUserCommand.getUserIdMoodle())
                .firstName(createUserCommand.getFirstName())
                .lastName(createUserCommand.getLastName())
                .phone(createUserCommand.getPhone())
                .build();
    }
    public User updateUserCommandToUser(UpdateUserCommand updateUserCommand) {
        return User.builder()
                .id(new UserId(updateUserCommand.getUserId()))
                .userIdMoodle(updateUserCommand.getUserIdMoodle())
                .dob(updateUserCommand.getDob())
                .firstName(updateUserCommand.getFirstName())
                .lastName(updateUserCommand.getLastName())
                .phone(updateUserCommand.getPhone())
                .address(updateUserCommand.getAddress())
                .avatarUrl(updateUserCommand.getAvatarUrl())
                .build();
    }

    public UpdateUserResponse userToUpdateUserResponse(User userUpdated, String message) {
        return UpdateUserResponse.builder()
                .userId(userUpdated.getId().getValue())
                .message(message)
                .build();
    }

    public UserEventPayload userCreatedEventToUserEventPayload(UserCreatedEvent userCreatedEvent) {
        User user = userCreatedEvent.getUser();
        return UserEventPayload.builder()
                .userId(user.getId().getValue().toString())
                .email(user.getEmail())
                .userName(user.getUserName())
                .organizationId(user.getOrganization().getId().getValue().toString())
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
                .email(user.getEmail())
                .userName(user.getUserName())
                .organizationId(user.getOrganization().getId().getValue().toString())
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

    public UserEventPayload userToUserEventPayload(User user, CopyState copyState) {
        return UserEventPayload.builder()
                .userId(user.getId().getValue().toString())
                .dob(user.getDob())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phone(user.getPhone())
                .address(user.getAddress())
                .avatarUrl(user.getAvatarUrl())
                .updatedAt(user.getUpdatedAt())
                .copyState(copyState.name())
                .build();
    }

    public User userModelToUser(UserModel userModel, Organization organization) {
        return User.builder()
                .userIdMoodle(Integer.valueOf(userModel.getId()))
                .organization(organization)
                .name(userModel.getUsername())
                .email(userModel.getEmail())
                .dob(null)
                .firstName(userModel.getFirstname())
                .lastName(userModel.getLastname())
//                .phone(userModel.getPhone1())
//                .address(userModel.getCity())
                .avatarUrl(userModel.getProfileimageurl())
                .isDeleted(false)
                .build();
    }

    public User setUserWithOtherPayload(UserModel userModel, User prevUser) {
        prevUser.setName(userModel.getUsername());
        prevUser.setEmail(userModel.getEmail());
        prevUser.setFirstName(userModel.getFirstname());
        prevUser.setLastName(userModel.getLastname());
//        prevUser.setPhone(userModel.getPhone1());
//        prevUser.setAddress(userModel.getCity());
        prevUser.setAvatarUrl(userModel.getProfileimageurl());

        return prevUser;
    }

    public UserSubmissionAssignmentResponseEntity userToUserSubmissionAssignmentResponseEntity(User user,UUID assignment) {
        SubmissionAssignment submissionAssignment = submissionAssignmentRepository.findByAssignmentIdAndUserId(assignment, user.getId().getValue());
        if(submissionAssignment == null) {
            return UserSubmissionAssignmentResponseEntity.builder()
                    .id(user.getId().getValue())
                    .fullName(user.getFirstName() + " " + user.getLastName())
                    .email(user.getEmail())
                    .build();
        }
        SubmissionAssignmentUserResponseEntity submissionAssignmentUserResponseEntity =
                submissionAssignmentDataMapper.
                        submissionAssignmentToSubmissionAssignmentUserResponseEntity(submissionAssignment);
        return UserSubmissionAssignmentResponseEntity.builder()
                .id(user.getId().getValue())
                .fullName(user.getFirstName() + " " + user.getLastName())
                .email(user.getEmail())
                .submissionAssignmentUserResponseEntity(submissionAssignmentUserResponseEntity)
                .build();
    }

    public List<UserSubmissionAssignmentResponseEntity> userToUserSubmissionAssignmentResponseEntityList(List<User> users, UUID assignment) {
        return users.stream()
                .map(user -> userToUserSubmissionAssignmentResponseEntity(user, assignment))
                .toList();
    }
}
