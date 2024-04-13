package com.backend.programming.learning.system.auth.service.domain;

import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateOrganizationCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateOrganizationResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.delete.DeleteOrganizationCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.delete.DeleteOrganizationResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryOrganizationCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryOrganizationResponse;
import com.backend.programming.learning.system.auth.service.domain.entity.Organization;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthNotFoundException;
import com.backend.programming.learning.system.auth.service.domain.mapper.OrganizationDataMapper;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.OrganizationRepository;
import com.backend.programming.learning.system.domain.valueobject.OrganizationId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Component
public class OrganizationCommandHandler {

    private final OrganizationCreateHelper organizationCreateHelper;
    private final OrganizationDeleteHelper organizationDeleteHelper;
    private final OrganizationDataMapper organizationDataMapper;
    private final OrganizationRepository organizationRepository;

    public OrganizationCommandHandler(OrganizationCreateHelper organizationCreateHelper, OrganizationDataMapper organizationDataMapper, OrganizationRepository organizationRepository, OrganizationDeleteHelper organizationDeleteHelper) {
        this.organizationCreateHelper = organizationCreateHelper;
        this.organizationDataMapper = organizationDataMapper;
        this.organizationRepository = organizationRepository;
        this.organizationDeleteHelper = organizationDeleteHelper;
    }

    public CreateOrganizationResponse createOrganization(CreateOrganizationCommand createOrganizationCommand) {
        Organization organizationCreated = organizationCreateHelper.persistOrganization(createOrganizationCommand);
        log.info("Organization is created with id: {}", organizationCreated.getId().getValue());
        return organizationDataMapper.OrganizationToCreateOrganizationResponse(organizationCreated,
                "Organization created successfully");
    }

    @Transactional(readOnly = true)
    public QueryOrganizationResponse queryOrganization(QueryOrganizationCommand queryOrganizationCommand) {
        Optional<Organization> organizationResult =
                organizationRepository.findById(new OrganizationId(queryOrganizationCommand.getOrganizationId()));
        if (organizationResult.isEmpty()) {
            log.warn("Could not find organization with id: {}", queryOrganizationCommand.getOrganizationId());
            throw new AuthNotFoundException("Could not find organization with id: " +
                    queryOrganizationCommand.getOrganizationId());
        }
        return organizationDataMapper.organizationToQueryOrganizationResponse(organizationResult.get());
    }

    public DeleteOrganizationResponse deleteOrganization(DeleteOrganizationCommand deleteOrganizationCommand) {
        organizationDeleteHelper.deleteOrganization(deleteOrganizationCommand);
        log.info("Organization is deleted with id: {}", deleteOrganizationCommand.getOrganizationId());
        return DeleteOrganizationResponse.builder()
                .message("Organization deleted successfully")
                .build();
    }
}
