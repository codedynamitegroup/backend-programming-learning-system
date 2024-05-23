package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.update.programming_language;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.validator.OneNotNull.OneNotNull;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Builder
@AllArgsConstructor
@Getter
@OneNotNull(
        fields = {"name", "languageJudge0Id", "timeLimit", "memoryLimit", "isActived"},
        message = "name, languageJudge0Id, timeLimit, memoryLimit or isActived must not be null"
)
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

    @Pattern(regexp = "^(?:[A-Za-z0-9+/]{4})*(?:[A-Za-z0-9+/]{2}==|[A-Za-z0-9+/]{3}=)?$",
            message = "headCode must be base64 encoded")
    String headCode;
    @Pattern(regexp = "^(?:[A-Za-z0-9+/]{4})*(?:[A-Za-z0-9+/]{2}==|[A-Za-z0-9+/]{3}=)?$",
            message = "bodyCode must be base64 encoded")
    String bodyCode;
    @Pattern(regexp = "^(?:[A-Za-z0-9+/]{4})*(?:[A-Za-z0-9+/]{2}==|[A-Za-z0-9+/]{3}=)?$",
            message = "tailCode must be base64 encoded")
    String tailCode;
}
