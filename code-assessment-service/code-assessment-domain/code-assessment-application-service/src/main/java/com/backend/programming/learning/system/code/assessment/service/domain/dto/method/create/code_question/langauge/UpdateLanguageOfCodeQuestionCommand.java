package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_question.langauge;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.entity.ProgrammingLanguageDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
@Builder
public class UpdateLanguageOfCodeQuestionCommand {
    @NotNull(message = "email must not be null")
    @Setter
    @JsonIgnore
    String email;

    @NotNull(message = "codeQuestionId must not be null")
    @Setter
    @JsonIgnore
    UUID codeQuestionId;

    @NotNull(message = "updatedLanguages must not be null")
    List<@Valid ProgrammingLanguageDto> updatedLanguages;

    @NotNull(message = "deletedLangaugeIds must not be null")
    List<UUID> deletedLangaugeIds;
}
