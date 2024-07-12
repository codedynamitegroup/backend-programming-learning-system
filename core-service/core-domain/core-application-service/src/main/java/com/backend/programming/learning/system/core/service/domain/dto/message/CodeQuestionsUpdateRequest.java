package com.backend.programming.learning.system.core.service.domain.dto.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CodeQuestionsUpdateRequest {
    private final UUID id;
    private final UUID codeQuestionId;
    private final UUID sagaId;
    private final UUID questionId;
    private final String problemStatement;
    private final String name;
    private final Float maxGrade;
    private final Boolean isPublic;
    private final Boolean isAllowedToImport;
    private final UUID orgId;
    private final String email;
    private String difficulty;
    private Boolean isQuestionBank;
    private UUID categoryBank;
//    private final String constraints;
    private String state;//copy state
}
