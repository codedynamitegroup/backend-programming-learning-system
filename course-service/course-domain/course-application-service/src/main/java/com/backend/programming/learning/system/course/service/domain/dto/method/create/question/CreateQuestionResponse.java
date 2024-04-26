package com.backend.programming.learning.system.course.service.domain.dto.method.create.question;

import com.backend.programming.learning.system.domain.valueobject.OrganizationId;
import com.backend.programming.learning.system.domain.valueobject.QuestionDifficulty;
import com.backend.programming.learning.system.domain.valueobject.QuestionId;
import lombok.Builder;

/**
 * com.backend.programming.learning.system.course.service.domain.dto.question.create
 * Create by Dang Ngoc Tien
 * Date 3/25/2024 - 11:06 PM
 * Description: ...
 */
@Builder
public record CreateQuestionResponse(
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
