package com.backend.programming.learning.system.ports.input.service.course;

import com.backend.programming.learning.system.dto.method.create.course.CreateCourseCommand;
import com.backend.programming.learning.system.dto.method.create.course.CreateCourseResponse;
import com.backend.programming.learning.system.dto.method.query.course.QueryCourseResponse;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

public interface CourseApplicationService {
    // Question
    CreateCourseResponse createQuestion(@Valid CreateCourseCommand createCourseCommand);

    // CertificateCourse
    CreateCourseResponse createCertificateCourse(@Valid CreateCourseCommand createCourseCommand);

    CreateCourseResponse createCourse(
            @Valid CreateCourseCommand createCourseCommand);

    List<QueryCourseResponse> findAll(String search);

    QueryCourseResponse findBy(UUID courseId);
}
