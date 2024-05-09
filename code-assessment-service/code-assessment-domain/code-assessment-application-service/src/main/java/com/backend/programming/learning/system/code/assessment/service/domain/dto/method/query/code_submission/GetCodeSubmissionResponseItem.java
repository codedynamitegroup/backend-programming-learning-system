package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_submission;

import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.GradingStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetCodeSubmissionResponseItem {
    @NotNull
    UUID id;

    @NotNull
    UUID codeQuestionId;

    @NotNull
    UUID programmingLanguageId;
    Double avgRuntime;
    Double avgMemory;

    @NotNull
    GradingStatus gradingStatus;

    @NotNull
    Float maxGrade;

    @NotNull
    Double achievedGrade;

    @NotNull
    String description;

    String sourceCode;
    FirstFailTestCase firstFailTestCase;

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class FirstFailTestCase{
        @NotNull
        String input;

        @NotNull
        String output;

        String actualOutput;
        String stderr;
        String compileOutput;
        Float runtime;
        Float memory;
        String message;
        @NotNull
        String description;
    }

    public void setFirstFailTestCase(FirstFailTestCase firstFailTestCase) {
        this.firstFailTestCase = firstFailTestCase;
    }
}
