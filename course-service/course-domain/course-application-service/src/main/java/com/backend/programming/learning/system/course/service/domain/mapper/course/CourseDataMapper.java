package com.backend.programming.learning.system.course.service.domain.mapper.course;

import com.backend.programming.learning.system.course.service.domain.dto.course.create.CreateCourseCommand;
import com.backend.programming.learning.system.course.service.domain.dto.course.create.CreateCourseResponse;
import com.backend.programming.learning.system.course.service.domain.dto.course.get.CourseResponse;
import com.backend.programming.learning.system.course.service.domain.entity.course.Course;
import com.backend.programming.learning.system.course.service.domain.event.course.CourseCreateEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * com.backend.programming.learning.system.course.service.domain.mapper.course
 * Create by Dang Ngoc Tien
 * Date 4/11/2024 - 12:11 AM
 * Description: ...
 */
@Component
public class CourseDataMapper
{
    public Course createCourseCommandToCourse(CreateCourseCommand createCourseCommand) {
        return Course.builder()
                .name(createCourseCommand.getName())
                .visible(createCourseCommand.getVisible())
                .createdBy(createCourseCommand.getCreatedBy())
                .updatedBy(createCourseCommand.getCreatedBy())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    public CreateCourseResponse courseCreateEventToCourseResponse(CourseCreateEvent courseCreateEvent, String message) {
      return CreateCourseResponse.builder()
                    .course(courseCreateEvent.getCourse())
                    .message(message)
                    .build();
    }

    public CourseResponse coursesToCourseResponse(List<Course> courses, String message) {
        return CourseResponse.builder()
                .courses(courses)
                .message(message)
                .build();
    }

    public CreateCourseResponse courseToCreateCourseResponse(Course course, String message) {
        return CreateCourseResponse.builder()
                .course(course)
                .message(message)
                .build();
    }
}

