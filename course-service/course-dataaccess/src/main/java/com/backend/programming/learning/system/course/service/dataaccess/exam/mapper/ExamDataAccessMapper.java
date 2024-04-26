package com.backend.programming.learning.system.course.service.dataaccess.exam.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.course.entity.CourseEntity;
import com.backend.programming.learning.system.course.service.dataaccess.course.mapper.CourseDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.exam.entity.ExamEntity;
import com.backend.programming.learning.system.course.service.domain.entity.Course;
import com.backend.programming.learning.system.course.service.domain.entity.Exam;
import com.backend.programming.learning.system.course.service.domain.valueobject.ExamId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExamDataAccessMapper{
    private final CourseDataAccessMapper courseDataAccessMapper;
    public ExamEntity examToExamEntity(Exam exam) {
        CourseEntity courseEntity = courseDataAccessMapper.courseToCourseEntity(exam.getCourse());
        return ExamEntity.builder()
                .id(exam.getId().getValue())
                .course(courseEntity)
                .name(exam.getName())
                .intro(exam.getIntro())
                .score(exam.getScore())
                .maxScore(exam.getMaxScore())
                .timeOpen(exam.getTimeOpen())
                .timeClose(exam.getTimeClose())
                .timeLimit(exam.getTimeLimit())
                .overdueHandling(exam.getOverdueHanding())
                .canRedoQuestions(exam.getCanRedoQuestions())
                .maxAttempts(exam.getMaxAttempts())
//                .shuffleQuestions(exam.getShuffle_answers())
                .gradeMethod(exam.getGradeMethod())
                .createdAt(exam.getCreatedAt())
                .updatedAt(exam.getUpdatedAt())
                .build();
    }
    public Exam examEntityToExam(ExamEntity examEntity) {
        Course course = courseDataAccessMapper.courseEntityToCourse(examEntity.getCourse());
        Exam response =  Exam.builder()
                .course(course)
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
//                .shuffle_answers(examEntity.getShuffleQuestions())
                .gradeMethod(examEntity.getGradeMethod())
                .createdAt(examEntity.getCreatedAt())
                .updatedAt(examEntity.getUpdatedAt())
                .build();
        response.setId(new ExamId(examEntity.getId()));
        return response;
    }
}
