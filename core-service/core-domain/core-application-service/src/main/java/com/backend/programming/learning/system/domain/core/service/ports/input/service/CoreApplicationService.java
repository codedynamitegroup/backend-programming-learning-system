package com.backend.programming.learning.system.domain.core.service.ports.input.service;

import com.backend.programming.learning.system.domain.core.service.dto.create.CreateCertificateCourseResponse;
import com.backend.programming.learning.system.domain.core.service.dto.create.CreateCertificateCourseCommand;
import jakarta.validation.Valid;

public interface CoreApplicationService {
    // CertificateCourse
    CreateCertificateCourseResponse createCertificateCourse(@Valid CreateCertificateCourseCommand createCertificateCourseCommand);
}