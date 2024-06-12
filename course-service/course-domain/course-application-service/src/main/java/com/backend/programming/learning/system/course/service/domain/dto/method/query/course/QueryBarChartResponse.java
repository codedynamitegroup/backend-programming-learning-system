package com.backend.programming.learning.system.course.service.domain.dto.method.query.course;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public class QueryBarChartResponse {
    @JsonProperty("data")
    private final long[] data;

    @JsonProperty("label")
    private final String label;
}
