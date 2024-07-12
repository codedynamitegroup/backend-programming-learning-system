package com.backend.programming.learning.system.code.assessment.service.dataaccess.code_submission.repository;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_submission.entity.contest.CodeSubmissionContestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CodeSubmissionContestJpaRepository extends JpaRepository<CodeSubmissionContestEntity, UUID> {
}
