package com.backend.programming.learning.system;

import com.backend.programming.learning.system.entity.Assignment;
import com.backend.programming.learning.system.entity.Course;
import com.backend.programming.learning.system.entity.CourseUser;
import com.backend.programming.learning.system.entity.Exam;
import com.backend.programming.learning.system.entity.Post;
import com.backend.programming.learning.system.entity.Question;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

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
    public void createQuestion(Question question) {
        question.initializeQuestion();
        log.info("Question with id: {} is initiated", question.getId().getValue());
    }

    @Override
    public void createAssignment(Assignment assignment) {
        assignment.initializeAssignment();
        log.info("Assignment with id: {} is initiated", assignment.getId().getValue());

    }

    @Override
    public void createPost(Post post) {
        post.initializePost();
        log.info("Post with id: {} is initiated", post.getId().getValue());
    }

    @Override
    public void createCourseUsers(List<CourseUser> courseUsers) {
        courseUsers.forEach(CourseUser::initializeCourseUser);
        log.info("CourseUser is initiated");
    }
}
