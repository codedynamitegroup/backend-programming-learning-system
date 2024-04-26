package com.backend.programming.learning.system.course.service.domain.dto.method.update.exam;

import com.backend.programming.learning.system.course.service.domain.valueobject.OverdueHandling;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

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
public class UpdateExamResponse {
    private UUID examId;
    private UUID courseId;
    private String name;
    private String intro;
    private Float score;
    private Float maxScore;
    private ZonedDateTime timeOpen;
    private ZonedDateTime timeClose;
    private Integer timeLimit;
    private OverdueHandling overdueHandling;
    private Boolean canRedoQuestions;
    private Integer maxAttempts;
    private Boolean shuffleQuestions;
    private String gradeMethod;
    private String message;
}
