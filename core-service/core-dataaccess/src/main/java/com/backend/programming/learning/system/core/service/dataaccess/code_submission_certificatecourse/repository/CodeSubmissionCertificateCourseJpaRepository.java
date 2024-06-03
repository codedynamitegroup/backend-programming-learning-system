package com.backend.programming.learning.system.core.service.dataaccess.code_submission_certificatecourse.repository;

import com.backend.programming.learning.system.core.service.dataaccess.code_submission_certificatecourse.entity.CodeSubmissionCertificateCourseEntity;
import com.backend.programming.learning.system.core.service.dataaccess.code_submission_contest.entity.CodeSubmissionContestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CodeSubmissionCertificateCourseJpaRepository extends JpaRepository<CodeSubmissionCertificateCourseEntity, UUID> {
}
