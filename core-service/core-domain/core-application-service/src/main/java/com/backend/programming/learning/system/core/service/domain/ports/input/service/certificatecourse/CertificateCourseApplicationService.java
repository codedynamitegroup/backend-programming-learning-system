package com.backend.programming.learning.system.core.service.domain.ports.input.service.certificatecourse;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.certificatecourse.CreateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.certificatecourse.CreateCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.certificatecourse.DeleteCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.certificatecourse.DeleteCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.certificatecourse.*;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.certificatecourse.CertificateCourseResponseEntity;

import javax.validation.Valid;

public interface CertificateCourseApplicationService {
    CreateCertificateCourseResponse createCertificateCourse(
            @Valid CreateCertificateCourseCommand createCertificateCourseCommand);
    CertificateCourseResponseEntity queryCertificateCourse(
            @Valid QueryCertificateCourseCommand queryCertificateCourseCommand);

    QueryAllCertificateCoursesResponse queryAllCertificateCourses(
            @Valid QueryAllCertificateCoursesCommand queryAllCertificateCoursesCommand);

    DeleteCertificateCourseResponse deleteCertificateCourse(
            @Valid DeleteCertificateCourseCommand deleteCertificateCourseCommand);

}
