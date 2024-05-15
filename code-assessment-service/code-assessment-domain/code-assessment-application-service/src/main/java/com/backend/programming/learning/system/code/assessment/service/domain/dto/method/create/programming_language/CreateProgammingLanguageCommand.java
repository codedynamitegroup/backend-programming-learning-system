package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.programming_language;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Getter
public class CreateProgammingLanguageCommand {
    @NotNull(message = "name must not be null")
    String name;

    @NotNull(message = "languageJudge0Id must not be null")
    Integer languageJudge0Id;

    @NotNull(message = "timeLimit must not be null")
    @Min(value = 1, message = "timitLimit must at least 1s")
    Float timeLimit;

    @NotNull(message = "memoryLimit must not be null")
    @Min(value = 204800, message = "memoryLimit must at least 204800 kB")
    Float memoryLimit;

    @Setter
    Boolean isActived;
}
