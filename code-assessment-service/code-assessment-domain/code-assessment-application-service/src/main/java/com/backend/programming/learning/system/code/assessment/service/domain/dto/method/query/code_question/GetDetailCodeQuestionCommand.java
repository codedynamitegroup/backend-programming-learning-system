package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_question;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Builder
@Getter
public class GetDetailCodeQuestionCommand {
    @NotNull(message = "codeQuestionIds must not be null")
    List<UUID> codeQuestionIds;

    String email;
}
