package com.backend.programming.learning.system.core.service.domain.implement.certificatecourse_user;

import com.backend.programming.learning.system.core.service.domain.dto.create.certificatecourse.CreateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.certificatecourse.CreateCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.create.certificatecourse_user.CreateCertificateCourseUserCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.certificatecourse_user.CreateCertificateCourseUserResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.certificatecourse.QueryCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.query.certificatecourse.QueryCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourseUser;
import com.backend.programming.learning.system.core.service.domain.exception.CertificateCourseNotFoundException;
import com.backend.programming.learning.system.core.service.domain.implement.certificatecourse.CertificateCourseCreateHelper;
import com.backend.programming.learning.system.core.service.domain.mapper.certificatecourse.CertificateCourseDataMapper;
import com.backend.programming.learning.system.core.service.domain.mapper.certificatecourse_user.CertificateCourseUserDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CertificateCourseRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CertificateCourseUserRepository;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@Slf4j
public class CertificateCourseUserCommandHandler {
    private final CertificateCourseUserCreateHelper certificateCourseUserCreateHelper;
    private final CertificateCourseUserDataMapper certificateCourseUserDataMapper;
    private final CertificateCourseUserRepository certificateCourseUserRepository;

    public CertificateCourseUserCommandHandler(CertificateCourseUserCreateHelper certificateCourseUserCreateHelper,
                                               CertificateCourseUserDataMapper certificateCourseUserDataMapper,
                                               CertificateCourseUserRepository certificateCourseUserRepository) {
        this.certificateCourseUserCreateHelper = certificateCourseUserCreateHelper;
        this.certificateCourseUserDataMapper = certificateCourseUserDataMapper;
        this.certificateCourseUserRepository = certificateCourseUserRepository;
    }

    @Transactional
    public CreateCertificateCourseUserResponse createCertificateCourseUser(
            CreateCertificateCourseUserCommand createCertificateCourseUserCommand) {
        CertificateCourseUser certificateCourseUser = certificateCourseUserCreateHelper
                .persistCertificateCourseUser(createCertificateCourseUserCommand);

        log.info("Certificate course user created with id: {}", certificateCourseUser.getId().getValue());

        return certificateCourseUserDataMapper.certificateCourseUserToCreateCertificateCourseUserResponse(
                certificateCourseUser,
                "Certificate course user created successfully");
    }
}
