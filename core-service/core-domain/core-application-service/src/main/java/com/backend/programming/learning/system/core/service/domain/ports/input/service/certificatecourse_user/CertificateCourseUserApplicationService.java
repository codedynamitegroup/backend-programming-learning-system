package com.backend.programming.learning.system.core.service.domain.ports.input.service.certificatecourse_user;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.certificatecourse_user.CreateCertificateCourseUserCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.certificatecourse_user.CreateCertificateCourseUserResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.certificatecourse.QueryAllCertificateCourseUsersCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.certificatecourse.QueryAllCertificateCourseUsersResponse;

import jakarta.validation.Valid;

public interface CertificateCourseUserApplicationService {
    CreateCertificateCourseUserResponse createCertificateCourseUser(
            @Valid CreateCertificateCourseUserCommand createCertificateCourseUserCommand);

    QueryAllCertificateCourseUsersResponse queryAllCertificateCourseUsers(
            @Valid QueryAllCertificateCourseUsersCommand queryAllCertificateCourseUsersCommand);

}
