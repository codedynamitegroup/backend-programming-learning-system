package com.backend.programming.learning.system.course.service.domain.mapper.synchronize_state;

import com.backend.programming.learning.system.course.service.domain.dto.method.query.synchronize_state.QuerySynchronizeStateResponse;
import com.backend.programming.learning.system.course.service.domain.entity.SynchronizeState;
import com.backend.programming.learning.system.domain.valueobject.SynchronizeStatus;
import org.springframework.stereotype.Component;

@Component
public class SynchronizeStateDataMapper {

    public QuerySynchronizeStateResponse mapSynchronizeStateToQuerySynchronizeStateResponse(SynchronizeState synchronizeState) {
        return QuerySynchronizeStateResponse.builder()
                .id(synchronizeState.getId().getValue())
                .status(synchronizeState.getStatus().name())
                .step(synchronizeState.getStep().name())
                .syncCount(synchronizeState.getSyncCount())
                .build();
    }
}
