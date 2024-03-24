package com.backend.programming.learning.system.course.service.domain.dto.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

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
//    private final Long examId;
    private final Long courseId;
    private final String name;
    private final String intro;
    private final Double score;
    private final Double maxScore;
    private final Long timeOpen;
    private final Long timeClose;
    private final Long timeLimit;
    private final String overdueHandling;
    private final Integer canRedoQuestion;
    private final Long maxAttempts;
    private final Integer shuffleAnswer;
    private final String gradeMethod;
}
