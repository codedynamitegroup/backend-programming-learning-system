package com.backend.programming.learning.system.auth.service.domain.implement.service.user;

import com.backend.programming.learning.system.auth.service.domain.AuthDomainService;
import com.backend.programming.learning.system.auth.service.domain.dto.method.assign_user_to_organization.AssignUserToOrganizationCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.assign_user_to_organization.UnassignedUserToOrganizationCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.user_role.CreateUserRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.delete.user_role.DeleteUserRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.update.user.UpdateUserByAdminCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.update.user.UpdateUserProfileCommand;
import com.backend.programming.learning.system.auth.service.domain.entity.Organization;
import com.backend.programming.learning.system.auth.service.domain.entity.Role;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.entity.UserRole;
import com.backend.programming.learning.system.auth.service.domain.event.user.auth_to_any_services.UserUpdatedEvent;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthDomainException;
import com.backend.programming.learning.system.auth.service.domain.implement.service.role.RoleQueryHelper;
import com.backend.programming.learning.system.auth.service.domain.implement.service.user_role.UserRoleCreateHelper;
import com.backend.programming.learning.system.auth.service.domain.implement.service.user_role.UserRoleDeleteHelper;
import com.backend.programming.learning.system.auth.service.domain.implement.service.user_role.UserRoleQueryHelper;
import com.backend.programming.learning.system.auth.service.domain.ports.input.service.RoleKeycloakApplicationService;
import com.backend.programming.learning.system.auth.service.domain.ports.input.service.UserKeycloakApplicationService;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.OrganizationRepository;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.UserRoleRepository;
import com.backend.programming.learning.system.domain.DomainConstants;
import com.backend.programming.learning.system.domain.valueobject.OrganizationId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserUpdateHelper {
    private final UserRepository userRepository;
    private final RoleQueryHelper roleQueryHelper;
    private final AuthDomainService authDomainService;
    private final UserKeycloakApplicationService keycloakApplicationService;
    private final UserQueryHelper userQueryHelper;
    private final UserRoleQueryHelper userRoleQueryHelper;
    private final UserRoleCreateHelper userRoleCreateHelper;
    private final UserRoleDeleteHelper userRoleDeleteHelper;
    private final UserRoleRepository userRoleRepository;
    private final RoleKeycloakApplicationService roleKeycloakApplicationService;
    private final String ROLE_NAME_USER = "user";
    private final OrganizationRepository organizationRepository;

    @Transactional
    public UserUpdatedEvent updateUserProfile(UpdateUserProfileCommand updateUserProfileCommand) {
        User user = userQueryHelper.queryUserByEmail(updateUserProfileCommand.getEmail());
        user.setUpdatedAt(ZonedDateTime.now(ZoneId.of(DomainConstants.UTC)));

        if (updateUserProfileCommand.getDob() != null) {
            user.setDob(updateUserProfileCommand.getDob());
        }
        if (updateUserProfileCommand.getFirstName() != null) {
            user.setFirstName(updateUserProfileCommand.getFirstName());
        }
        if (updateUserProfileCommand.getLastName() != null) {
            user.setLastName(updateUserProfileCommand.getLastName());
        }
        if (updateUserProfileCommand.getPhone() != null) {
            user.setPhone(updateUserProfileCommand.getPhone());
        }
        if (updateUserProfileCommand.getAddress() != null) {
            user.setAddress(updateUserProfileCommand.getAddress());
        }
        if (updateUserProfileCommand.getAvatarUrl() != null) {
            user.setAvatarUrl(updateUserProfileCommand.getAvatarUrl());
        }

        UserUpdatedEvent userUpdatedEvent = authDomainService.updateUser(user);

        saveUser(user);
        return userUpdatedEvent;
    }

    public UserUpdatedEvent assignUserToOrganization(AssignUserToOrganizationCommand assignUserToOrganizationCommand) {
        User user = userQueryHelper.queryUser(assignUserToOrganizationCommand.getUserId());
        if (user.getOrganization() != null) {
            log.error("User is already assigned to an organization!");
            throw new AuthDomainException("User is already assigned to an organization!");
        }
        Organization organization = findOrganizationAndIsVerifiedTrue(assignUserToOrganizationCommand.getOrganizationId());
        String assignedRoleName = assignUserToOrganizationCommand.getRoleName();
        user.setUpdatedAt(ZonedDateTime.now(ZoneId.of(DomainConstants.UTC)));
        user.setOrganization(organization);

        UserRole userRole = userRoleQueryHelper.findByUserIdAndRoleIsNotUser(user.getId().getValue());

        if (userRole != null) { // If user has role different from role user
            String roleName = userRole.getRole().getName();
            if (assignedRoleName.equals(ROLE_NAME_USER)) { //Delete role which is different from role user
                userRoleDeleteHelper.deleteUserRole(DeleteUserRoleCommand.builder()
                        .userId(user.getId().getValue())
                        .roleId(userRole.getRole().getId().getValue())
                        .build());
                roleKeycloakApplicationService.assignRole(user.getEmail(), ROLE_NAME_USER); //assign role user
            } else {
                if (!roleName.equals(assignedRoleName)) {  // Update role
                    Role role = roleQueryHelper.queryRoleByName(assignedRoleName);
                    userRole.setRole(role);
                    userRoleRepository.save(userRole);
                    roleKeycloakApplicationService.removeRole(user.getEmail(), roleName);
                    roleKeycloakApplicationService.assignRole(user.getEmail(), assignedRoleName); //assign new role
                }
            }
        } else { // User only have role user
            if (!assignedRoleName.equals(ROLE_NAME_USER)) { // Add role
                Role role = roleQueryHelper.queryRoleByName(assignedRoleName);
                roleKeycloakApplicationService.removeRole(user.getEmail(), ROLE_NAME_USER); //remove role user in keycloak
                userRoleCreateHelper.persistUserRole(CreateUserRoleCommand.builder()
                        .roleId(role.getId().getValue())
                        .userId(user.getId().getValue())
                        .build());
            }
        }

        UserUpdatedEvent userUpdatedEvent = authDomainService.updateUser(user);

        saveUser(user);
        return userUpdatedEvent;
    }

    public UserUpdatedEvent unassignedUserToOrganization(UnassignedUserToOrganizationCommand unassignedUserToOrganizationCommand) {
        User user = userQueryHelper.queryUser(unassignedUserToOrganizationCommand.getUserId());
        if (user.getOrganization() == null) {
            log.error("User is not assigned to any organization!");
            throw new AuthDomainException("User is not assigned to any organization!");
        }
        user.setUpdatedAt(ZonedDateTime.now(ZoneId.of(DomainConstants.UTC)));
        user.setOrganization(null);
        UserRole userRole = userRoleQueryHelper.findByUserIdAndRoleIsNotUser(user.getId().getValue());

        userRoleDeleteHelper.deleteUserRole(DeleteUserRoleCommand.builder()
                .userId(user.getId().getValue())
                .roleId(userRole.getRole().getId().getValue())
                .build());
        roleKeycloakApplicationService.assignRole(user.getEmail(), ROLE_NAME_USER); //assign role user

        UserUpdatedEvent userUpdatedEvent = authDomainService.updateUser(user);

        saveUser(user);
        return userUpdatedEvent;
    }

    @Transactional
    public UserUpdatedEvent updateUserByAdmin(UpdateUserByAdminCommand updateUserByAdminCommand) {
        User user = userQueryHelper.queryUser(updateUserByAdminCommand.getUserId());
        String assignedRoleName = updateUserByAdminCommand.getRoleName();
        user.setUpdatedAt(ZonedDateTime.now(ZoneId.of(DomainConstants.UTC)));

        if (updateUserByAdminCommand.getDob() != null) {
            user.setDob(updateUserByAdminCommand.getDob());
        }
        if (updateUserByAdminCommand.getFirstName() != null) {
            user.setFirstName(updateUserByAdminCommand.getFirstName());
        }
        if (updateUserByAdminCommand.getLastName() != null) {
            user.setLastName(updateUserByAdminCommand.getLastName());
        }
        if (updateUserByAdminCommand.getPhone() != null) {
            user.setPhone(updateUserByAdminCommand.getPhone());
        }
        if (updateUserByAdminCommand.getAddress() != null) {
            user.setAddress(updateUserByAdminCommand.getAddress());
        }
        if (updateUserByAdminCommand.getAvatarUrl() != null) {
            user.setAvatarUrl(updateUserByAdminCommand.getAvatarUrl());
        }
        if (updateUserByAdminCommand.getIsDeleted() != null) {
            user.setDeleted(updateUserByAdminCommand.getIsDeleted());
        }

        UserRole userRole = userRoleQueryHelper.findByUserIdAndRoleIsNotUser(user.getId().getValue());

        if (userRole != null) { // If user has role different from role user
            String roleName = userRole.getRole().getName();
            if (assignedRoleName.equals(ROLE_NAME_USER)) { //Delete role which is different from role user
                userRoleDeleteHelper.deleteUserRole(DeleteUserRoleCommand.builder()
                                .userId(user.getId().getValue())
                                .roleId(userRole.getRole().getId().getValue())
                                .build());
                roleKeycloakApplicationService.assignRole(user.getEmail(), ROLE_NAME_USER); //assign role user
            } else {
                if (!roleName.equals(assignedRoleName)) {  // Update role
                    Role role = roleQueryHelper.queryRoleByName(assignedRoleName);
                    userRole.setRole(role);
                    userRoleRepository.save(userRole);
                    roleKeycloakApplicationService.removeRole(user.getEmail(), roleName);
                    roleKeycloakApplicationService.assignRole(user.getEmail(), assignedRoleName); //assign new role
                }
            }
        } else { // User only have role user
            if (!assignedRoleName.equals(ROLE_NAME_USER)) { // Add role
                Role role = roleQueryHelper.queryRoleByName(assignedRoleName);
                roleKeycloakApplicationService.removeRole(user.getEmail(), ROLE_NAME_USER); //remove role user in keycloak
                userRoleCreateHelper.persistUserRole(CreateUserRoleCommand.builder()
                        .roleId(role.getId().getValue())
                        .userId(user.getId().getValue())
                        .build());
            }
        }

        UserUpdatedEvent userUpdatedEvent = authDomainService.updateUser(user);

        saveUser(user);
        return userUpdatedEvent;
    }
    private User saveUser(User user) {
        User userResult = userRepository.save(user);
        if (userResult == null) {
            log.error("Could not update user!");
            throw new AuthDomainException("Could not update user!");
        }
        log.info("User is updated with id: {}", userResult.getId().getValue());
        return userResult;
    }

    private Organization findOrganizationAndIsVerifiedTrue(UUID organizationId) {
        Optional<Organization> organizationResult = organizationRepository.findByIdAndIsVerifiedTrue(new OrganizationId(organizationId));
        if (organizationResult.isEmpty()) {
            log.warn("Organization with id: {} is not verified", organizationId);
            throw new AuthDomainException("Organization is not verified with id:" + organizationId);
        }
        return organizationResult.get();
    }
}
