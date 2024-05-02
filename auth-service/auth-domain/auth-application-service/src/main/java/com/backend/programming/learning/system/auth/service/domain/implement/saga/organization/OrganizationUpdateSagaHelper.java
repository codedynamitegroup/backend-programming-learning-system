package com.backend.programming.learning.system.auth.service.domain.implement.saga.organization;

import com.backend.programming.learning.system.auth.service.domain.entity.Organization;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthNotFoundException;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.OrganizationRepository;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.domain.valueobject.OrganizationId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import com.backend.programming.learning.system.saga.SagaStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class OrganizationUpdateSagaHelper {
    private final OrganizationRepository organizationRepository;

    public OrganizationUpdateSagaHelper(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    public Organization findOrganizationById(UUID organizationId) {
        Optional<Organization> organizationResult =
                organizationRepository.findById(new OrganizationId(organizationId));
        if (organizationResult.isEmpty()) {
            log.warn("Could not find organization with id: {}", organizationId);
            throw new AuthNotFoundException("Could not find organization with organization id: " +
                    organizationId);
        }
        return organizationResult.get();
    }

    public Organization findOrganizationByIdAndIsDeletedTrue(UUID organizationId) {
        Optional<Organization> organizationResult =
                organizationRepository.findByIdAndIsDeletedTrue(new OrganizationId(organizationId));
        if (organizationResult.isEmpty()) {
            log.warn("Could not find organization with id: {}", organizationId);
            throw new AuthNotFoundException("Could not find organization with organization id: " +
                    organizationId);
        }
        return organizationResult.get();
    }

    public SagaStatus copyStatusToSagaStatus(CopyState copyState){
        return switch (copyState){
            case CREATING,UPDATING,DELETING -> SagaStatus.STARTED;
            case CREATE_FAILED, UPDATE_FAILED, DELETE_FAILED-> SagaStatus.COMPENSATING;
            case CREATED,UPDATED,DELETED -> SagaStatus.SUCCEEDED;
            default -> SagaStatus.STARTED;
        };
    }
}
