package com.backend.programming.learning.system.dto.method.update.exam;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.dto.method.update.exam
 * Create by Dang Ngoc Tien
 * Date 4/21/2024 - 12:26 AM
 * Description: ...
 */
@Getter
@Builder
@AllArgsConstructor
public class UpdateExamCommand {
    private UUID courseId;
    @NotNull(message = "Exam name is required")
    private String name;
    @NotNull(message = "Exam intro is required")
    private String intro;
    @NotNull(message = "Exam score is required")
    private Float score;
    @NotNull(message = "Exam max score is required")
    private Float maxScore;
    private ZonedDateTime timeOpen;
    private ZonedDateTime timeClose;
    private ZonedDateTime timeLimit;
    @NotNull(message = "Exam overdue handling is required")
    private String overdueHandling;
//    @NotNull(message = "Exam can redo questions is required")
    private Boolean canRedoQuestions;
    @NotNull(message = "Exam max attempts is required")
    private Integer maxAttempts;
    @NotNull(message = "Exam shuffle questions is required")
    private Boolean shuffleQuestions;
    @NotNull(message = "Exam grade method is required")
    private String gradeMethod;
}
