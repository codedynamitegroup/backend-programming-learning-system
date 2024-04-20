package com.backend.programming.learning.system;

import com.backend.programming.learning.system.entity.*;

public interface CourseDomainService {
    void createExam(Exam exam);

    void createCourse(Course course);

    void createQuestion(Question question);

    void createAssignment(Assignment assignment);

    void createPost(Post post);

    void createSubmissionAssignment(SubmissionAssignment submissionAssignment);
}
