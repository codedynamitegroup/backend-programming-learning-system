package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_submission;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
@Builder
public class CreateCodeSubmissionResponse {
    String status;
    String message;
    UUID codeSubmissionId;
}
