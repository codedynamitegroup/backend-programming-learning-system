package com.backend.programming.learning.system.core.service.domain.dto.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@ToString
public class CodeSubmissionUpdateRequest {
    private final UUID id;
    private final UUID codeQuestionId;
    private final UUID codeSubmissionId;
    private final UUID userId;
    private final UUID programmingLanguageId;
    private final String bodyCode;
    private final Float grade;
    private final Boolean pass;
    private final ZonedDateTime createdAt;
    private String copyState;
}
