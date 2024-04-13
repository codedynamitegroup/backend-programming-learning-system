package com.backend.programming.learning.system.ports.input.service;

import com.backend.programming.learning.system.dto.create.CreateCourseCommand;
import com.backend.programming.learning.system.dto.create.CreateCourseResponse;

import javax.validation.Valid;

public interface CourseApplicationService {
    // Question
    CreateCourseResponse createQuestion(@Valid CreateCourseCommand createCourseCommand);

    // CertificateCourse
    CreateCourseResponse createCertificateCourse(@Valid CreateCourseCommand createCourseCommand);
}
