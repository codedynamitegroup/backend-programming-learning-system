package com.backend.programming.learning.system.code.assessment.service.domain.implement.service;

import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.saga.SagaStatus;
import org.springframework.stereotype.Component;

@Component
public class GeneralSagaHelper {
    public SagaStatus copyStateToSagaStatus(CopyState copyState){
        return switch (copyState){
            case CREATING,UPDATING,DELETING -> SagaStatus.STARTED;

            case UPDATE_PROPAGATING,
                 DELETE_PROPAGATING,
                 CREATE_PROPAGATING-> SagaStatus.PROCESSING;

            case CREATE_ROLLBACKING, DELETE_ROLLBACKING, UPDATE_ROLLBACKING-> SagaStatus.COMPENSATING;

            case CREATED,UPDATED,DELETED -> SagaStatus.SUCCEEDED;

            case CREATE_FAILED, UPDATE_FAILED, DELETE_FAILED -> SagaStatus.COMPENSATED;
        };
    }
}
