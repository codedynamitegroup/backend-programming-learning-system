package com.backend.programming.learning.system.core.service.domain.ports.output.repository;

import com.backend.programming.learning.system.core.service.domain.entity.CodeSubmissionCertificateCourse;
import com.backend.programming.learning.system.core.service.domain.entity.CodeSubmissionContest;

public interface CodeSubmissionCertificateCourseRepository {

    CodeSubmissionCertificateCourse saveCodeSubmissionCertificateCourse(CodeSubmissionCertificateCourse codeSubmissionCertificateCourse);
}
