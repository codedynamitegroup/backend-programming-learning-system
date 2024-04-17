package com.backend.programming.learning.system.core.service.domain.dto.method.query.programminglanguage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QueryProgrammingLanguageResponse {
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
