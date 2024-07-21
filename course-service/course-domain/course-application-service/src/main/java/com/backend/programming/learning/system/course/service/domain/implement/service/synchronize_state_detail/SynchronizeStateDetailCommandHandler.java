package com.backend.programming.learning.system.course.service.domain.implement.service.synchronize_state_detail;

import com.backend.programming.learning.system.course.service.domain.dto.method.query.synchronize_state.QuerySynchronizeStateResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.synchronize_state_detail.QuerySynchronizeStateDetailResponse;
import com.backend.programming.learning.system.course.service.domain.entity.SynchronizeStateDetail;
import com.backend.programming.learning.system.course.service.domain.mapper.synchronize_state_detail.SynchronizeStateDetailDataMapper;
import com.backend.programming.learning.system.domain.valueobject.TypeSynchronizeStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@Slf4j
@RequiredArgsConstructor
public class SynchronizeStateDetailCommandHandler {
    private final SynchronizeStateDetailQueryHelper synchronizeStateDetailQueryHelper;
    private final SynchronizeStateDetailDataMapper synchronizeStateDetailDataMapper;

    List<QuerySynchronizeStateDetailResponse> querySynchronizeStateDetailByStatus(TypeSynchronizeStatus status) {
        List<SynchronizeStateDetail> synchronizeStateDetails = synchronizeStateDetailQueryHelper.querySynchronizeStateDetailByStatus(status);
        return synchronizeStateDetailDataMapper.mapSynchronizeStateDetailToQuerySynchronizeStateDetailResponse(synchronizeStateDetails);
    }

}
