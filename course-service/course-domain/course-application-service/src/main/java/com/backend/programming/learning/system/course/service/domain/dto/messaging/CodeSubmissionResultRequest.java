package com.backend.programming.learning.system.course.service.domain.dto.messaging;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CodeSubmissionResultRequest {
    private final UUID codeSubmissionId;
    private final Float grade;
    private final String result;
    private final Boolean passed;
    private final UUID sagaId;
}
