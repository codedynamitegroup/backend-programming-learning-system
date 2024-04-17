package com.backend.programming.learning.system.mapper.course;


import com.backend.programming.learning.system.dto.method.create.course.CreateCourseCommand;
import com.backend.programming.learning.system.dto.method.create.course.CreateCourseResponse;
import com.backend.programming.learning.system.dto.method.query.course.QueryCourseResponse;
import com.backend.programming.learning.system.entity.Course;
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

    public List<QueryCourseResponse> coursesToQueryCourseResponse(List<Course> courses) {
        return courses.stream()
                .map(course -> QueryCourseResponse.builder()
                        .id(course.getId().getValue())
                        .name(course.getName())
//                        .key(course.getKey())
                        .visible(course.getVisible())
//                        .examId(course.getExamId())
                        .createdBy(course.getCreatedBy())
                        .updatedBy(course.getUpdatedBy())
                        .createdAt(course.getCreatedAt())
                        .updatedAt(course.getUpdatedAt())
                        .message("Get courses successfully")
                        .build())
                .toList();
    }

    public QueryCourseResponse courseToQueryCourseResponse(Course course, String message) {
        return QueryCourseResponse.builder()
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
}
