package com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.repository;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.entity.CodeQuestionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CodeQuestionJpaRepository extends JpaRepository<CodeQuestionEntity, UUID> {
    Optional<CodeQuestionEntity> findByQuestionId(UUID questionId);

    @Query("""
            select cqe from CodeQuestionEntity cqe LEFT JOIN CodeQuestionTagEntity cqte
            on cqe.id = cqte.codeQuestion.id
            where (?1 IS NULL) OR (cqte.tag.id in ?1)
            group by cqe.id
            """)
    Page<CodeQuestionEntity> findAndFilterByTagIds(List<UUID> tagIs, Pageable pageable);

}
