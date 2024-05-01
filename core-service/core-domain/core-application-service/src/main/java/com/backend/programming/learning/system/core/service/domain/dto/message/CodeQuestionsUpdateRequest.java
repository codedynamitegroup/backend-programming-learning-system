package com.backend.programming.learning.system.core.service.domain.dto.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class CodeQuestionsUpdateRequest {
    private final String id;
    private final String codeQuestionId;
    private final String sagaId;
    private final String questionId;
    private final String problemStatement;
    private final String inputFormat;
    private final String outputFormat;
//    private final String constraints;
    private String state;//copy state
}
