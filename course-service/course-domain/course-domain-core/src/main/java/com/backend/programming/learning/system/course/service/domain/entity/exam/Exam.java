package com.backend.programming.learning.system.course.service.domain.entity.exam;

//import com.backend.programming.learning.system.entity.AggregateRoot;
//import com.backend.programming.learning.system.valueobject.ExamId;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * com.backend.programming.learning.system.course.service.domain.entity
 * Create by Dang Ngoc Tien
 * Date 3/24/2024 - 3:01 PM
 * Description: ...
 */
@Getter
@Setter
@Builder
public class Exam {//extends AggregateRoot<ExamId> {
    private Long courseId;
    private String name;
    private String intro;
    private Double score;
    private Double maxScore;
    private Long timeOpen;
    private Long timeClose;
    private Long timeLimit;
    private String overdueHandling;
    private Integer canRedoQuestions;
    private Long maxAttempts;
    private Integer shuffleAnswers;
    private String gradeMethod;

    public Exam(
//            ExamId id,
                Long courseId,
                String name,
                String intro,
                Double score,
                Double maxScore,
                Long timeOpen,
                Long timeClose,
                Long timeLimit,
                String overdueHandling,
                Integer canRedoQuestions,
                Long maxAttempts,
                Integer shuffleAnswers,
                String gradeMethod) {
//        super.setId(id);
        this.courseId = courseId;
        this.name = name;
        this.intro = intro;
        this.score = score;
        this.maxScore = maxScore;
        this.timeOpen = timeOpen;
        this.timeClose = timeClose;
        this.timeLimit = timeLimit;
        this.overdueHandling = overdueHandling;
        this.canRedoQuestions = canRedoQuestions;
        this.maxAttempts = maxAttempts;
        this.shuffleAnswers = shuffleAnswers;
        this.gradeMethod = gradeMethod;
    }
}
