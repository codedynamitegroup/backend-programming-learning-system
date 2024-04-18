package com.backend.programming.learning.system.implement.course;

import com.backend.programming.learning.system.dto.method.create.course.CreateCourseCommand;
import com.backend.programming.learning.system.dto.method.create.course.CreateCourseResponse;
import com.backend.programming.learning.system.dto.method.query.course.QueryAllCourseCommand;
import com.backend.programming.learning.system.dto.method.query.course.QueryAllCourseResponse;
import com.backend.programming.learning.system.dto.method.query.course.QueryCourseCommand;
import com.backend.programming.learning.system.dto.responseentity.course.CourseResponseEntity;
import com.backend.programming.learning.system.ports.input.service.course.CourseApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

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
    public QueryAllCourseResponse findAll(QueryAllCourseCommand queryAllCourseCommand) {
        return courseCommandHandler.findAll(queryAllCourseCommand);
    }

    @Override
    public CourseResponseEntity findBy(QueryCourseCommand queryCourseCommand) {
        return courseCommandHandler.findBy(queryCourseCommand);
    }
}
