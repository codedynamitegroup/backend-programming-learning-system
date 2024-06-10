package com.backend.programming.learning.system.core.service.domain.ports.input.service.certificatecourse;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.certificatecourse.CreateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.certificatecourse.CreateCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.certificatecourse.DeleteCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.certificatecourse.DeleteCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.certificatecourse.*;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.certificatecourse.UpdateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.certificatecourse.UpdateCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.certificatecourse.CertificateCourseResponseEntity;

import jakarta.validation.Valid;

public interface CertificateCourseApplicationService {
    CreateCertificateCourseResponse createCertificateCourse(
            @Valid CreateCertificateCourseCommand createCertificateCourseCommand);

    UpdateCertificateCourseResponse updateCertificateCourse(
            @Valid UpdateCertificateCourseCommand updateCertificateCourseCommand);

    CertificateCourseResponseEntity queryCertificateCourse(
            @Valid QueryCertificateCourseCommand queryCertificateCourseCommand);

    QueryAllCertificateCoursesResponse queryAllMyCertificateCourses(
            @Valid QueryAllCertificateCoursesCommand queryAllCertificateCoursesCommand);

    QueryAllCertificateCoursesResponse queryAllCertificateCourses(
            @Valid QueryAllCertificateCoursesCommand queryAllCertificateCoursesCommand);

    QueryAllMostEnrolledCertificateCoursesResponse queryAllMostEnrolledCertificateCourses(
            @Valid QueryAllMostEnrolledCertificateCoursesCommand queryAllMostEnrolledCertificateCoursesCommand);

    DeleteCertificateCourseResponse deleteCertificateCourse(
            @Valid DeleteCertificateCourseCommand deleteCertificateCourseCommand);

}
