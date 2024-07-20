package com.backend.programming.learning.system.core.service.domain.dto.responseentity.programminglanguage;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
@Builder
@AllArgsConstructor
@JsonInclude(NON_NULL)
@NoArgsConstructor(force = true)
public class ProgrammingLanguageIdResponseEntity {
    @NotNull
    @JsonProperty("id")
    private final UUID id;
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
