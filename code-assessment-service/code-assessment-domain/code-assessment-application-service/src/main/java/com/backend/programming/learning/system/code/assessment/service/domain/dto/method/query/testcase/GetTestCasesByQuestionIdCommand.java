package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.testcase;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class GetTestCasesByQuestionIdCommand {
    @NotNull(message = "codeQuestionId must not be null")
    UUID codeQuestionId;

    @PositiveOrZero(message = "pageNum must not be negative")
    Integer pageNum;

    @PositiveOrZero(message = "pageSize must not be negative")
    Integer pageSize;

    Boolean fetchAll;
}
