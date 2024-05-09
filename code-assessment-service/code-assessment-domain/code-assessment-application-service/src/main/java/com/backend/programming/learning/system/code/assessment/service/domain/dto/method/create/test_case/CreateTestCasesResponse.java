package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.test_case;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;

@AllArgsConstructor
@Getter
@Builder
public class CreateTestCasesResponse {
    @NotNull
    private final String message;

//    @NotNull
//    private final List<TestCase> testCaseList;
}
