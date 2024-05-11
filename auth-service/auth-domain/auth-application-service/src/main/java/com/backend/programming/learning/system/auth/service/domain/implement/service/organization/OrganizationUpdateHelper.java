package com.backend.programming.learning.system.auth.service.domain.implement.service.organization;

import com.backend.programming.learning.system.auth.service.domain.AuthDomainService;
import com.backend.programming.learning.system.auth.service.domain.dto.method.update.organization.UpdateOrganizationCommand;
import com.backend.programming.learning.system.auth.service.domain.entity.Organization;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.event.organization.OrganizationUpdatedEvent;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthDomainException;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthNotFoundException;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.OrganizationRepository;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.domain.DomainConstants;
import com.backend.programming.learning.system.domain.valueobject.OrganizationId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class OrganizationUpdateHelper {
    private final OrganizationRepository organizationRepository;
    private final UserRepository userRepository;
    private final AuthDomainService authDomainService;

    public OrganizationUpdateHelper(OrganizationRepository organizationRepository, UserRepository userRepository, AuthDomainService authDomainService) {
        this.organizationRepository = organizationRepository;
        this.userRepository = userRepository;
        this.authDomainService = authDomainService;
    }


    @Transactional
    public OrganizationUpdatedEvent persistOrganization(UpdateOrganizationCommand updateOrganizationCommand) {
        Organization organization = getOrganization(updateOrganizationCommand.getOrganizationId());
        User updateBy = getUser(updateOrganizationCommand.getUpdatedBy());

        organization.setUpdatedBy(updateBy);
        organization.setUpdatedAt(ZonedDateTime.now(ZoneId.of(DomainConstants.UTC)));

        if (updateOrganizationCommand.getName() != null) {
            organization.setName(updateOrganizationCommand.getName());
        }

        if (updateOrganizationCommand.getDescription() != null) {
            organization.setDescription(updateOrganizationCommand.getDescription());
        }

        if (updateOrganizationCommand.getEmail() != null) {
            organization.setEmail(updateOrganizationCommand.getEmail());
        }

        if (updateOrganizationCommand.getPhone() != null) {
            organization.setPhone(updateOrganizationCommand.getPhone());
        }

        if (updateOrganizationCommand.getAddress() != null) {
            organization.setAddress(updateOrganizationCommand.getAddress());
        }

        if (updateOrganizationCommand.getApiKey() != null) {
            organization.setApiKey(updateOrganizationCommand.getApiKey());
        }

        if (updateOrganizationCommand.getMoodleUrl() != null) {
            organization.setMoodleUrl(updateOrganizationCommand.getMoodleUrl());
        }

        OrganizationUpdatedEvent organizationUpdatedEvent = authDomainService.updateOrganization(organization);
        updateOrganization(organization);
        return organizationUpdatedEvent;
    }

    private User getUser(UUID userId) {
        Optional<User> user = userRepository.findById(new UserId(userId));
        if (user.isEmpty()) {
            log.error("User with id: {} could not be found!", userId);
            throw new AuthDomainException("User with id: " + userId + " could not be found!");
        }
        return user.get();
    }

    private Organization getOrganization(UUID organizationId) {
        Optional<Organization> organization = organizationRepository.findById(new OrganizationId(organizationId));
        if (organization.isEmpty()) {
            log.warn("Organization with id: {} not found", organizationId);
            throw new AuthNotFoundException("Could not find organization with id: " + organizationId);
        }
        return organization.get();
    }

    private void updateOrganization(Organization organization) {
        Organization organizationResult = organizationRepository.save(organization);
        if (organizationResult == null) {
            log.error("Could not update organization!");
            throw new AuthDomainException("Could not update organization!");
        }
        log.info("Organization is updated with id: {}", organizationResult.getId().getValue());
    }
}
