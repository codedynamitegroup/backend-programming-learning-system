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
public class CodeQuestionDto {
    UUID id;
    String name;
    String problemStatement;
    Boolean done;
    QuestionDifficulty difficulty;
    String sourceCode;
    UUID sourceCodeLanguageId;
    List<TestCaseDto> sampleTestCases;
    List<ProgrammingLanguageDto> languages;
}
