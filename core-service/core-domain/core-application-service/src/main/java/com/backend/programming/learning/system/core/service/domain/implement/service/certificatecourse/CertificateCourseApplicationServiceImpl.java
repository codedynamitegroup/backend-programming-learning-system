package com.backend.programming.learning.system.core.service.domain.implement.service.certificatecourse;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.certificatecourse.CreateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.certificatecourse.CreateCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.certificatecourse.QueryAllCertificateCourseWithPageCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.certificatecourse.QueryAllCertificateCourseWithPageResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.certificatecourse.DeleteCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.certificatecourse.DeleteCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.certificatecourse.*;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.certificatecourse.UpdateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.certificatecourse.UpdateCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.certificatecourse.CertificateCourseResponseEntity;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.certificatecourse.CertificateCourseApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.Valid;

@Service
@Validated
@Slf4j
class CertificateCourseApplicationServiceImpl implements CertificateCourseApplicationService {
    private final CertificateCourseCommandHandler certificateCourseCommandHandler;

    public CertificateCourseApplicationServiceImpl(CertificateCourseCommandHandler certificateCourseCommandHandler) {
        this.certificateCourseCommandHandler = certificateCourseCommandHandler;
    }

    @Override
    public CreateCertificateCourseResponse createCertificateCourse(
            @Valid CreateCertificateCourseCommand createCertificateCourseCommand) {
        return certificateCourseCommandHandler.createCertificateCourse(createCertificateCourseCommand);
    }

    @Override
    public UpdateCertificateCourseResponse updateCertificateCourse(UpdateCertificateCourseCommand updateCertificateCourseCommand) {
        return certificateCourseCommandHandler.updateCertificateCourse(updateCertificateCourseCommand);
    }

    @Override
    public CertificateCourseResponseEntity queryCertificateCourse(
            @Valid QueryCertificateCourseCommand queryCertificateCourseCommand) {
        return certificateCourseCommandHandler.findCertificateCourseById(queryCertificateCourseCommand);
    }

    @Override
    public QueryAllCertificateCoursesResponse queryAllMyCertificateCourses(
            QueryAllCertificateCoursesCommand queryAllCertificateCoursesCommand) {
        return certificateCourseCommandHandler.findAllMyCertificateCourses(queryAllCertificateCoursesCommand);
    }

    @Override
    public QueryAllCertificateCoursesResponse queryAllCertificateCourses(
            QueryAllCertificateCoursesCommand queryAllCertificateCoursesCommand) {
        return certificateCourseCommandHandler.findAllCertificateCourses(queryAllCertificateCoursesCommand);
    }

    @Override
    public QueryAllMyCompletedCertificateCoursesResponse queryAllMyCompletedCertificateCourses(
            QueryAllMyCompletedCertificateCoursesCommand queryAllMyCompletedCertificateCoursesCommand) {
        return certificateCourseCommandHandler.findAllMyCompletedCertificateCourses(queryAllMyCompletedCertificateCoursesCommand);
    }

    @Override
    public QueryAllMostEnrolledCertificateCoursesResponse queryAllMostEnrolledCertificateCourses(
            QueryAllMostEnrolledCertificateCoursesCommand queryAllMostEnrolledCertificateCoursesCommand) {
        return certificateCourseCommandHandler.findAllMostEnrolledCertificateCourses(queryAllMostEnrolledCertificateCoursesCommand);
    }

    @Override
    public DeleteCertificateCourseResponse deleteCertificateCourse(DeleteCertificateCourseCommand deleteCertificateCourseCommand) {
        return certificateCourseCommandHandler.deleteCertificateCourse(deleteCertificateCourseCommand);
    }

    @Override
    public QueryGeneralCertificateCourseStatisticsResponse queryGeneralCertificateCourseStatistics() {
        return certificateCourseCommandHandler.queryGeneralCertificateCourseStatistics();
    }

    @Override
    public QueryAllCertificateCourseWithPageResponse queryAllCertificateCoursesAdmin(
            QueryAllCertificateCourseWithPageCommand queryAllCertificateCourseWithPageCommand) {
        return certificateCourseCommandHandler.queryAllCertificateCoursesAdmin(queryAllCertificateCourseWithPageCommand);
    }
}
