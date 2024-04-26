package com.backend.programming.learning.system.dto.responseentity.question;

import com.backend.programming.learning.system.domain.valueobject.OrganizationId;
import com.backend.programming.learning.system.domain.valueobject.QuestionDifficulty;
import com.backend.programming.learning.system.domain.valueobject.QuestionId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * com.backend.programming.learning.system.dto.responseentity.question
 * Create by Dang Ngoc Tien
 * Date 4/18/2024 - 2:21 AM
 * Description: ...
 */
@Builder
public record QuestionResponseEntity(
        QuestionId questionId,
        OrganizationId organizationId,
        QuestionDifficulty difficulty,
        String name,
        String questionText,
        String generalFeedback,
        float defaultMark,
        String message
) {
}
