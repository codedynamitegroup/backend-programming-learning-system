package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.test_case;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class PatchDeleteTestCasesCommand {
    @NotNull(message = "testCaseIds must not be null")
    List<UUID> testCaseIds;

}
