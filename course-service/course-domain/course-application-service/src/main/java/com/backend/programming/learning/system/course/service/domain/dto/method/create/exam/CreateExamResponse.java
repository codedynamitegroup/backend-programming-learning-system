package com.backend.programming.learning.system.course.service.domain.dto.method.create.exam;

import com.backend.programming.learning.system.course.service.domain.valueobject.CourseId;
import com.backend.programming.learning.system.course.service.domain.valueobject.OverdueHandling;
import lombok.Builder;

import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.course.service.domain.create
 * Create by Dang Ngoc Tien
 * Date 3/24/2024 - 2:52 PM
 * Description: ...
 */
@Builder
public record CreateExamResponse(
        UUID id,
        CourseId courseId,
        String name,
        Float scores,
        Float maxScores,
        ZonedDateTime timeOpen,
        ZonedDateTime timeClose,
        Integer timeLimit,
        String intro,
        OverdueHandling overdueHanding,
        Boolean canRedoQuestions,
        Integer maxAttempts,
        Boolean shuffleAnswers,
        String gradeMethod,
        ZonedDateTime createdAt,
        ZonedDateTime updatedAt,
        Integer maxPage,
        UUID categoryId,
        String message
) {
}
