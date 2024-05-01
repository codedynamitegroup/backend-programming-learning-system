package com.backend.programming.learning.system.core.service.domain.outbox.model.question;

import com.backend.programming.learning.system.domain.valueobject.QuestionId;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class QuestionEventAnswer {
    @JsonProperty
    private String id;
    @JsonProperty
    private String questionId;
    @JsonProperty
    private String feedback;
    @JsonProperty
    private String answer;
    @JsonProperty
    private Float fraction;
}
