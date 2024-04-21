package com.backend.programming.learning.system;

import com.backend.programming.learning.system.entity.*;


import java.util.List;
import java.util.UUID;
import com.backend.programming.learning.system.entity.Question;

import java.util.UUID;

public interface CourseDomainService {
    void createExam(Exam exam);

    void createCourse(Course course);

    void createQuestion(Question question);

    void createAssignment(Assignment assignment);

    void createPost(Post post);

    void createSubmissionAssignment(SubmissionAssignment submissionAssignment);

    void createSubmissionAssignmentOnlineText(SubmissionAssignmentOnlineText submissionAssignmentOnlineText);
    void createCourseUsers(List<CourseUser> courseUsers);
}
