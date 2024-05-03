package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_submission;

import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.GradingStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetCodeSubmissionsByUserIdResponseItem {
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
    Float maxGrade;
    Double achievedGrade;
    @NotNull
    String description;
}
