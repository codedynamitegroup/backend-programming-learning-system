package com.backend.programming.learning.system.course.service.domain.mapper.synchronize_state_detail;

import com.backend.programming.learning.system.course.service.domain.dto.method.query.synchronize_state_detail.QuerySynchronizeStateDetailResponse;
import com.backend.programming.learning.system.course.service.domain.entity.SynchronizeStateDetail;
import com.backend.programming.learning.system.domain.valueobject.TypeSynchronizeStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SynchronizeStateDetailDataMapper {
    public QuerySynchronizeStateDetailResponse mapSynchronizeStateDetailToQuerySynchronizeStateDetailResponse(SynchronizeStateDetail synchronizeStateDetail) {
        return
            QuerySynchronizeStateDetailResponse.builder()
                .id(synchronizeStateDetail.getId().getValue())
                .status(synchronizeStateDetail.getStatus().name())
                .typeSynchronize(synchronizeStateDetail.getTypeSynchronize().name())
                    .webhookMessage(synchronizeStateDetail.getWebhookMessage())
                .build();
    }

public List<QuerySynchronizeStateDetailResponse> mapSynchronizeStateDetailToQuerySynchronizeStateDetailResponse(List<SynchronizeStateDetail> synchronizeStateDetails) {
        return synchronizeStateDetails.stream()
            .map(this::mapSynchronizeStateDetailToQuerySynchronizeStateDetailResponse)
                .toList();
    }


}
