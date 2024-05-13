package com.backend.programming.learning.system.core.service.domain.dto.responseentity.programminglanguage;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
@Builder
@AllArgsConstructor
@JsonInclude(NON_NULL)
public class ProgrammingLanguageResponseEntity {
    @NotNull
    private final UUID programmingLanguageId;
    @NotNull
    private final String name;
    @NotNull
    private final Integer compilerApiId;
    @NotNull
    private final Float timeLimit;
    @NotNull
    private final Float memoryLimit;
}
