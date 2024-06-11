package com.backend.programming.learning.system.auth.service.domain.implement.saga.organization;

import com.backend.programming.learning.system.auth.service.domain.entity.Organization;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthNotFoundException;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.OrganizationRepository;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.domain.valueobject.OrganizationId;
import com.backend.programming.learning.system.saga.SagaStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class OrganizationUpdateSagaHelper {

    public SagaStatus copyStatusToSagaStatus(CopyState copyState){
        return switch (copyState){
            case CREATING,UPDATING,DELETING -> SagaStatus.STARTED;
            case CREATE_FAILED, UPDATE_FAILED, DELETE_FAILED-> SagaStatus.COMPENSATING;
            case CREATED,UPDATED,DELETED -> SagaStatus.SUCCEEDED;
            default -> SagaStatus.STARTED;
        };
    }
}
