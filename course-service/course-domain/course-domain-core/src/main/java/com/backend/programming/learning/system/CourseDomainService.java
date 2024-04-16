package com.backend.programming.learning.system;

import com.backend.programming.learning.system.entity.Course;
import com.backend.programming.learning.system.entity.Exam;

public interface CourseDomainService {
    void createExam(Exam exam);

    void createCourse(Course course);
}
