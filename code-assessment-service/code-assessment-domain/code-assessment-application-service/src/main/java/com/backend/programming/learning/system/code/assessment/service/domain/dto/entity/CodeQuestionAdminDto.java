package com.backend.programming.learning.system.code.assessment.service.domain.dto.entity;

import com.backend.programming.learning.system.domain.valueobject.QuestionDifficulty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CodeQuestionAdminDto {
    UUID id;
    UUID questionId;
    String name;
    String problemStatement;
    String inputFormat;
    String outputFormat;
    String constraints;
    Float maxGrade;
    Boolean isPublic;
    Boolean allowImport;
    QuestionDifficulty difficulty;
    List<TestCaseDto> testCases;
    List<ProgrammingLanguageDto> programmingLanguages;
    List<UUID> tags;
}
