package com.backend.programming.learning.system.course.service.dataaccess.exam.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.exam.entity.ExamEntity;
import com.backend.programming.learning.system.entity.Exam;
import com.backend.programming.learning.system.valueobject.ExamId;
import org.springframework.stereotype.Component;

@Component
public class ExamDataAccessMapper{
    public ExamEntity examToExamEntity(Exam exam) {
        return ExamEntity.builder()
                .id(exam.getId().getValue())
                .name(exam.getName())
                .intro(exam.getIntro())
                .score(exam.getScores())
                .maxScore(exam.getMaxScores())
                .timeOpen(exam.getTime_open())
                .timeClose(exam.getTime_close())
                .timeLimit(exam.getTime_limit())
                .overdueHandling(exam.getOverdue_handing())
                .canRedoQuestions(exam.getCan_redo_questions())
                .maxAttempts(exam.getMax_attempts())
                .shuffleQuestions(exam.getShuffle_answers())
                .gradeMethod(exam.getGrade_method())
                .createdAt(exam.getCreated_at())
                .updatedAt(exam.getUpdated_at())
                .build();
    }
    public Exam examEntityToExam(ExamEntity examEntity) {
        return Exam.builder()
                .id(new ExamId(examEntity.getId()))
                .name(examEntity.getName())
                .intro(examEntity.getIntro())
                .scores(examEntity.getScore())
                .maxScores(examEntity.getMaxScore())
                .time_open(examEntity.getTimeOpen())
                .time_close(examEntity.getTimeClose())
                .time_limit(examEntity.getTimeLimit())
                .overdue_handing(examEntity.getOverdueHandling())
                .can_redo_questions(examEntity.getCanRedoQuestions())
                .max_attempts(examEntity.getMaxAttempts())
                .shuffle_answers(examEntity.getShuffleQuestions())
                .grade_method(examEntity.getGradeMethod())
                .created_at(examEntity.getCreatedAt())
                .updated_at(examEntity.getUpdatedAt())
                .build();
    }
}
