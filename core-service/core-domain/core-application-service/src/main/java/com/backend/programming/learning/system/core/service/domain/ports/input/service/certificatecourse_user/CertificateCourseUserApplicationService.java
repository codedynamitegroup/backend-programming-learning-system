package com.backend.programming.learning.system.core.service.domain.ports.input.service.certificatecourse_user;

import com.backend.programming.learning.system.core.service.domain.dto.create.certificatecourse_user.CreateCertificateCourseUserCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.certificatecourse_user.CreateCertificateCourseUserResponse;

import javax.validation.Valid;

public interface CertificateCourseUserApplicationService {
    CreateCertificateCourseUserResponse createCertificateCourseUser(
            @Valid CreateCertificateCourseUserCommand createCertificateCourseUserCommand);

}
