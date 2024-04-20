package com.backend.programming.learning.system.dto.method.create.exam;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.course.service.domain.create
 * Create by Dang Ngoc Tien
 * Date 3/24/2024 - 12:00 PM
 * Description: ...
 */
@Getter
@Builder
@AllArgsConstructor
public class CreateExamCommand {
    private final UUID courseId;
    @NotNull(message = "Exam name is required")
    private String name;
    private String intro;
    private Float score;
    private Float maxScore;
    private ZonedDateTime timeOpen;
    private ZonedDateTime timeClose;
    private ZonedDateTime timeLimit;
    private String overdueHandling;
    private Boolean canRedoQuestions;
    private Integer maxAttempts;
    private Boolean shuffleQuestions;
    private String gradeMethod;
}
