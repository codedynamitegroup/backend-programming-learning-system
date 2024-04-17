package com.backend.programming.learning.system.implement.course;

import com.backend.programming.learning.system.dto.method.create.course.CreateCourseCommand;
import com.backend.programming.learning.system.dto.method.create.course.CreateCourseResponse;
import com.backend.programming.learning.system.dto.method.query.course.QueryCourseResponse;
import com.backend.programming.learning.system.ports.input.service.course.CourseApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.implemtent.course
 * Create by Dang Ngoc Tien
 * Date 4/17/2024 - 2:13 AM
 * Description: ...
 */
@Slf4j
@Validated
@Service
@RequiredArgsConstructor
public class CourseApplicationServiceImpl implements CourseApplicationService {
    private final CourseCommandHandler courseCommandHandler;

    @Override
    public CreateCourseResponse createQuestion(CreateCourseCommand createCourseCommand) {
        return null;
    }

    @Override
    public CreateCourseResponse createCertificateCourse(CreateCourseCommand createCourseCommand) {
        return null;
    }

    @Override
    public CreateCourseResponse createCourse(CreateCourseCommand createCourseCommand) {
        return courseCommandHandler.createCourse(createCourseCommand);
    }

    @Override
    public List<QueryCourseResponse> findAll(String search) {
        return courseCommandHandler.findAll(search);
    }

    @Override
    public QueryCourseResponse findBy(UUID courseId) {
        return courseCommandHandler.findBy(courseId);
    }
}
