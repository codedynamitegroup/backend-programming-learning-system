package com.backend.programming.learning.system.core.service.domain.dto.query.contest;

import com.backend.programming.learning.system.core.service.domain.entity.Contest;
import com.backend.programming.learning.system.core.service.domain.entity.Topic;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
public class QueryContestResponse {
    @NotNull
    private final Contest contest;
    @NotNull
    private final String message;
}
