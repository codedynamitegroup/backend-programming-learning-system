package com.backend.programming.learning.system.core.service.domain.implement.certificatecourse_user;

import com.backend.programming.learning.system.core.service.domain.dto.create.certificatecourse.CreateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.certificatecourse.CreateCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.create.certificatecourse_user.CreateCertificateCourseUserCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.certificatecourse_user.CreateCertificateCourseUserResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.certificatecourse.QueryCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.query.certificatecourse.QueryCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.implement.certificatecourse.CertificateCourseCommandHandler;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.certificatecourse.CertificateCourseApplicationService;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.certificatecourse_user.CertificateCourseUserApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Service
@Validated
@Slf4j
class CertificateCourseUserApplicationServiceImpl implements CertificateCourseUserApplicationService {
    private final CertificateCourseUserCommandHandler certificateCourseUserCommandHandler;

    public CertificateCourseUserApplicationServiceImpl(CertificateCourseUserCommandHandler certificateCourseUserCommandHandler) {
        this.certificateCourseUserCommandHandler = certificateCourseUserCommandHandler;
    }

    @Override
    public CreateCertificateCourseUserResponse createCertificateCourseUser(CreateCertificateCourseUserCommand createCertificateCourseUserCommand) {
        return certificateCourseUserCommandHandler.createCertificateCourseUser(createCertificateCourseUserCommand);
    }
}
