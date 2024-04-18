package com.backend.programming.learning.system.mapper.course;

import com.backend.programming.learning.system.dto.method.create.course.CreateCourseCommand;
import com.backend.programming.learning.system.dto.method.create.course.CreateCourseResponse;
import com.backend.programming.learning.system.dto.method.query.course.QueryAllCourseResponse;
import com.backend.programming.learning.system.dto.responseentity.course.CourseResponseEntity;
import com.backend.programming.learning.system.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CourseDataMapper {
    public Course createCourseCommandToCourse(
            CreateCourseCommand createCourseCommand) {
        return Course.builder()
                .name(createCourseCommand.getName())
                .key(createCourseCommand.getKey())
                .visible(createCourseCommand.getVisible())
//                .createdBy(new UserId(createCourseCommand.getCreatedBy()))
//                .updatedBy(new UserId(createCourseCommand.getUpdatedBy()))
                .build();
    }

    public CreateCourseResponse CourseToCreateCourseResponse(
            Course course, String message) {
        return CreateCourseResponse.builder()
//                .course(course)
                .message(message)
                .build();
    }

    public CreateCourseResponse courseToCreateCourseResponse(Course course, String message) {
        return CreateCourseResponse.builder()
                .id(course.getId().getValue())
                .name(course.getName())
//                .key(course.getKey())
                .visible(course.getVisible())
//                .examId(course.getExamId())
                .createdBy(course.getCreatedBy())
                .updatedBy(course.getUpdatedBy())
                .createdAt(course.getCreatedAt())
                .updatedAt(course.getUpdatedAt())
                .message(message)
                .build();
    }


    public CourseResponseEntity courseToQueryCourseResponse(Course course) {
        return CourseResponseEntity.builder()
                .id(course.getId().getValue())
                .name(course.getName())
                .visible(course.getVisible())
                .createdBy(course.getCreatedBy())
                .updatedBy(course.getUpdatedBy())
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
}
