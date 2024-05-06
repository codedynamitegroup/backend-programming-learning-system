package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateSharedSolutionResponse {
    String message;
    UUID sharedSolutionId;
}
