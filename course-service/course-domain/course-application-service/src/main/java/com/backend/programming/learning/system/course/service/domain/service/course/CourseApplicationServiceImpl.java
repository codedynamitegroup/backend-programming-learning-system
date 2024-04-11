package com.backend.programming.learning.system.course.service.domain.service.course;

import com.backend.programming.learning.system.course.service.domain.dto.course.create.CreateCourseCommand;
import com.backend.programming.learning.system.course.service.domain.dto.course.create.CreateCourseResponse;
import com.backend.programming.learning.system.course.service.domain.dto.course.get.CourseResponse;
import com.backend.programming.learning.system.course.service.domain.event.course.CourseCreateEvent;
import com.backend.programming.learning.system.course.service.domain.mapper.course.CourseDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.course.CourseApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * com.backend.programming.learning.system.course.service.domain.service.course
 * Create by Dang Ngoc Tien
 * Date 4/11/2024 - 12:00 AM
 * Description: ...
 */
@Slf4j
@Validated
@Service
@RequiredArgsConstructor
public class CourseApplicationServiceImpl implements CourseApplicationService {
    private final CourseCreateCommandHandler courseCreateCommandHandler;
    private final CourseDataMapper courseDataMapper;
    @Override
    public CreateCourseResponse createCourse(CreateCourseCommand createCourseCommand) {
        CourseCreateEvent courseCreateEvent = courseCreateCommandHandler.createCourse(createCourseCommand);
        return courseDataMapper.courseCreateEventToCourseResponse(courseCreateEvent, "Course created successfully");
    }

    @Override
    public CourseResponse findAll(String search) {
        return courseCreateCommandHandler.findAll(search);
    }
}
