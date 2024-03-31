package com.backend.programming.learning.system.course.service.dataaccess.entity.exam;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * com.backend.programming.learning.system.course.service.dataaccess.exam.entity
 * Create by Dang Ngoc Tien
 * Date 3/19/2024 - 11:04 PM
 * Description: ...
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "exam", schema = "6bros_course")
@Entity
public class ExamEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
