package com.backend.programming.learning.system.course.service.domain.dto.responseentity.question;

import com.backend.programming.learning.system.domain.valueobject.QuestionDifficulty;
import com.backend.programming.learning.system.domain.valueobject.QuestionType;
import lombok.Builder;

import java.util.UUID;

@Builder
public record QuestionWithPageResponseEntity(
        UUID id,
        QuestionDifficulty difficulty,
        Float defaultMark,
        String name,
        String questionText,
        Integer page,
        QuestionType qtype
) {
}
