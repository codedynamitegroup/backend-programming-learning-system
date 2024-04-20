package com.backend.programming.learning.system.code.assessment.service.domain.outbox.model.code_questions_update_outbox;

import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class CodeQuestionsUpdatePayload {
    @JsonProperty
    private final String questionId;
    @JsonProperty
    private final String dslTemplate;
    @JsonProperty
    private final String problemStatement;
    @JsonProperty
    private final String inputFormat;
    @JsonProperty
    private final String outputFormat;
    @JsonProperty
    private final String constraints;
    @JsonProperty
    private CopyState copyState;
}
