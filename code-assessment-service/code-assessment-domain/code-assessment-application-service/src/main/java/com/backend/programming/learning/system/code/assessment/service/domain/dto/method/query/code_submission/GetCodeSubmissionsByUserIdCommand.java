package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_submission;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import lombok.Setter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class GetCodeSubmissionsByUserIdCommand {
    @NotNull(message = "email must not be null")
    String email;

    @NotNull(message = "codeQuestionId must not be null")
    UUID codeQuestionId;

    @Positive(message = "pageSize must be positive")
    @Setter
    @JsonIgnore
    Integer pageSize;

    @PositiveOrZero(message = "pageNum must not be negative")
    @Setter
    @JsonIgnore
    Integer pageNum;

    UUID contestId;
    UUID cerCourseId;
}
