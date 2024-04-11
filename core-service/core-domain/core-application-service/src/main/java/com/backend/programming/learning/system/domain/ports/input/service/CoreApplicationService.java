package com.backend.programming.learning.system.domain.ports.input.service;

import com.backend.programming.learning.system.domain.dto.create.CreateCertificateCourseCommand;
import com.backend.programming.learning.system.domain.dto.create.CreateCertificateCourseResponse;
import jakarta.validation.Valid;

public interface CoreApplicationService {
    // CertificateCourse
    CreateCertificateCourseResponse createCertificateCourse(@Valid CreateCertificateCourseCommand createCertificateCourseCommand);
}