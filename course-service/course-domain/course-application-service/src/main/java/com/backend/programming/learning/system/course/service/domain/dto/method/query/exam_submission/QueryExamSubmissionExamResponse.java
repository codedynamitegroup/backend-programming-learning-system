package com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_submission;

import lombok.Builder;

import java.util.UUID;

@Builder
public record QueryExamSubmissionExamResponse(
        UUID examId,
        UUID courseId,
        String name,
        String timeOpen,
        String timeClose,
        Integer timeLimit,
        String intro,
        String overdueHanding,
        Boolean canRedoQuestions,
        Boolean shuffleAnswers
) {
}
