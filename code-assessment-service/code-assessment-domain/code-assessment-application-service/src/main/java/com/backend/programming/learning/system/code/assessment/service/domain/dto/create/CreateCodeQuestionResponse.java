package com.backend.programming.learning.system.code.assessment.service.domain.dto.create;

import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeQuestion;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Getter
@Builder
@AllArgsConstructor
public class CreateCodeQuestionResponse {
    @NonNull
    private final String message;
    @NonNull
    private final CodeQuestionId codeQuestionId;
}
