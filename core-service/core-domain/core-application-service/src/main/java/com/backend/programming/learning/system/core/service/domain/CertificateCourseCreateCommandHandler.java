package com.backend.programming.learning.system.core.service.domain;

import com.backend.programming.learning.system.core.service.domain.dto.create.CreateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.CreateCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.QueryCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.query.QueryCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.mapper.CertificateCourseDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
public class CertificateCourseCreateCommandHandler {
    private final CertificateCourseCreateHelper certificateCourseCreateHelper;
    private final CertificateCourseDataMapper certificateCourseDataMapper;

    public CertificateCourseCreateCommandHandler(CertificateCourseCreateHelper certificateCourseCreateHelper,
                                                 CertificateCourseDataMapper certificateCourseDataMapper) {
        this.certificateCourseCreateHelper = certificateCourseCreateHelper;
        this.certificateCourseDataMapper = certificateCourseDataMapper;
    }

    @Transactional
    public CreateCertificateCourseResponse createCertificateCourse(
            CreateCertificateCourseCommand createCertificateCourseCommand) {
        CertificateCourse certificateCourse = certificateCourseCreateHelper
                .persistCertificateCourse(createCertificateCourseCommand);

        log.info("Certificate course created with id: {}", certificateCourse.getId().getValue());

        return certificateCourseDataMapper.certificateCourseToCreateCertificateCourseResponse(certificateCourse,
                "Certificate course created successfully");
    }
}
