package com.backend.programming.learning.system.core.service.domain.dto.responseentity.contest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public class QueryPieChartResponse {
    @JsonProperty("index")
    private final long index;

    @JsonProperty("value")
    private final long value;

    @JsonProperty("label")
    private final String label;
}
