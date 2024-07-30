package com.backend.programming.learning.system.course.service.domain.ports.input.service.synchronize_state;

import com.backend.programming.learning.system.course.service.domain.dto.method.query.synchronize_state.QuerySynchronizeStateCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.synchronize_state.QuerySynchronizeStateResponse;
import com.backend.programming.learning.system.domain.valueobject.OrganizationId;
import com.backend.programming.learning.system.domain.valueobject.SynchronizeStatus;

import java.util.List;
import java.util.UUID;

public interface SynchronizeStateApplicationService {
    Boolean syncUser(UUID organizationId);

    Boolean syncCourse(UUID organizationId);

    Boolean syncResource(UUID organizationId);

    String syncDataMoodle(UUID organizationId,UUID userId);

    QuerySynchronizeStateResponse querySynchronizeByOrganizationIdAndStep(QuerySynchronizeStateCommand querySynchronizeStateCommand);

    List<QuerySynchronizeStateResponse> querySynchronizeByOrganizationId(UUID organizationId);
}