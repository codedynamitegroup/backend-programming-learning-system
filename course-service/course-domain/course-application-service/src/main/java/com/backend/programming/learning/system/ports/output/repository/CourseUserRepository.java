package com.backend.programming.learning.system.ports.output.repository;

import com.backend.programming.learning.system.entity.CourseUser;

import java.util.List;
import java.util.UUID;

public interface CourseUserRepository {
    CourseUser saveCourseUser(CourseUser courseUser);

    void saveAll(List<CourseUser> courseUsers);

    void deleteByCourseIdAndUserIdIn(UUID courseId, List<UUID> userIds);
}
