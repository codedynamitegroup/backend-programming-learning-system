package com.backend.programming.learning.system.core.service.domain.ports.input.service.certificatecourse;

import com.backend.programming.learning.system.core.service.domain.dto.create.certificatecourse.CreateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.certificatecourse.CreateCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.delete.certificatecourse.DeleteCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.delete.certificatecourse.DeleteCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.certificatecourse.QueryAllCertificateCoursesCommand;
import com.backend.programming.learning.system.core.service.domain.dto.query.certificatecourse.QueryAllCertificateCoursesResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.certificatecourse.QueryCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.query.certificatecourse.QueryCertificateCourseResponse;

import javax.validation.Valid;

public interface CertificateCourseApplicationService {
    CreateCertificateCourseResponse createCertificateCourse(
            @Valid CreateCertificateCourseCommand createCertificateCourseCommand);
    QueryCertificateCourseResponse queryCertificateCourse(
            @Valid QueryCertificateCourseCommand queryCertificateCourseCommand);

    QueryAllCertificateCoursesResponse queryAllCertificateCourses(
            @Valid QueryAllCertificateCoursesCommand queryAllCertificateCoursesCommand);

    DeleteCertificateCourseResponse deleteCertificateCourse(
            @Valid DeleteCertificateCourseCommand deleteCertificateCourseCommand);

}
