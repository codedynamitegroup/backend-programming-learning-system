package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_submission;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.entity.UserDto;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.GradingStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import lombok.Setter;

import java.time.ZonedDateTime;
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
    ZonedDateTime createdAt;

    UserDto user;

    @NotNull
    GradingStatus gradingStatus;

    @NotNull
    Float maxGrade;

    @NotNull
    Double achievedGrade;

    String description;

//    @Setter
//    String headCode;
//
//    @Setter
//    String bodyCode;
//
//    @Setter
//    String tailCode;
    @Setter
    String sourceCode;

    @Setter
    FirstFailTestCase firstFailTestCase;

    @Setter
    CodeQuestion codeQuestion;

    @Getter
    @Builder
    @AllArgsConstructor
    public static class CodeQuestion{
        UUID id;
        String name;
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
        String description;
    }

}
