package com.backend.programming.learning.system.dto.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

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
    private final String name;
    private final String intro;
    private final Float score;
    private final Float maxScore;
    private final ZonedDateTime timeOpen;
    private final ZonedDateTime timeClose;
    private final ZonedDateTime timeLimit;
    private final String overdueHandling;
    private final Boolean canRedoQuestions;
    private final Integer maxAttempts;
    private final Boolean shuffleQuestions;
    private final String gradeMethod;
    private final ZonedDateTime createdAt;
    private final ZonedDateTime updatedAt;
}
