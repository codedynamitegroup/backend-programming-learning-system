package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_question;

import com.backend.programming.learning.system.domain.valueobject.CopyState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateCodeQuestionResponse {
    @NonNull
    private final String message;
    @NonNull
    private final UUID codeQuestionId;
    @NonNull
    private final CopyState state;
}
