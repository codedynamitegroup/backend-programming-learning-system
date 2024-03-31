package com.backend.programming.learning.system.course.service.dataaccess.mapper.exam;

import com.backend.programming.learning.system.course.service.dataaccess.entity.exam.ExamEntity;
import com.backend.programming.learning.system.course.service.domain.entity.exam.Exam;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * com.backend.programming.learning.system.course.service.dataaccess.exam.mapper
 * Create by Dang Ngoc Tien
 * Date 3/19/2024 - 11:21 PM
 * Description: ...
 */
@Component
public class ExamDataAccessMapper {
    public Exam examEntityToExam(ExamEntity examEntity) {
        return Exam.builder()
                .courseId(examEntity.getCourseId())
                .name(examEntity.getName())
                .intro(examEntity.getIntro())
                .score(examEntity.getScore())
                .maxScore(examEntity.getMaxScore())
                .timeOpen(examEntity.getTimeOpen())
                .timeClose(examEntity.getTimeClose())
                .timeLimit(examEntity.getTimeLimit())
                .overdueHandling(examEntity.getOverdueHandling())
                .canRedoQuestions(examEntity.getCanRedoQuestions())
                .maxAttempts(examEntity.getMaxAttempts())
                .shuffleAnswers(examEntity.getShuffleAnswers())
                .gradeMethod(examEntity.getGradeMethod())
                .build();
    }

    public ExamEntity examToExamEntity(Exam exam) {
        return ExamEntity.builder()
                .courseId(exam.getCourseId())
                .name(exam.getName())
                .intro(exam.getIntro())
                .score(exam.getScore())
                .maxScore(exam.getMaxScore())
                .timeOpen(exam.getTimeOpen())
                .timeClose(exam.getTimeClose())
                .timeLimit(exam.getTimeLimit())
                .overdueHandling(exam.getOverdueHandling())
                .canRedoQuestions(exam.getCanRedoQuestions())
                .maxAttempts(exam.getMaxAttempts())
                .shuffleAnswers(exam.getShuffleAnswers())
                .gradeMethod(exam.getGradeMethod())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    public ExamEntity updateExamEntity(ExamEntity examEntity, Exam exam) {
        return examEntity.builder()
                .id(examEntity.getId())
                .courseId(exam.getCourseId())
                .name(exam.getName())
                .intro(exam.getIntro())
                .score(exam.getScore())
                .maxScore(exam.getMaxScore())
                .timeOpen(exam.getTimeOpen())
                .timeClose(exam.getTimeClose())
                .timeLimit(exam.getTimeLimit())
                .overdueHandling(exam.getOverdueHandling())
                .canRedoQuestions(exam.getCanRedoQuestions())
                .maxAttempts(exam.getMaxAttempts())
                .shuffleAnswers(exam.getShuffleAnswers())
                .gradeMethod(exam.getGradeMethod())
                .createdAt(examEntity.getCreatedAt())
                .updatedAt(LocalDateTime.now())
                .build();
    }
}
