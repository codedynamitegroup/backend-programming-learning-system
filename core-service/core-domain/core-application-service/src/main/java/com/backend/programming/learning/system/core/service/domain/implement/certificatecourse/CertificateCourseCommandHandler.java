package com.backend.programming.learning.system.core.service.domain.implement.certificatecourse;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.certificatecourse.CreateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.certificatecourse.CreateCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.certificatecourse.DeleteCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.certificatecourse.DeleteCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.certificatecourse.QueryAllCertificateCoursesCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.certificatecourse.QueryAllCertificateCoursesResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.certificatecourse.QueryCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.certificatecourse.CertificateCourseResponseEntity;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.mapper.certificatecourse.CertificateCourseDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
public class CertificateCourseCommandHandler {
    private final CertificateCourseCreateHelper certificateCourseCreateHelper;
    private final CertificateCourseQueryHelper certificateCourseQueryHelper;
    private final CertificateCourseDeleteHelper certificateCourseDeleteHelper;
    private final CertificateCourseDataMapper certificateCourseDataMapper;

    public CertificateCourseCommandHandler(CertificateCourseCreateHelper certificateCourseCreateHelper,
                                           CertificateCourseQueryHelper certificateCourseQueryHelper,
                                             CertificateCourseDeleteHelper certificateCourseDeleteHelper,
                                           CertificateCourseDataMapper certificateCourseDataMapper) {
        this.certificateCourseCreateHelper = certificateCourseCreateHelper;
        this.certificateCourseQueryHelper = certificateCourseQueryHelper;
        this.certificateCourseDeleteHelper = certificateCourseDeleteHelper;
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
    public CertificateCourseResponseEntity findCertificateCourseById(
            QueryCertificateCourseCommand queryCertificateCourseCommand) {
        CertificateCourse certificateCourse = certificateCourseQueryHelper
                .queryCertificateCourseById(queryCertificateCourseCommand.getCertificateCourseId());

        log.info("Certificate course found with id: {}", certificateCourse.getId().getValue());

        return certificateCourseDataMapper.certificateCourseToQueryCertificateCourseResponse(certificateCourse);
    }

    @Transactional(readOnly = true)
    public QueryAllCertificateCoursesResponse findAllCertificateCourses(
            QueryAllCertificateCoursesCommand queryAllCertificateCoursesCommand) {
        Page<CertificateCourse> certificateCourses = certificateCourseQueryHelper
                .queryAllCertificateCourses(queryAllCertificateCoursesCommand.getPageNo(), queryAllCertificateCoursesCommand.getPageSize());

        return certificateCourseDataMapper
                .certificateCoursesToQueryAllCertificateCoursesResponse(certificateCourses);
    }

    @Transactional
    public DeleteCertificateCourseResponse deleteCertificateCourse(
            DeleteCertificateCourseCommand deleteCertificateCourseCommand) {
        certificateCourseDeleteHelper.deleteCertificateCourseById(
                deleteCertificateCourseCommand.getCertificateCourseId());

        return DeleteCertificateCourseResponse.builder()
                .certificateCourseId(deleteCertificateCourseCommand.getCertificateCourseId())
                .message("Certificate course deleted successfully")
                .build();
    }
}
