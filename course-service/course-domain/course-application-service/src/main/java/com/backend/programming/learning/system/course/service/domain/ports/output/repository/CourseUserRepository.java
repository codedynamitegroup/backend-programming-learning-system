package com.backend.programming.learning.system.course.service.domain.ports.output.repository;

import com.backend.programming.learning.system.course.service.domain.entity.CourseUser;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface CourseUserRepository {
    CourseUser saveCourseUser(CourseUser courseUser);

    void saveAll(List<CourseUser> courseUsers);

    List<CourseUser> findByCourseId(UUID courseUserId);

    void deleteByCourseIdAndUserIdIn(UUID courseId, List<UUID> userIds);
    void deleteByCourseIdAndUserId(UUID courseId, UUID userIds);

    List<CourseUser> findByCourseIdAndRoleTeacher(UUID courseId);
    
    Page<CourseUser> findAllUserByCourseId(UUID id, String search, int pageNo, int pageSize);

    Integer countStudentByCourseId(UUID courseId);


    Page<CourseUser> findAllCourseByUserId(UUID userId, int pageNo, int pageSize, String search, String[] courseType);
}
