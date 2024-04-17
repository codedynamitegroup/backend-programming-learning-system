package com.backend.programming.learning.system;

import com.backend.programming.learning.system.entity.Course;
import com.backend.programming.learning.system.entity.Exam;
import com.backend.programming.learning.system.entity.Question;

import java.util.UUID;

public interface CourseDomainService {
    void createExam(Exam exam);

    void createCourse(Course course);

    Question createQuestion(Question question);
}
