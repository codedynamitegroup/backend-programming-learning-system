package com.backend.programming.learning.system.core.service.domain.dto.method.query.contest;

import com.backend.programming.learning.system.core.service.domain.dto.responseentity.contest.ContestResponseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class QueryAllContestsResponse {
    @NotNull
    @JsonProperty("contests")
    private final List<ContestResponseEntity> contests;
    @NotNull
    @JsonProperty("currentPage")
    private final int currentPage;
    @NotNull
    @JsonProperty("totalItems")
    private final long totalItems;
    @NotNull
    @JsonProperty("totalPages")
    private final int totalPages;
}
