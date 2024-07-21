package com.backend.programming.learning.system.course.service.domain.implement.service.synchronize_state_detail;

import com.backend.programming.learning.system.course.service.domain.dto.method.query.synchronize_state_detail.QuerySynchronizeStateDetailResponse;
import com.backend.programming.learning.system.course.service.domain.entity.WebhookMessage;
import com.backend.programming.learning.system.course.service.domain.implement.service.module.ModuleCommandHandler;
import com.backend.programming.learning.system.course.service.domain.implement.service.moodle.MoodleCommandHandler;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.synchronize_state_detail.SynchronizeStateDetailApplicationService;
import com.backend.programming.learning.system.domain.valueobject.TypeSynchronizeStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.UUID;

@Service
@Validated
@Slf4j
@RequiredArgsConstructor
public class SynchronizeStateDetailApplicationServiceImpl implements SynchronizeStateDetailApplicationService {

    private final SynchronizeStateDetailCommandHandler synchronizeStateDetailCommandHandler;


    @Override
    public List<QuerySynchronizeStateDetailResponse> querySynchronizeStateDetailByStatus(TypeSynchronizeStatus status) {
        return
            synchronizeStateDetailCommandHandler.querySynchronizeStateDetailByStatus(status);
    }
}
