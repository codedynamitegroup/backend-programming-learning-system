package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.update.programming_language;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Builder
@AllArgsConstructor
@Getter
public class UpdateProgrammingLanguageCommand {
    @NotNull(message = "languageId must not be null")
    @Setter
    UUID languageId;

    String name;

    Integer languageJudge0Id;

    @Min(value = 1, message = "timitLimit must at least 1s")
    Float timeLimit;

    @Min(value = 204800, message = "memoryLimit must at least 204800 kB")
    Float memoryLimit;

    Boolean isActived;
}
