package com.backend.programming.learning.system.auth.service.domain.dto.method.query.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public class QueryPieChartResponse {
    @JsonProperty("index")
    private final int index;

    @JsonProperty("value")
    private final int value;

    @JsonProperty("label")
    private final String label;
}
