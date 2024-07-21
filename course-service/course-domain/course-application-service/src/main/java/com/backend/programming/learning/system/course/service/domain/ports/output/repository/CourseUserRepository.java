package com.backend.programming.learning.system.course.service.domain.ports.output.repository;

import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam.QueryGradeCommand;
import com.backend.programming.learning.system.course.service.domain.entity.CourseUser;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.valueobject.ExamId;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CourseUserRepository {
    CourseUser saveCourseUser(CourseUser courseUser);

    Optional<CourseUser> findByCourseIdAndUserId(UUID courseId, UUID userId);
    List<CourseUser> findAll();

    void saveAll(List<CourseUser> courseUsers);

    List<CourseUser> findByCourseId(UUID courseUserId);

    void deleteByCourseIdAndUserIdIn(UUID courseId, List<UUID> userIds);
    void deleteByCourseIdAndUserId(UUID courseId, UUID userIds);

    List<CourseUser> findByCourseIdAndRoleTeacher(UUID courseId);
    
    Page<CourseUser> findAllUserByCourseId(UUID id, String search, int pageNo, int pageSize);

    Integer countStudentByCourseId(UUID courseId);


    Page<CourseUser> findAllCourseByUserId(UUID userId, int pageNo, int pageSize, String search, String[] courseType);


    Page<CourseUser> findByExamId(ExamId examId, QueryGradeCommand queryGradeCommand);
    Page<User> findAllUsersAreAbleToAssign(UUID courseId, UUID organizationId, String search, int pageNo, int pageSize);
}
