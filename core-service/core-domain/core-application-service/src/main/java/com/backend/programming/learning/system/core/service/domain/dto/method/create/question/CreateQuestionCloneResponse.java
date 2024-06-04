package com.backend.programming.learning.system.core.service.domain.dto.method.create.question;

import com.backend.programming.learning.system.core.service.domain.dto.responseentity.question.QuestionResponseEntity;
import lombok.Builder;

import java.util.List;

/**
 * com.backend.programming.learning.system.course.service.domain.dto.question.create
 * Create by Dang Ngoc Tien
 * Date 3/25/2024 - 11:06 PM
 * Description: ...
 */
@Builder
public record CreateQuestionCloneResponse(
       List<QuestionResponseEntity> questions
) {
}
