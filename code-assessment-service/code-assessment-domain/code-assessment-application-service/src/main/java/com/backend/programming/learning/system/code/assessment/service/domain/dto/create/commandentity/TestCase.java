package com.backend.programming.learning.system.code.assessment.service.domain.dto.create.commandentity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@AllArgsConstructor
@Builder
public class TestCase {
    @NotNull
    private final String inputData;
    @NotNull
    private final String outputData;
    @NotNull
    private final boolean isSample;

    private UUID id;
}
