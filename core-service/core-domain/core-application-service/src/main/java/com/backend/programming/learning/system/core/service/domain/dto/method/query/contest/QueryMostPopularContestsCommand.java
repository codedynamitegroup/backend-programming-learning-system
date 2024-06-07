package com.backend.programming.learning.system.core.service.domain.dto.method.query.contest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class QueryMostPopularContestsCommand {
    private final String email;
}
