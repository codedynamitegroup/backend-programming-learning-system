package com.backend.programming.learning.system.course.service.domain.dto.responseentity.question;

import com.backend.programming.learning.system.domain.valueobject.QuestionDifficulty;
import com.backend.programming.learning.system.domain.valueobject.QuestionType;
import lombok.Builder;

import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.dto.responseentity.question
 * Create by Dang Ngoc Tien
 * Date 4/18/2024 - 2:21 AM
 * Description: ...
 */
@Builder
public record QuestionResponseEntity(
        UUID id,
        UUID organizationId,
        QuestionDifficulty difficulty,
        String name,
        String questionText,
        String generalFeedback,
        float defaultMark,
        QuestionType qtype,
        ZonedDateTime createdAt,
        ZonedDateTime updatedAt,
        String message
) {
}
