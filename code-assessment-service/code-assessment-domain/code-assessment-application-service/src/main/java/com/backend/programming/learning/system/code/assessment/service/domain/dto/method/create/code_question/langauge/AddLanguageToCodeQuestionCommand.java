package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_question.langauge;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.entity.ProgrammingLanguageDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
@Builder
public class AddLanguageToCodeQuestionCommand {
    @NotNull(message = "userId must not be null")
    UUID userId;

    @NotNull(message = "codeQuestionId must not be null")
    UUID codeQuestionId;

    @NotNull(message = "languageIds must not be null")
    List<@Valid ProgrammingLanguageDto> languages;
}
