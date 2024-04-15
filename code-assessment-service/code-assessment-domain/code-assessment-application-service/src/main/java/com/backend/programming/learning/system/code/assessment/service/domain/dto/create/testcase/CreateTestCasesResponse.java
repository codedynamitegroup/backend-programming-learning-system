package com.backend.programming.learning.system.code.assessment.service.domain.dto.create.testcase;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.create.commandentity.TestCase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@Getter
@Builder
public class CreateTestCasesResponse {
    @NotNull
    private final String message;

    @NotNull
    private final List<TestCase> testCaseList;
}
