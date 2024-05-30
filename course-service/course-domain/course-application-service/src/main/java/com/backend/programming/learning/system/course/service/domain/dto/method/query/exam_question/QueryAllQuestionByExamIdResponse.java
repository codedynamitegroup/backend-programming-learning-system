package com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_question;

import com.backend.programming.learning.system.course.service.domain.dto.responseentity.question.QuestionResponseEntity;
import lombok.Builder;

import java.util.List;

/**
 * com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_question
 * Create by Dang Ngoc Tien
 * Date 5/29/2024 - 10:45 PM
 * Description: ...
 */
@Builder
public record QueryAllQuestionByExamIdResponse(
        List<QuestionResponseEntity> questions
) {
}
