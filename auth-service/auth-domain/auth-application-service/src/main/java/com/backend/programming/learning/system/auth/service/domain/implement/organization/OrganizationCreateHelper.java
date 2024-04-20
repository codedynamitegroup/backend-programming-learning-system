package com.backend.programming.learning.system.auth.service.domain.implement.organization;

import com.backend.programming.learning.system.auth.service.domain.AuthDomainService;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.organization.CreateOrganizationCommand;
import com.backend.programming.learning.system.auth.service.domain.entity.Organization;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthDomainException;
import com.backend.programming.learning.system.auth.service.domain.mapper.OrganizationDataMapper;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.OrganizationRepository;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class OrganizationCreateHelper {
    private final AuthDomainService authDomainService;
    private final OrganizationRepository organizationRepository;
    private final OrganizationDataMapper organizationDataMapper;
    private final UserRepository userRepository;

    public OrganizationCreateHelper(AuthDomainService authDomainService, OrganizationRepository organizationRepository, OrganizationDataMapper organizationDataMapper, UserRepository userRepository) {
        this.authDomainService = authDomainService;
        this.organizationRepository = organizationRepository;
        this.organizationDataMapper = organizationDataMapper;
        this.userRepository = userRepository;
    }


    @Transactional
    public Organization persistOrganization(CreateOrganizationCommand createOrganizationCommand) {
        User createdBy = getUser(createOrganizationCommand.getCreatedBy());
        Organization organization = organizationDataMapper.createOrganizationCommandToOrganization(createOrganizationCommand);
        organization.setCreatedBy(createdBy);
        organization.setUpdatedBy(createdBy);
        authDomainService.createOrganization(organization);
        return saveOrganization(organization);
    }

    private User getUser(UUID userId) {
        Optional<User> user = userRepository.findById(new UserId(userId));
        if (user.isEmpty()) {
            log.error("User with id: {} could not be found!", userId);
            throw new AuthDomainException("User with id: " + userId + " could not be found!");
        }
        return user.get();
    }

    private Organization saveOrganization(Organization organization) {
        Organization organizationResult = organizationRepository.save(organization);
        if (organizationResult == null) {
            log.error("Could not save organization!");
            throw new AuthDomainException("Could not save organization!");
        }
        log.info("Organization is saved with id: {}", organizationResult.getId().getValue());
        return organizationResult;
    }
}
