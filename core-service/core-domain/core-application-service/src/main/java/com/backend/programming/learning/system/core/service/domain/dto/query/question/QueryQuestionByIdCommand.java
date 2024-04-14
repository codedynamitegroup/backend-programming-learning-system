package com.backend.programming.learning.system.core.service.domain.dto.query.question;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QueryQuestionByIdCommand {
    @NotNull
    private final UUID questionId;
}
