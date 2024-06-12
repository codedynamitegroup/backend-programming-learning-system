package com.backend.programming.learning.system.core.service.domain.dto.responseentity.contest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public class QueryLineChartResponse {
    @JsonProperty("data")
    private final float[] data;

    @JsonProperty("label")
    private final String label;
}
