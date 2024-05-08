package com.backend.programming.learning.system.course.service.domain.mapper.moodle_course;

import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle_course.CourseModel;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle_course.quiz.QuizModel;
import com.backend.programming.learning.system.course.service.domain.entity.Course;
import com.backend.programming.learning.system.course.service.domain.entity.Exam;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.valueobject.CourseId;
import com.backend.programming.learning.system.course.service.domain.valueobject.ExamId;
import com.backend.programming.learning.system.course.service.domain.valueobject.OverdueHandling;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.course.service.domain.mapper.moodle_course
 * Create by Dang Ngoc Tien
 * Date 5/7/2024 - 12:07 AM
 * Description: ...
 */
@Component
public class MoodleCourseMapper {
    public Course updateCourse(CourseModel courseModel, Course course) {
        return Course.builder()
                .id(course.getId())
                .name(courseModel.getFullname())
//                .courseType("MOODLE")
                .visible(courseModel.getVisible())
                .createdBy(course.getCreatedBy())
                .posts(course.getPosts())
                .exams(course.getExams())
                .assignments(course.getAssignments())
                .updatedBy(course.getUpdatedBy())
                .createdAt(course.getCreatedAt())
                .updatedAt(course.getUpdatedAt())
                .build();
    }

    public Course createCourse(CourseModel courseModel, User user) {
        return Course.builder()
                .id(new CourseId(UUID.randomUUID()))
                .name(courseModel.getFullname())
//                .courseType("MOODLE")
                .visible(courseModel.getVisible())
                .createdBy(user)
                .updatedBy(user)
                .build();
    }

    public Exam updateExam(QuizModel quizModel, Exam exam, Course course) {
        return Exam.builder()
                .id(exam.getId())
                .course(course)
                .name(quizModel.getName())
                .score(quizModel.getGrade().floatValue())
                .maxScore(quizModel.getGrade().floatValue())
                .timeOpen(ZonedDateTime.ofInstant(
                        Instant.ofEpochSecond(quizModel.getTimeopen()),
                        ZoneId.of("UTC")))
                .timeClose(ZonedDateTime.ofInstant(
                        Instant.ofEpochSecond(quizModel.getTimeclose()),
                        ZoneId.of("UTC")))
                .timeLimit(quizModel.getTimelimit().intValue())
                .intro(quizModel.getIntro())
                .overdueHandling(OverdueHandling.AUTOSUBMIT)
                .canRedoQuestions(quizModel.getCanredoquestions().equals("0") ? false : true)
                .maxAttempts(quizModel.getAttemptonlast())
                .shuffleAnswers(false)
                .gradeMethod("QUIZ_GRADEHIGHEST")
                .createdAt(exam.getCreatedAt())
                .updatedAt(exam.getUpdatedAt())
                .build();
    }


    public Exam createExam(QuizModel quizModel, Course course) {
        return Exam.builder()
                .id(new ExamId(UUID.randomUUID()))
                .course(course)
                .name(quizModel.getName())
                .score(quizModel.getGrade().floatValue())
                .maxScore(quizModel.getGrade().floatValue())
                .timeOpen(ZonedDateTime.ofInstant(
                        Instant.ofEpochSecond(quizModel.getTimeopen()),
                        ZoneId.of("UTC")))
                .timeClose(ZonedDateTime.ofInstant(
                        Instant.ofEpochSecond(quizModel.getTimeclose()),
                        ZoneId.of("UTC")))
                .timeLimit(quizModel.getTimelimit().intValue())
                .intro(quizModel.getIntro())
                .overdueHandling(OverdueHandling.AUTOSUBMIT)
                .canRedoQuestions(quizModel.getCanredoquestions().equals("0") ? false : true)
                .maxAttempts(quizModel.getAttemptonlast())
                .shuffleAnswers(false)
                .gradeMethod("QUIZ_GRADEHIGHEST")
                .build();
    }
}
