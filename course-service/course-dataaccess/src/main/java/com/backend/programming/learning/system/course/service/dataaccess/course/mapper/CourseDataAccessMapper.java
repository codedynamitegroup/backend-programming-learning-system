package com.backend.programming.learning.system.course.service.dataaccess.course.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.course.entity.CourseEntity;
import com.backend.programming.learning.system.entity.Course;
import com.backend.programming.learning.system.valueobject.CourseId;
import org.springframework.stereotype.Component;

@Component
public class CourseDataAccessMapper {

    public CourseEntity courseToCourseEntity(Course course) {
        return CourseEntity.builder()
                .id(course.getId().getValue())
                .name(course.getName())
                .visible(course.getVisible())
                .createdAt(course.getCreatedAt())
                .updatedAt(course.getUpdatedAt())
                .build();
    }
    public Course courseEntityToCourse(CourseEntity courseEntity) {
        return Course.builder()
                .id(new CourseId(courseEntity.getId()))
                .name(courseEntity.getName())
                .visible(courseEntity.getVisible())
                .createdAt(courseEntity.getCreatedAt())
                .updatedAt(courseEntity.getUpdatedAt())
                .build();
    }
}
