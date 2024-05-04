package com.backend.programming.learning.system.core.service.domain.dto.method.update.question;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class UpdateQtypeCodeQuestionCommand {
    @NotNull
    private final UUID qtCodeQuestionId;
    private final String dslTemplate;

    private final String problemStatement;
    private final String name;
    private final Float maxGrade;

    @NotNull
    private final UpdateQuestionEntity question;
}
