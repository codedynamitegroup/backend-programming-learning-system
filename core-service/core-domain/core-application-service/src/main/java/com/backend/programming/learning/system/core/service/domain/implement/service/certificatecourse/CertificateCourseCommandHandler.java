package com.backend.programming.learning.system.core.service.domain.implement.service.certificatecourse;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.certificatecourse.CreateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.certificatecourse.CreateCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.certificatecourse.DeleteCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.certificatecourse.DeleteCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.certificatecourse.*;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.certificatecourse.UpdateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.certificatecourse.UpdateCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.certificatecourse.CertificateCourseResponseEntity;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.mapper.certificatecourse.CertificateCourseDataMapper;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.core.service.domain.valueobject.IsRegisteredFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Slf4j
public class CertificateCourseCommandHandler {
    private final CertificateCourseCreateHelper certificateCourseCreateHelper;
    private final CertificateCourseQueryHelper certificateCourseQueryHelper;
    private final CertificateCourseDeleteHelper certificateCourseDeleteHelper;
    private final CertificateCourseUpdateHelper certificateCourseUpdateHelper;
    private final CertificateCourseDataMapper certificateCourseDataMapper;

    public CertificateCourseCommandHandler(CertificateCourseCreateHelper certificateCourseCreateHelper,
                                           CertificateCourseQueryHelper certificateCourseQueryHelper,
                                           CertificateCourseDeleteHelper certificateCourseDeleteHelper,
                                           CertificateCourseUpdateHelper certificateCourseUpdateHelper,
                                           CertificateCourseDataMapper certificateCourseDataMapper) {
        this.certificateCourseCreateHelper = certificateCourseCreateHelper;
        this.certificateCourseQueryHelper = certificateCourseQueryHelper;
        this.certificateCourseDeleteHelper = certificateCourseDeleteHelper;
        this.certificateCourseUpdateHelper = certificateCourseUpdateHelper;
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

    @Transactional
    public UpdateCertificateCourseResponse updateCertificateCourse(
            UpdateCertificateCourseCommand updateCertificateCourseCommand) {
        certificateCourseUpdateHelper
                .persistCertificateCourse(updateCertificateCourseCommand);

        log.info("Certificate course updated with id: {}", updateCertificateCourseCommand.getCertificateCourseId());

        return certificateCourseDataMapper.certificateCourseToUpdateCertificateCourseResponse(
                new CertificateCourseId(updateCertificateCourseCommand.getCertificateCourseId()),
                "Certificate course updated successfully");
    }

    @Transactional(readOnly = true)
    public CertificateCourseResponseEntity findCertificateCourseById(
            QueryCertificateCourseCommand queryCertificateCourseCommand) {
        CertificateCourse certificateCourse = certificateCourseQueryHelper
                .queryCertificateCourseById(
                        queryCertificateCourseCommand.getCertificateCourseId(),
                        queryCertificateCourseCommand.getEmail());

        log.info("Certificate course found with id: {}", certificateCourse.getId().getValue());

        return certificateCourseDataMapper.certificateCourseToQueryCertificateCourseResponse(certificateCourse);
    }

    @Transactional(readOnly = true)
    public QueryAllCertificateCoursesResponse findAllCertificateCourses(
            QueryAllCertificateCoursesCommand queryAllCertificateCoursesCommand) {
        List<CertificateCourse> certificateCourses = certificateCourseQueryHelper
                .queryAllCertificateCourses(
                        queryAllCertificateCoursesCommand.getCourseName(),
                        queryAllCertificateCoursesCommand.getFilterTopicIds(),
                        IsRegisteredFilter.valueOf(queryAllCertificateCoursesCommand.getIsRegisteredFilter()),
                        queryAllCertificateCoursesCommand.getEmail()
                );
//        List<CertificateCourse> mostEnrolledCertificateCourses = certificateCourseQueryHelper
//                .queryMostEnrolledCertificateCourses(
//                        queryAllCertificateCoursesCommand.getCourseName(),
//                        queryAllCertificateCoursesCommand.getFilterTopicIds(),
//                        IsRegisteredFilter.valueOf(queryAllCertificateCoursesCommand.getIsRegisteredFilter()),
//                        queryAllCertificateCoursesCommand.getEmail()
//                );

        return certificateCourseDataMapper
                .certificateCoursesToQueryAllCertificateCoursesResponse(certificateCourses);
    }

    @Transactional(readOnly = true)
    public QueryAllMostEnrolledCertificateCoursesResponse findAllMostEnrolledCertificateCourses(
            QueryAllMostEnrolledCertificateCoursesCommand queryAllMostEnrolledCertificateCoursesCommand) {
        List<CertificateCourse> mostEnrolledCertificateCourses = certificateCourseQueryHelper
                .queryMostEnrolledCertificateCourses(
                        queryAllMostEnrolledCertificateCoursesCommand.getEmail()
                );

        return certificateCourseDataMapper
                .certificateCoursesToQueryAllMostEnrolledCertificateCoursesResponse(mostEnrolledCertificateCourses);
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
