package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.update.testcase;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.entity.TestCaseDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
//@OneNotNull(
//        fields = {"inputData", "outputData", "isSample", "score"},
//        message = "inputData, outputData, isSample or score must not be null"
//)
public class UpdateTestCaseCommand {
    @NotNull(message = "updatedTestCases must not be null")
    private final List<@Valid TestCaseDto> updatedTestCases;
    @NotNull(message = "newTestCases must not be null")
    private final List<@Valid TestCaseDto> newTestCases;
    @NotNull(message = "deletedTestCasesId must not be null")
    private final List<UUID> deletedTestCasesId;

    @NotNull(message = "codeQuestionId must not be null")
    private final UUID codeQuestionId;

}
