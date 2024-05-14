package com.backend.programming.learning.system.code.assessment.service.domain.dto.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProgrammingLanguageDto {
    @NotNull(message = "language id must not be null")
    UUID id;
    String name;
    Integer judge0Id;
    Boolean isActived;

    @NotNull(message = "timeLimit must not be null")
    @Min(value = 1, message = "timitLimit must at least 1s")
    Float timeLimit;

    @NotNull(message = "memoryLimit must not be null")
    @Min(value = 204800, message = "memoryLimit must at least 204800 kB")
    Float memoryLimit;
}
