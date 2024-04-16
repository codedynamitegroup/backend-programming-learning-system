package com.backend.programming.learning.system.ports.input.service;

import com.backend.programming.learning.system.dto.create.CreateCourseCommand;
import com.backend.programming.learning.system.dto.create.CreateCourseResponse;
import com.backend.programming.learning.system.dto.query.QueryCourseResponse;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

public interface CourseApplicationService {
    // Question
    CreateCourseResponse createQuestion(@Valid CreateCourseCommand createCourseCommand);

    // CertificateCourse
    CreateCourseResponse createCertificateCourse(@Valid CreateCourseCommand createCourseCommand);

    CreateCourseResponse createCourse(CreateCourseCommand createCourseCommand);

    List<QueryCourseResponse> findAll(String search);

    QueryCourseResponse findBy(UUID courseId);
}
