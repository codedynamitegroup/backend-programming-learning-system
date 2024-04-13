package com.backend.programming.learning.system.core.service.domain;

import com.backend.programming.learning.system.core.service.domain.dto.create.CreateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.CreateCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.create.CreateQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.CreateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.CertificateCourseApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Service
@Validated
@Slf4j
class CertificateCourseApplicationServiceImpl implements CertificateCourseApplicationService {
    private final CertificateCourseCreateCommandHandler certificateCourseCreateCommandHandler;

    public CertificateCourseApplicationServiceImpl(CertificateCourseCreateCommandHandler certificateCourseCreateCommandHandler) {
        this.certificateCourseCreateCommandHandler = certificateCourseCreateCommandHandler;
    }

    @Override
    public CreateCertificateCourseResponse createCertificateCourse(@Valid CreateCertificateCourseCommand createCertificateCourseCommand) {
        return certificateCourseCreateCommandHandler.createCertificateCourse(createCertificateCourseCommand);
    }
}
