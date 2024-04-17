package com.backend.programming.learning.system;

import com.backend.programming.learning.system.entity.Course;
import com.backend.programming.learning.system.entity.Exam;
import com.backend.programming.learning.system.entity.Question;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CourseDomainServiceImpl implements CourseDomainService{
    @Override
    public void createExam(Exam exam) {
        exam.initializeExam();
        log.info("Exam with id: {} is initiated", exam.getId().getValue());
    }

    @Override
    public void createCourse(Course course) {
        course.initializeCourse();
        log.info("Course with id: {} is initiated", course.getId().getValue());
    }

    @Override
    public Question createQuestion(Question question) {
        question.initializeQuestion();
        log.info("Question with id: {} is initiated", question.getId().getValue());
        return question;
    }
}
