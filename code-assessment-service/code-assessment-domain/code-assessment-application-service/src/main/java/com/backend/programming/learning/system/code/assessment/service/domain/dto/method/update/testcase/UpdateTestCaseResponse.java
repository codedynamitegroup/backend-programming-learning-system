package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.update.testcase;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Getter
@Builder
public class UpdateTestCaseResponse {
    @NotNull
    private final String message;
}