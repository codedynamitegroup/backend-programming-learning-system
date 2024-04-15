package com.backend.programming.learning.system.code.assessment.service.domain.dto.create.testcase;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.create.commandentity.TestCase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateTestCasesCommand {
    @NotNull
    private final List<TestCase> testCases;
    @NotNull
    private final UUID codeQuestionId;
}
