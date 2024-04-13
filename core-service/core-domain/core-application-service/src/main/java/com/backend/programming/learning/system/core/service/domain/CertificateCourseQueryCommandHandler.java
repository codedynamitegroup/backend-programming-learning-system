package com.backend.programming.learning.system.core.service.domain;

import com.backend.programming.learning.system.core.service.domain.dto.create.CreateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.CreateCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.QueryCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.query.QueryCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.exception.CertificateCourseNotFoundException;
import com.backend.programming.learning.system.core.service.domain.mapper.CertificateCourseDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CertificateCourseRepository;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@Slf4j
public class CertificateCourseQueryCommandHandler {
    private final CertificateCourseDataMapper certificateCourseDataMapper;
    private final CertificateCourseRepository certificateCourseRepository;


    public CertificateCourseQueryCommandHandler(CertificateCourseDataMapper certificateCourseDataMapper,
                                                CertificateCourseRepository certificateCourseRepository) {
        this.certificateCourseDataMapper = certificateCourseDataMapper;
        this.certificateCourseRepository = certificateCourseRepository;
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
