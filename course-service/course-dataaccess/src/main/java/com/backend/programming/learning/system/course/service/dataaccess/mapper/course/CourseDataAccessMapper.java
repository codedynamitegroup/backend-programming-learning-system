package com.backend.programming.learning.system.course.service.dataaccess.mapper.course;

import com.backend.programming.learning.system.course.service.dataaccess.entity.course.CourseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.course.Course;
import org.springframework.stereotype.Component;

/**
 * com.backend.programming.learning.system.course.service.dataaccess.mapper.course
 * Create by Dang Ngoc Tien
 * Date 4/11/2024 - 12:36 AM
 * Description: ...
 */
@Component
public class CourseDataAccessMapper {
    public Course courseEntityToCourse(CourseEntity courseEntity) {
        return Course.builder()
                .courseId(courseEntity.getCourseId())
                .visible(courseEntity.getVisible())
                .name(courseEntity.getName())
                .createdBy(courseEntity.getCreatedBy())
                .updatedBy(courseEntity.getUpdatedBy())
                .createdAt(courseEntity.getCreatedAt())
                .updatedAt(courseEntity.getUpdatedAt())
                .build();
    }
    public CourseEntity courseToCourseEntity(Course course) {
        return CourseEntity.builder()
                .courseId(course.getCourseId())
                .visible(course.getVisible())
                .name(course.getName())
                .createdBy(course.getCreatedBy())
                .updatedBy(course.getUpdatedBy())
                .createdAt(course.getCreatedAt())
                .updatedAt(course.getUpdatedAt())
                .build();
    }
}
