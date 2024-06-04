package com.backend.programming.learning.system.core.service.dataaccess.code_submission_contest.repository;

import com.backend.programming.learning.system.core.service.dataaccess.code_submission_contest.entity.CodeSubmissionContestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CodeSubmissionContestJpaRepository extends JpaRepository<CodeSubmissionContestEntity, UUID> {
}
