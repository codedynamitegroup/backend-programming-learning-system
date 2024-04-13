package com.backend.programming.learning.system.core.service.domain.implement;

import com.backend.programming.learning.system.core.service.domain.dto.create.CreateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.CreateCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.QueryCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.query.QueryCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.CertificateCourseApplicationService;
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
    public QueryCertificateCourseResponse findCertificateCourseById(QueryCertificateCourseCommand queryCertificateCourseCommand) {
        return certificateCourseCommandHandler.findCertificateCourseById(queryCertificateCourseCommand);
    }
}
