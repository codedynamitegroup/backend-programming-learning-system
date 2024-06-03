package com.backend.programming.learning.system.core.service.dataaccess.code_submission_certificatecourse.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.code_submission_certificatecourse.entity.CodeSubmissionCertificateCourseEntity;
import com.backend.programming.learning.system.core.service.domain.entity.CodeSubmissionCertificateCourse;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.domain.valueobject.CodeSubmissionId;
import org.springframework.stereotype.Component;

@Component
public class CodeSubmissionCertificateCourseDataAccessMapper {
    public CodeSubmissionCertificateCourseEntity codeSubmissionCertificateCourseToCodeSubmissionCertificateCourseEntity(
            CodeSubmissionCertificateCourse codeSubmissionCertificateCourse) {
        return CodeSubmissionCertificateCourseEntity.builder()
                .codeSubmissionId(codeSubmissionCertificateCourse.getId().getValue())
                .certificateCourseId(codeSubmissionCertificateCourse.getCertificateCourseId().getValue())
                .build();
    }

    public CodeSubmissionCertificateCourse codeSubmissionCertificateCourseEntityToCodeSubmissionCertificateCourse(
            CodeSubmissionCertificateCourseEntity codeSubmissionCertificateCourseEntity) {
        return CodeSubmissionCertificateCourse.builder()
                .id(new CodeSubmissionId(codeSubmissionCertificateCourseEntity.getCodeSubmissionId()))
                .certificateCourseId(new CertificateCourseId(codeSubmissionCertificateCourseEntity.getCertificateCourseId()))
                .build();
    }
}
