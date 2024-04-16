package com.backend.programming.learning.system.implemtent.course;

import com.backend.programming.learning.system.dto.create.CreateCourseCommand;
import com.backend.programming.learning.system.dto.create.CreateCourseResponse;
import com.backend.programming.learning.system.dto.query.QueryCourseResponse;
import com.backend.programming.learning.system.entity.Course;
import com.backend.programming.learning.system.mapper.CourseDataMapper;
import com.backend.programming.learning.system.ports.input.service.CourseApplicationService;
import com.backend.programming.learning.system.ports.output.repository.CourseRepository;
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
