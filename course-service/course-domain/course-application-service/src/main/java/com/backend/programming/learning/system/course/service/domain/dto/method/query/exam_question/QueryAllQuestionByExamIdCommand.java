package com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_question;

import lombok.Builder;

/**
 * com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_question
 * Create by Dang Ngoc Tien
 * Date 5/29/2024 - 10:44 PM
 * Description: ...
 */
@Builder
public record QueryAllQuestionByExamIdCommand(
        String search,
        Integer currentPage
) {
}
