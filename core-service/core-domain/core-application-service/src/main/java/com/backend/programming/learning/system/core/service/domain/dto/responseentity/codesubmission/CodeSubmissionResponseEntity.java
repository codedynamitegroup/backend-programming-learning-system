package com.backend.programming.learning.system.core.service.domain.dto.responseentity.codesubmission;

import com.backend.programming.learning.system.core.service.domain.dto.responseentity.programminglanguage.ProgrammingLanguageResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.question.QuestionResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.user.UserResponseEntity;
import com.backend.programming.learning.system.core.service.domain.entity.ProgrammingLanguage;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
@Builder
@AllArgsConstructor
@JsonInclude(NON_NULL)
public class CodeSubmissionResponseEntity {
    @NotNull
    private final UUID codeSubmissionId;
    @NotNull
    private final UUID userId;
    @NotNull
    private final UUID codeQuestionId;
    @NotNull
    private final UUID programmingLanguageId;
    @NotNull
    private final String sourceCode;
    @NotNull
    private final Float grade;
    @NotNull
    private final Boolean pass;
    @NotNull
    private final ZonedDateTime createdAt;

}
