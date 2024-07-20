package com.backend.programming.learning.system.course.service.domain.implement.service.synchronize_state_detail;

import com.backend.programming.learning.system.course.service.domain.entity.SynchronizeStateDetail;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.SynchronizeStateDetailRepository;
import com.backend.programming.learning.system.domain.valueobject.TypeSynchronizeStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class SynchronizeStateDetailQueryHelper {
    private final SynchronizeStateDetailRepository synchronizeStateDetailRepository;

    List<SynchronizeStateDetail> querySynchronizeStateDetailByStatus(TypeSynchronizeStatus status) {
        return synchronizeStateDetailRepository.findSynchronizeStateDetailByStatus(status);
    }
}
