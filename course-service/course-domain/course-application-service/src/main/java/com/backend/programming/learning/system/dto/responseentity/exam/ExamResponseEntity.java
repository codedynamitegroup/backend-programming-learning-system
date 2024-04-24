package com.backend.programming.learning.system.dto.responseentity.exam;

import com.backend.programming.learning.system.valueobject.CourseId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.dto.responseentity.exam
 * Create by Dang Ngoc Tien
 * Date 4/18/2024 - 8:09 PM
 * Description: ...
 */
@Builder
public record ExamResponseEntity(
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
        ZonedDateTime updatedAt
) {
}
