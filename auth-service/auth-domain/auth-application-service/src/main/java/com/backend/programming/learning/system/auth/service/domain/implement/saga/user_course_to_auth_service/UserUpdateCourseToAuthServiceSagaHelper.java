package com.backend.programming.learning.system.auth.service.domain.implement.saga.user_course_to_auth_service;

import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.saga.SagaStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserUpdateCourseToAuthServiceSagaHelper {
    public SagaStatus copyStatusToSagaStatus(CopyState copyState){
        return switch (copyState){
            case CREATING,UPDATING,DELETING -> SagaStatus.STARTED;
            case CREATE_FAILED, UPDATE_FAILED, DELETE_FAILED-> SagaStatus.COMPENSATING;
            case CREATED,UPDATED,DELETED -> SagaStatus.SUCCEEDED;
            default -> SagaStatus.STARTED;
        };
    }
}
