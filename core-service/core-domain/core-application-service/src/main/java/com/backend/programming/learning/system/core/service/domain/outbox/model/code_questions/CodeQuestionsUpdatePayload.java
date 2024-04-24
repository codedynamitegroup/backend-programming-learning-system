package com.backend.programming.learning.system.core.service.domain.outbox.model.code_questions;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
@Builder
public class CodeQuestionsUpdatePayload {
    @JsonProperty
    private final String id;
    @JsonProperty
    private final String codeQuestionId;
    @JsonProperty
    private final String sagaId;
    @JsonProperty
    private final String questionId;
    @JsonProperty
    private final String problemStatement;
    @JsonProperty
    private final String inputFormat;
    @JsonProperty
    private final String outputFormat;
    @JsonProperty
    private final String constraints;
    @JsonProperty
    private String state;
    @JsonProperty
    private List<String> failureMessages;
}
