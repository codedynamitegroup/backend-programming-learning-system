package com.backend.programming.learning.system.auth.service.domain.dto.method.query.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public class QueryLineChartResponse {
    @JsonProperty("data")
    private final long[] data;

    @JsonProperty("label")
    private final String label;

    @JsonProperty("area")
    private final boolean area;
}
