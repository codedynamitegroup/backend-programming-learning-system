package com.backend.programming.learning.system.core.service.domain.implement.certificatecourse;

import com.backend.programming.learning.system.core.service.domain.dto.create.certificatecourse.CreateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.certificatecourse.CreateCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.delete.certificatecourse.DeleteCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.delete.certificatecourse.DeleteCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.certificatecourse.QueryAllCertificateCoursesCommand;
import com.backend.programming.learning.system.core.service.domain.dto.query.certificatecourse.QueryAllCertificateCoursesResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.certificatecourse.QueryCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.query.certificatecourse.QueryCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.certificatecourse.CertificateCourseApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.UUID;

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
    public QueryCertificateCourseResponse queryCertificateCourse(
            @Valid QueryCertificateCourseCommand queryCertificateCourseCommand) {
        return certificateCourseCommandHandler.findCertificateCourseById(queryCertificateCourseCommand);
    }

    @Override
    public QueryAllCertificateCoursesResponse queryAllCertificateCourses(
            QueryAllCertificateCoursesCommand queryAllCertificateCoursesCommand) {
        return certificateCourseCommandHandler.findAllCertificateCourses(queryAllCertificateCoursesCommand);
    }

    @Override
    public DeleteCertificateCourseResponse deleteCertificateCourse(DeleteCertificateCourseCommand deleteCertificateCourseCommand) {
        return certificateCourseCommandHandler.deleteCertificateCourse(deleteCertificateCourseCommand);
    }
}
