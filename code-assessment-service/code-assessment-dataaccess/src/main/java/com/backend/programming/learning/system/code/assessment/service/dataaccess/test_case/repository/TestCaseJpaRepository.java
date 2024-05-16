package com.backend.programming.learning.system.code.assessment.service.dataaccess.test_case.repository;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.test_case.entity.TestCaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TestCaseJpaRepository extends JpaRepository<TestCaseEntity, UUID> {
    Page<TestCaseEntity> findByCodeQuestionId(UUID codeQuestionId, Pageable pageable);
    List<TestCaseEntity> findByCodeQuestionId(UUID codeQuestionId);
    List<TestCaseEntity> findByCodeQuestionIdAndIsSample(UUID codeQuestionId, Boolean isSample);
}
