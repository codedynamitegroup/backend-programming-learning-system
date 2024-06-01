package com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_question;

import com.backend.programming.learning.system.course.service.domain.dto.responseentity.question.QuestionWithPageResponseEntity;
import lombok.Builder;

import java.util.List;

@Builder
public record QueryAllQuestionByExamIdWithPageAttResponse(
        List<QuestionWithPageResponseEntity> questions
) {
}
