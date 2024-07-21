package com.backend.programming.learning.system.code.assessment.service.domain.outbox.model.code_submission_update_outbox;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@AllArgsConstructor
@Builder
@ToString
public class CodeSubmissionUpdatePayload {
    @JsonProperty
    private final String id;
    @JsonProperty
    private final String codeQuestionId;
    @JsonProperty
    private final String userId;
    @JsonProperty
    private final String programmingLanguageId;
    @JsonProperty
    private final String bodyCode;
    @JsonProperty
    private final Float grade;
    @JsonProperty
    private final Boolean pass;
    @JsonProperty
    private final ZonedDateTime createdAt;
    @JsonProperty
    private String copyState;
    @JsonProperty
    private final UUID cerCourseId;
    @JsonProperty
    private final UUID contestId;
    @JsonProperty
    private final String result;
}
