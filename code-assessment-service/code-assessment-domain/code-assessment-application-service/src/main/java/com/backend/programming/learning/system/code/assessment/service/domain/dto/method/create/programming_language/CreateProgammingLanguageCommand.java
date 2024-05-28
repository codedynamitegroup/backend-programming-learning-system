package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.programming_language;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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

    @Pattern(regexp = "^(?:[A-Za-z0-9+/]{4})*(?:[A-Za-z0-9+/]{2}==|[A-Za-z0-9+/]{3}=)?$",
            message = "headCode must be base64 encoded")
    String headCode;
    @Pattern(regexp = "^(?:[A-Za-z0-9+/]{4})*(?:[A-Za-z0-9+/]{2}==|[A-Za-z0-9+/]{3}=)?$",
            message = "bodyCode must be base64 encoded")
    String bodyCode;
    @Pattern(regexp = "^(?:[A-Za-z0-9+/]{4})*(?:[A-Za-z0-9+/]{2}==|[A-Za-z0-9+/]{3}=)?$",
            message = "tailCode must be base64 encoded")
    String tailCode;

    @Setter
    Boolean isActived;
}
