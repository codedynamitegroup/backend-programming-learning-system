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
    private final UUID id;
    @JsonProperty
    private final UUID codeQuestionId;
    @JsonProperty
    private final UUID sagaId;
    @JsonProperty
    private final UUID questionId;
    @JsonProperty
    private final String problemStatement;
    @JsonProperty
    private final Float maxGrade;
    @JsonProperty
    private final String name;
    @JsonProperty
    private final Boolean isPublic;
    @JsonProperty
    private final Boolean allowImport;
    @JsonProperty
    private final String constraints;
    @JsonProperty
    private String state;//copy state
    @JsonProperty
    private List<String> failureMessages;

    public void setFailureMessages(List<String> failureMessages) {
        this.failureMessages = failureMessages;
    }

    public void setState(String state) {
        this.state = state;
    }
}
