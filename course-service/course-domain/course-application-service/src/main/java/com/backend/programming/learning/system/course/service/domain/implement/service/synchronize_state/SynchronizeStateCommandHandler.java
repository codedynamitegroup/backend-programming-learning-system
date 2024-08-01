package com.backend.programming.learning.system.course.service.domain.implement.service.synchronize_state;

import com.backend.programming.learning.system.course.service.domain.dto.method.query.synchronize_state.QuerySynchronizeStateResponse;
import com.backend.programming.learning.system.course.service.domain.entity.SynchronizeState;
import com.backend.programming.learning.system.course.service.domain.mapper.synchronize_state.SynchronizeStateDataMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@Slf4j
@RequiredArgsConstructor
public class SynchronizeStateCommandHandler {
    private final SynchronizeStateQueryHelper synchronizeStateQueryHelper;
    private final SynchronizeStateDataMapper synchronizeStateDataMapper;

    QuerySynchronizeStateResponse querySynchronizeByOrganizationIdAndStep(UUID organizationId, String step) {
        SynchronizeState synchronizeState = synchronizeStateQueryHelper.querySynchronizeStateByOrganizationIdAndStep(organizationId, step);
        return synchronizeStateDataMapper.mapSynchronizeStateToQuerySynchronizeStateResponse(synchronizeState);
    }

    List<QuerySynchronizeStateResponse> querySynchronizeByOrganizationId(UUID organizationId) {
        List<SynchronizeState> synchronizeStates = synchronizeStateQueryHelper.querySynchronizeStateByOrganizationId(organizationId);
        return synchronizeStateDataMapper.mapSynchronizeStateToQuerySynchronizeStateResponse(synchronizeStates);
    }


}
