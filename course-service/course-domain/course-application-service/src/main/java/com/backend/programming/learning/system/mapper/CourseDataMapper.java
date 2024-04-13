package com.backend.programming.learning.system.mapper;


import com.backend.programming.learning.system.domain.valueobject.UserId;
import com.backend.programming.learning.system.dto.create.CreateCourseCommand;
import com.backend.programming.learning.system.dto.create.CreateCourseResponse;
import com.backend.programming.learning.system.entity.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseDataMapper {
    public Course createCourseCommandToCourse(
            CreateCourseCommand createCourseCommand) {
        return Course.builder()
                .name(createCourseCommand.getName())
                .key(createCourseCommand.getKey())
                .visible(createCourseCommand.getVisible())
                .createdBy(new UserId(createCourseCommand.getCreatedBy()))
                .updatedBy(new UserId(createCourseCommand.getUpdatedBy()))
                .build();
    }

    public CreateCourseResponse CourseToCreateCourseResponse(
            Course course, String message) {
        return CreateCourseResponse.builder()
                .course(course)
                .message(message)
                .build();
    }
}
