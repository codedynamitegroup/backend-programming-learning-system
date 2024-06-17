package com.backend.programming.learning.system.core.service.dataaccess.question.repository;

import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QtypeCodeQuestionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface QtypeCodeQuestionJpaRepository extends JpaRepository<QtypeCodeQuestionEntity, UUID>{
    @Query("SELECT q.id FROM QtypeCodeQuestionEntity q WHERE q.question.id = :questionId")
    UUID getId(UUID questionId);
    Optional<QtypeCodeQuestionEntity> findByQuestionId(UUID questionId);

    @Query(value="""
        select cqe.*
        from qtype_code_question cqe
        join question qe
        on cqe.question_id = qe.id
        where qe.org_id IS NULL
                AND (cast(?1 as text) IS NULL or UPPER(qe.name) like UPPER(concat('%', cast(?1 as text), '%')))
                AND (cast(?2 as text) is NULL OR cast(?2 as text) = cast(qe.difficulty as text))
                AND (?3 is null or cqe.is_public = ?3)
                AND (?4 = qe.created_by or cqe.is_public = true)
         order by qe.created_at asc
""", nativeQuery = true)
    Page<QtypeCodeQuestionEntity> findAllAdminQtypeCodeQuestions(String search,
                                                                 String difficulty,
                                                                 Boolean isPublic,
                                                                 UUID userId,
                                                                 Pageable pageable);
}
