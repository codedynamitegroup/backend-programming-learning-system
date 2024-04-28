package com.backend.programming.learning.system.core.service.domain.implement.service.certificatecourse_user;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.certificatecourse_user.CreateCertificateCourseUserCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.certificatecourse_user.CreateCertificateCourseUserResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.certificatecourse.QueryAllCertificateCourseUsersCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.certificatecourse.QueryAllCertificateCourseUsersResponse;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.certificatecourse_user.CertificateCourseUserApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

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

    @Override
    public QueryAllCertificateCourseUsersResponse queryAllCertificateCourseUsers(QueryAllCertificateCourseUsersCommand queryAllCertificateCourseUsersCommand) {
        return certificateCourseUserCommandHandler.findAllCertificateCourseUsers(queryAllCertificateCourseUsersCommand);
    }
}
