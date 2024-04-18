package com.backend.programming.learning.system.dto.method.query.exam;

import com.backend.programming.learning.system.valueobject.CourseId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.dto.query
 * Create by Dang Ngoc Tien
 * Date 4/17/2024 - 1:05 AM
 * Description: ...
 */
@Getter
@Builder
@AllArgsConstructor
public class QueryExamResponse { // xiu delete sau
    private UUID id;
    private CourseId courseId;
    private String name;
    private Float scores;
    private Float maxScores;

    private final ZonedDateTime timeOpen;
    private ZonedDateTime timeClose;
    private ZonedDateTime timeLimit;

    private String intro;
    private String overdueHanding;
    private Boolean canRedoQuestions;
    private Integer maxAttempts;

    private Boolean shuffleAnswers;
    private String gradeMethod;
    private final ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    private final String message;
}
