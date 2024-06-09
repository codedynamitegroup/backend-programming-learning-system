package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_submission;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.nio.channels.FileLock;

@Getter
@AllArgsConstructor
@Builder
public class ExecuteCodeWithTestCaseCommand {
    @NotNull(message = "language_id must not be null")
    Integer language_id;

    @NotNull(message = "stdin must not be null")
    String stdin;

    @NotNull(message = "expected_output must not be null")
    String expected_output;

    @NotNull(message = "source_code must not be null")
    String source_code;

    Float cpu_time_limit;

    Float memory_limit;
}
