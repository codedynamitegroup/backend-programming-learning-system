package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.test_case;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.entity.TestCaseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateTestCasesCommand {
    @NotNull(message = "testCases list must not be null")
    private final List<@Valid TestCaseDto> testCases;
    @NotNull(message = "codeQuestionId must not be null")
    private final UUID codeQuestionId;
}
