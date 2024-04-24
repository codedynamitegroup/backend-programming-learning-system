package com.backend.programming.learning.system.dto.method.create.exam;

import com.backend.programming.learning.system.valueobject.CourseId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

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
        ZonedDateTime timeLimit,
        String intro,
        String overdueHanding,
        Boolean canRedoQuestions,
        Integer maxAttempts,
        Boolean shuffleAnswers,
        String gradeMethod,
        ZonedDateTime createdAt,
        ZonedDateTime updatedAt,
        String message
) {
}
