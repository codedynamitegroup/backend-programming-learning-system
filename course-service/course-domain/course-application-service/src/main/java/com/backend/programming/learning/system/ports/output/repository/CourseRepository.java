package com.backend.programming.learning.system.ports.output.repository;

import com.backend.programming.learning.system.entity.Course;

public interface CourseRepository {
    Course saveCourse(Course course);
}
