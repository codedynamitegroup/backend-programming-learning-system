package com.backend.programming.learning.system.ports.output.repository;

import com.backend.programming.learning.system.entity.CourseUser;

public interface CourseUserRepository {
    CourseUser saveCourseUser(CourseUser courseUser);
}
