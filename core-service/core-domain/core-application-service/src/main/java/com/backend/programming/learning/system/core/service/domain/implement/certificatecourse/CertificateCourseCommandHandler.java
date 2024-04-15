package com.backend.programming.learning.system.core.service.domain.implement.certificatecourse;

import com.backend.programming.learning.system.core.service.domain.dto.create.certificatecourse.CreateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.certificatecourse.CreateCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.certificatecourse.QueryCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.query.certificatecourse.QueryCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.exception.CertificateCourseNotFoundException;
import com.backend.programming.learning.system.core.service.domain.mapper.certificatecourse.CertificateCourseDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CertificateCourseRepository;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@Slf4j
public class CertificateCourseCommandHandler {
    private final CertificateCourseCreateHelper certificateCourseCreateHelper;
    private final CertificateCourseQueryHelper certificateCourseQueryHelper;
    private final CertificateCourseDataMapper certificateCourseDataMapper;

    public CertificateCourseCommandHandler(CertificateCourseCreateHelper certificateCourseCreateHelper,
                                           CertificateCourseQueryHelper certificateCourseQueryHelper,
                                           CertificateCourseDataMapper certificateCourseDataMapper) {
        this.certificateCourseCreateHelper = certificateCourseCreateHelper;
        this.certificateCourseQueryHelper = certificateCourseQueryHelper;
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

    @Transactional(readOnly = true)
    public QueryCertificateCourseResponse findCertificateCourseById(
            QueryCertificateCourseCommand queryCertificateCourseCommand) {
        CertificateCourse certificateCourse = certificateCourseQueryHelper
                .getCertificateCourse(queryCertificateCourseCommand);

        log.info("Certificate course found with id: {}", certificateCourse.getId().getValue());

        return certificateCourseDataMapper.certificateCourseToQueryCertificateCourseResponse(certificateCourse);
    }
}
