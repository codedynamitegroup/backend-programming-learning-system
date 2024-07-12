package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_question;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.entity.ProgrammingLanguageDto;
import com.backend.programming.learning.system.domain.valueobject.QuestionDifficulty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
@Builder
public class CreateCodeQuestionCommand {
//    @NotNull(message = "questionId must not be null")
//    private final UUID questionId;

    @NotNull(message = "email must not be null")
    @Setter
    @JsonIgnore
    private String email;

    private final UUID orgId;

    private final String dslTemplate;
    @NotNull(message = "name must not be null")
    private final String name;
    @NotNull(message = "problemStatement must not be null")
    private final String problemStatement;
    @NotNull(message = "inputFormat must not be null")
    private final String inputFormat;
    @NotNull(message = "outputFormat must not be null")
    private final String outputFormat;
    @NotNull(message = "constraints must not be null")
    private final String constraints;
    @NotNull(message = "maxGrade must not be null")
    private final Float maxGrade;
    @NotNull(message = "difficulty must not be null")
    private final QuestionDifficulty difficulty;

    @NotNull(message = "isPublic must not be null")
    private Boolean isPublic;

    @NotNull(message = "allowImport must not be null")
    private Boolean allowImport;

    private UUID categoryBankId;

    @Setter
    private Boolean isQuestionBank;

    private final List<@Valid ProgrammingLanguageDto> programmingLanuages;

    private final List<UUID> tagIds;
}
