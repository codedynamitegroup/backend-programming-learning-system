package com.backend.programming.learning.system.course.service.domain.ports.output.repository;

import com.backend.programming.learning.system.course.service.domain.entity.Course;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CourseRepository {
    Course save(Course course);

    Page<Course> findAll(String search,String[] courseType, Integer page, Integer size);

    Course findBy(UUID courseId);

    Optional<Course> findByName(String courseName);

    Page<Course> findAllByOrganizationId(UUID organizationId, String search, String[] courseType, Integer page, Integer size);
    Optional<Course> findByCourseIdMoodleAndOrganizationId(Integer courseIdMoodle,UUID organizationId);

    Course findById(UUID courseId);

    void deleteById(UUID courseId);

    void deleteByMoodleIdAndOrganizationId(Integer courseMoodleId,UUID organizationId);

    Optional<Course> findCourseById(UUID courseId);
}
