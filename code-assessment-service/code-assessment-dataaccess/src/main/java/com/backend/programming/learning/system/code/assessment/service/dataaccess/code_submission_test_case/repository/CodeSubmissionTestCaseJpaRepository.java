package com.backend.programming.learning.system.code.assessment.service.dataaccess.code_submission_test_case.repository;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_submission_test_case.entity.CodeSubmissionTestCaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CodeSubmissionTestCaseJpaRepository extends JpaRepository<CodeSubmissionTestCaseEntity, UUID> {
    Optional<CodeSubmissionTestCaseEntity> findFirstByJudgeToken(String judgeToken);
    List<CodeSubmissionTestCaseEntity> findByCodeSubmissionId(UUID codeSubmission_id);
}
