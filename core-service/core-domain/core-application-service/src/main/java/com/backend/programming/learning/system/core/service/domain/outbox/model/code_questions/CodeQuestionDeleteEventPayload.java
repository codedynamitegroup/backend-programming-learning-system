package com.backend.programming.learning.system.core.service.domain.outbox.model.code_questions;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class CodeQuestionDeleteEventPayload {
    @JsonProperty
    private final String id;
    @JsonProperty
    private final String codeQuestionId;
    @JsonProperty
    private final String sagaId;
    @JsonProperty
    private final String questionId;
    @JsonProperty
    private String state;//copy state


}
