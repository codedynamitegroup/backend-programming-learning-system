package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.code_question.tag;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Builder
public class DeleteCodeQuestionTagCommand {
    @NotNull(message = "userId must not be null")
    UUID userId;

    @NotNull(message = "codeQuestionId must not be null")
    UUID codeQuestionId;

    @NotNull(message = "languageIds must not be null")
    List<UUID> tagIds;
}
