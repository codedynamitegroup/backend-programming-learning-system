package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.programming_language;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class DeleteProgrammingLanguageCommand {
    @NotNull(message = "languageId must not be null")
    UUID languageId;
}
