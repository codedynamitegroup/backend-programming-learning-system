package com.backend.programming.learning.system.code.assessment.service.domain.dto.message.code_submission;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CodeSubmissionReceiver {
    UUID submissionId;
    UUID sagaId;
    UUID userId;
    String content;
}
