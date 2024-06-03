package com.backend.programming.learning.system.core.service.dataaccess.code_submission_certificatecourse.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.code_submission_certificatecourse.mapper.CodeSubmissionCertificateCourseDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.code_submission_certificatecourse.repository.CodeSubmissionCertificateCourseJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.code_submission_contest.repository.CodeSubmissionContestJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.CodeSubmissionCertificateCourse;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CodeSubmissionCertificateCourseRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CodeSubmissionContestRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CodeSubmissionCertificateCourseRepositoryImpl implements CodeSubmissionCertificateCourseRepository {
    private final CodeSubmissionCertificateCourseJpaRepository codeSubmissionCertificateCourseJpaRepository;
    private final CodeSubmissionCertificateCourseDataAccessMapper codeSubmissionCertificateCourseDataAccessMapper;

    public CodeSubmissionCertificateCourseRepositoryImpl(CodeSubmissionCertificateCourseJpaRepository codeSubmissionCertificateCourseJpaRepository,
                                                          CodeSubmissionCertificateCourseDataAccessMapper codeSubmissionCertificateCourseDataAccessMapper) {
        this.codeSubmissionCertificateCourseJpaRepository = codeSubmissionCertificateCourseJpaRepository;
        this.codeSubmissionCertificateCourseDataAccessMapper = codeSubmissionCertificateCourseDataAccessMapper;
    }

    @Override
    public CodeSubmissionCertificateCourse saveCodeSubmissionCertificateCourse(
            CodeSubmissionCertificateCourse codeSubmissionCertificateCourse) {
        return codeSubmissionCertificateCourseDataAccessMapper
                .codeSubmissionCertificateCourseEntityToCodeSubmissionCertificateCourse(
                codeSubmissionCertificateCourseJpaRepository
                        .save(codeSubmissionCertificateCourseDataAccessMapper
                                .codeSubmissionCertificateCourseToCodeSubmissionCertificateCourseEntity(
                                        codeSubmissionCertificateCourse)));
    }
}
