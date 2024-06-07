package com.backend.programming.learning.system.core.service.domain.dto.responseentity.programminglanguage;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;

import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
@Builder
@AllArgsConstructor
@JsonInclude(NON_NULL)
@NoArgsConstructor(force = true)
public class ProgrammingLanguageResponseEntity {
    @NotNull
    @JsonProperty("programmingLanguageId")
    private final UUID programmingLanguageId;
    @NotNull
    @JsonProperty("name")
    private final String name;
    @NotNull
    @JsonProperty("compilerApiId")
    private final Integer compilerApiId;
    @NotNull
    @JsonProperty("timeLimit")
    private final Float timeLimit;
    @NotNull
    @JsonProperty("memoryLimit")
    private final Float memoryLimit;
}
