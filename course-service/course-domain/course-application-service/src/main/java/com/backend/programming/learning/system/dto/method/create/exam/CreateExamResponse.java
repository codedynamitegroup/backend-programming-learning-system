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
@Getter
@Builder
@AllArgsConstructor
public class CreateExamResponse {
    private UUID id;
    private CourseId courseId;
    private String name;
    private Float scores;
    private Float maxScores;

    private ZonedDateTime timeOpen;
    private ZonedDateTime timeClose;
    private ZonedDateTime timeLimit;

    private String intro;
    private String overdueHanding;
    private Boolean canRedoQuestions;
    private Integer maxAttempts;
    private Boolean shuffleAnswers;
    private String gradeMethod;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    private String message;
}
