package com.backend.programming.learning.system.course.service.domain.ports.input.service.synchronize_state_detail;

import com.backend.programming.learning.system.course.service.domain.dto.method.query.synchronize_state_detail.QuerySynchronizeStateDetailResponse;
import com.backend.programming.learning.system.course.service.domain.entity.SynchronizeStateDetail;
import com.backend.programming.learning.system.course.service.domain.entity.WebhookMessage;
import com.backend.programming.learning.system.domain.valueobject.TypeSynchronizeStatus;

import java.util.List;
import java.util.UUID;

public interface SynchronizeStateDetailApplicationService {

    List<QuerySynchronizeStateDetailResponse> querySynchronizeStateDetailByStatus(TypeSynchronizeStatus status);
}