package com.backend.programming.learning.system.course.service.domain.dto.responseentity.exam;

import com.backend.programming.learning.system.course.service.domain.valueobject.CourseId;
import com.backend.programming.learning.system.course.service.domain.valueobject.OverdueHandling;
import lombok.Builder;

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
        UUID courseId,
        String courseName,
        String name,
        Float scores,
        Float maxScores,
        ZonedDateTime timeOpen,
        ZonedDateTime timeClose,
        Integer timeLimit,
        Integer timeLimitUnit,
        String unit,
        String intro,
        OverdueHandling overdueHanding,
        Boolean canRedoQuestions,
        Integer maxAttempts,
        Boolean shuffleAnswers,
        String gradeMethod,
        ZonedDateTime createdAt,
        ZonedDateTime updatedAt,
        Integer maxPage,
        UUID sectionId
) {
}
