package com.backend.programming.learning.system.course.service.domain.dto.method.query.synchronize_state;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QuerySynchronizeStateCommand {
    private final UUID organizationId;
    private final String step;
}
