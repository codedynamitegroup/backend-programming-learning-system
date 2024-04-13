package com.backend.programming.learning.system.core.service.domain.ports.input.service.certificatecourse;

import com.backend.programming.learning.system.core.service.domain.dto.create.certificatecourse.CreateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.certificatecourse.CreateCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.certificatecourse.QueryCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.query.certificatecourse.QueryCertificateCourseResponse;

import javax.validation.Valid;

public interface CertificateCourseApplicationService {
    CreateCertificateCourseResponse createCertificateCourse(
            @Valid CreateCertificateCourseCommand createCertificateCourseCommand);
    QueryCertificateCourseResponse findCertificateCourseById(
            @Valid QueryCertificateCourseCommand queryCertificateCourseCommand);

}
