package com.backend.programming.learning.system.course.service.domain.mapper.course;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.course.CreateCourseCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.course.CreateCourseResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.course.QueryAllCourseResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.course.UpdateCourseResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.course.CourseResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.Course;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class CourseDataMapper {
    public Course createCourseCommandToCourse(
            User user,
            CreateCourseCommand createCourseCommand) {
        return Course.builder()
                .name(createCourseCommand.name())
                .courseType(createCourseCommand.courseType())
                .key(createCourseCommand.key())
                .visible(createCourseCommand.visible())
                .createdBy(user)
                .updatedBy(user)
                .build();
    }

    public CreateCourseResponse courseToCreateCourseResponse(Course course, String message) {
        return CreateCourseResponse.builder()
                .id(course.getId().getValue())
                .name(course.getName())
                .courseType(course.getCourseType())
                .visible(course.getVisible())
                .createdBy(course.getCreatedBy().getId())
                .createdAt(course.getCreatedAt())
                .message(message)
                .build();
    }

    public CourseResponseEntity courseToQueryCourseResponse(Course course) {
        return CourseResponseEntity.builder()
                .id(course.getId().getValue())
                .name(course.getName())
                .courseType(course.getCourseType())
                .visible(course.getVisible())
                .createdBy(course.getCreatedBy().getId())
                .updatedBy(course.getUpdatedBy().getId())
                .createdAt(course.getCreatedAt())
                .updatedAt(course.getUpdatedAt())
                .build();
    }

    public QueryAllCourseResponse coursesToQueryAllCourseResponse(Page<Course> courses) {
        return QueryAllCourseResponse.builder()
                .courses(courses.stream()
                        .map(this::courseToQueryCourseResponse)
                        .toList())
                .currentPage(courses.getNumber())
                .totalPages(courses.getTotalPages())
                .totalItems(courses.getTotalElements())
                .build();
    }

    public UpdateCourseResponse courseToUpdateCourseResponse(Course course, String message) {
        return UpdateCourseResponse.builder()
                .courseId(course.getId().getValue())
                .name(course.getName())
                .courseType(course.getCourseType())
                .visible(course.getVisible())
                .message(message)
                .build();
    }
}
