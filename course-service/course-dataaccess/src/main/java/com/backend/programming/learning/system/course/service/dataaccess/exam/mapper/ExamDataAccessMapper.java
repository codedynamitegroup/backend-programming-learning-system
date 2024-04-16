package com.backend.programming.learning.system.course.service.dataaccess.exam.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.course.entity.CourseEntity;
import com.backend.programming.learning.system.course.service.dataaccess.course.repository.CourseJpaRepository;
import com.backend.programming.learning.system.course.service.dataaccess.exam.entity.ExamEntity;
import com.backend.programming.learning.system.entity.Exam;
import com.backend.programming.learning.system.valueobject.CourseId;
import com.backend.programming.learning.system.valueobject.ExamId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExamDataAccessMapper{
    private final CourseJpaRepository courseJpaRepository;
    public ExamEntity examToExamEntity(Exam exam) {
        CourseEntity courseEntity = courseJpaRepository.findById(exam.getCourseId().getValue())
                .orElseThrow(() -> new RuntimeException("Course not found"));
        return ExamEntity.builder()
                .id(exam.getId().getValue())
                .course(courseEntity)
                .name(exam.getName())
                .intro(exam.getIntro())
                .score(exam.getScores())
                .maxScore(exam.getMaxScores())
                .timeOpen(exam.getTime_open())
                .timeClose(exam.getTime_close())
                .timeLimit(exam.getTime_limit())
                .overdueHandling(exam.getOverdue_handing())
                .canRedoQuestions(true)//exam.getCan_redo_questions())
                .maxAttempts(exam.getMax_attempts())
//                .shuffleQuestions(exam.getShuffle_answers())
                .gradeMethod(exam.getGrade_method())
                .createdAt(exam.getCreated_at())
                .updatedAt(exam.getUpdated_at())
                .build();
    }
    public Exam examEntityToExam(ExamEntity examEntity) {
        return Exam.builder()
                .id(new ExamId(examEntity.getId()))
                .courseId(new CourseId(examEntity.getCourse().getId()))
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
//                .shuffle_answers(examEntity.getShuffleQuestions())
                .grade_method(examEntity.getGradeMethod())
                .created_at(examEntity.getCreatedAt())
                .updated_at(examEntity.getUpdatedAt())
                .build();
    }
}
