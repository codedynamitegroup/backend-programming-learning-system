package com.backend.programming.learning.system.code.assessment.service.domain.dto.message;

import com.backend.programming.learning.system.domain.valueobject.CopyState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.UUID;
@Getter
@Builder
@AllArgsConstructor
public class CodeQuestionsUpdateResponse {
    private UUID id;
    private UUID codeQuestionId;
    private UUID questionId;
    private String problemStatement;
    private String inputFormat;
    private String outputFormat;
    private CopyState state;
    private String constraints;
    private UUID sagaId;
    private List<String> failureMessages;
}
