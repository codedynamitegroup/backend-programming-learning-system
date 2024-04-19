package com.backend.programming.learning.system.core.service.domain.dto.method.update.question;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class UpdateQtypeShortanswerQuestionCommand {
    @NotNull
    private final UUID qtShortanswerQuestionId;
    private Boolean caseSensitive;

    @NotNull
    private final UpdateQuestionEntity question;
}
