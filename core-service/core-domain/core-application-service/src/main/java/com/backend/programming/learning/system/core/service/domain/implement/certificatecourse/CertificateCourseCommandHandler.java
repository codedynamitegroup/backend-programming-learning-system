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
    private final CertificateCourseDataMapper certificateCourseDataMapper;
    private final CertificateCourseRepository certificateCourseRepository;

    public CertificateCourseCommandHandler(CertificateCourseCreateHelper certificateCourseCreateHelper,
                                           CertificateCourseDataMapper certificateCourseDataMapper,
                                           CertificateCourseRepository certificateCourseRepository) {
        this.certificateCourseCreateHelper = certificateCourseCreateHelper;
        this.certificateCourseDataMapper = certificateCourseDataMapper;
        this.certificateCourseRepository = certificateCourseRepository;
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
        Optional<CertificateCourse> certificateCourseResult =
                certificateCourseRepository.findById(new CertificateCourseId(
                        queryCertificateCourseCommand.getCertificateCourseId()));
        if (certificateCourseResult.isEmpty()) {
            log.warn("Could not find certificate course with id: {}",
                    queryCertificateCourseCommand.getCertificateCourseId());
            throw new CertificateCourseNotFoundException("Could not find certificate course with id: " +
                    queryCertificateCourseCommand.getCertificateCourseId());
        }
        return certificateCourseDataMapper.certificateCourseToQueryCertificateCourseResponse(
                certificateCourseResult.get());
    }
}
