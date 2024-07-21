package com.backend.programming.learning.system.course.service.domain.outbox.model.code_submission_sender;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CodeSubmissionEventPayload {
    @JsonProperty
    private final String submissionId;
    @JsonProperty
    private final String questionId;
    @JsonProperty
    private final String userId;
    @JsonProperty
    private final String content;
}
