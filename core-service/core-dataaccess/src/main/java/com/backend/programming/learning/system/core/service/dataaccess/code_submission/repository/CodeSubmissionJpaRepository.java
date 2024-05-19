package com.backend.programming.learning.system.core.service.dataaccess.code_submission.repository;

import com.backend.programming.learning.system.core.service.dataaccess.code_submission.entity.CodeSubmissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CodeSubmissionJpaRepository extends JpaRepository<CodeSubmissionEntity, UUID> {
    Optional<CodeSubmissionEntity> findById(UUID id);

    @Query("""
            SELECT cse
            FROM CodeSubmissionEntity cse, QuestionEntity qe, QtypeCodeQuestionEntity qcqe
            WHERE cse.codeQuestionId = qcqe.id
            AND qcqe.question.id = qe.id
            AND cse.userId = :userId
            AND qe.id = :questionId
""")
    List<CodeSubmissionEntity> findAllCodeSubmissionsByUserIdAndQuestionId(UUID userId, UUID questionId);
}
