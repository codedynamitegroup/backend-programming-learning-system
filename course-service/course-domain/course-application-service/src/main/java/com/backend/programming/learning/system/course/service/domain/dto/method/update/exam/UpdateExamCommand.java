package com.backend.programming.learning.system.course.service.domain.dto.method.update.exam;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam.CreateQuestionExamCommand;
import com.backend.programming.learning.system.course.service.domain.valueobject.OverdueHandling;
import lombok.Builder;

import jakarta.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.dto.method.update.exam
 * Create by Dang Ngoc Tien
 * Date 4/21/2024 - 12:26 AM
 * Description: ...
 */
@Builder
public record UpdateExamCommand(
        UUID courseId,
        @NotNull(message = "Exam name is required")
        String name,
        @NotNull(message = "Exam intro is required")
        String intro,
        @NotNull(message = "Exam score is required")
        Float score,
        @NotNull(message = "Exam max score is required")
        Float maxScore,
        ZonedDateTime timeOpen,
        ZonedDateTime timeClose,
        ZonedDateTime timeLimit,
        @NotNull(message = "Exam overdue handling is required")
        OverdueHandling overdueHandling,
        //    @NotNull(message = "Exam can redo questions is required")
        Boolean canRedoQuestions,
        @NotNull(message = "Exam max attempts is required")
        Integer maxAttempts,
        @NotNull(message = "Exam shuffle questions is required")
        Boolean shuffleQuestions,
        @NotNull(message = "Exam grade method is required")
        String gradeMethod,
        @NotNull(message = "Question ids are required")
        List<CreateQuestionExamCommand> questionIds
) {
}
