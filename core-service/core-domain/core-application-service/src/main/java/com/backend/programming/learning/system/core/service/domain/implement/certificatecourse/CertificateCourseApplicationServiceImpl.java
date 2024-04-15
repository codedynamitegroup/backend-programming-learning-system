package com.backend.programming.learning.system.core.service.domain.implement.certificatecourse;

import com.backend.programming.learning.system.core.service.domain.dto.create.certificatecourse.CreateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.certificatecourse.CreateCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.certificatecourse.QueryCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.query.certificatecourse.QueryCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.certificatecourse.CertificateCourseApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Service
@Validated
@Slf4j
class CertificateCourseApplicationServiceImpl implements CertificateCourseApplicationService {
    private final CertificateCourseCommandHandler certificateCourseCommandHandler;

    public CertificateCourseApplicationServiceImpl(CertificateCourseCommandHandler certificateCourseCommandHandler) {
        this.certificateCourseCommandHandler = certificateCourseCommandHandler;
    }

    @Override
    public CreateCertificateCourseResponse createCertificateCourse(
            @Valid CreateCertificateCourseCommand createCertificateCourseCommand) {
        return certificateCourseCommandHandler.createCertificateCourse(createCertificateCourseCommand);
    }

    @Override
    public QueryCertificateCourseResponse findCertificateCourseById(
            @Valid QueryCertificateCourseCommand queryCertificateCourseCommand) {
        return certificateCourseCommandHandler.findCertificateCourseById(queryCertificateCourseCommand);
    }
}
