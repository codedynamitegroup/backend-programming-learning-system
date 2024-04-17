package com.backend.programming.learning.system.core.service.domain.dto.method.query.topic;

import com.backend.programming.learning.system.core.service.domain.dto.responseentity.topic.TopicResponseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class QueryAllTopicsResponse {
    @NotNull
    private final List<TopicResponseEntity> topics;
    @NotNull
    private final int currentPage;
    @NotNull
    private final long totalItems;
    @NotNull
    private final int totalPages;
}
