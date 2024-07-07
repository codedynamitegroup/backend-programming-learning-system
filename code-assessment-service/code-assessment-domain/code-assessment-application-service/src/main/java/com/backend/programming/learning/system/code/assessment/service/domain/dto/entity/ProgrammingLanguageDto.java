package com.backend.programming.learning.system.code.assessment.service.domain.dto.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor(force = true)
public class ProgrammingLanguageDto {
    @NotNull(message = "language id must not be null")
    @JsonProperty("id")
    UUID id;
    @JsonProperty("name")
    String name;
    @JsonProperty("judge0Id")
    Integer judge0Id;
    @JsonProperty("isActived")
    Boolean isActived;

    @NotNull(message = "timeLimit must not be null")
    @Min(value = 1, message = "timitLimit must at least 1s")
    @JsonProperty("timeLimit")
    Float timeLimit;

    @NotNull(message = "memoryLimit must not be null")
    @Min(value = 204800, message = "memoryLimit must at least 204800 kB")
    @JsonProperty("memoryLimit")
    Float memoryLimit;

    @Pattern(regexp = "^(?:[A-Za-z0-9+/]{4})*(?:[A-Za-z0-9+/]{2}==|[A-Za-z0-9+/]{3}=)?$",
            message = "headCode must be base64 encoded")
    @JsonProperty("headCode")
    String headCode;
    @Pattern(regexp = "^(?:[A-Za-z0-9+/]{4})*(?:[A-Za-z0-9+/]{2}==|[A-Za-z0-9+/]{3}=)?$",
            message = "bodyCode must be base64 encoded")
    @JsonProperty("bodyCode")
    String bodyCode;
    @Pattern(regexp = "^(?:[A-Za-z0-9+/]{4})*(?:[A-Za-z0-9+/]{2}==|[A-Za-z0-9+/]{3}=)?$",
            message = "tailCode must be base64 encoded")
    @JsonProperty("tailCode")
    String tailCode;
}
