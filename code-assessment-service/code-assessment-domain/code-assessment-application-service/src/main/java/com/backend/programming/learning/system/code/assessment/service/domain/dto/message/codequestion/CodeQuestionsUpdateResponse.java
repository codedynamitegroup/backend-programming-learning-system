package com.backend.programming.learning.system.code.assessment.service.domain.dto.message.codequestion;

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
    private Float maxGrade;
    private String name;
    private Boolean isPublic;
    private Boolean allowImport;
    private CopyState state;
    private String constraints;
    private UUID sagaId;
    private List<String> failureMessages;
}
