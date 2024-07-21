package com.backend.programming.learning.system.course.service.dataaccess.question.repository;

import com.backend.programming.learning.system.course.service.dataaccess.question.entity.QuestionEntity;
import com.backend.programming.learning.system.course.service.dataaccess.question.entity.QuestionExamDataAccessDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface QuestionJpaRepository extends JpaRepository<QuestionEntity, UUID> {
    Optional<QuestionEntity> findById(UUID id);

    @Query("""
            SELECT q
            FROM QuestionEntity q
            WHERE (q.questionBankCategoryId = :questionBankCategoryId OR :questionBankCategoryId IS NULL)
            AND (q.questionText LIKE %:search% OR q.name LIKE %:search%)
            """)
    Page<QuestionEntity> findAll(UUID questionBankCategoryId, String search, Pageable pageable);

    @Query("""
            SELECT q
            FROM QuestionEntity q
            WHERE (q.questionText LIKE %:search% OR q.name LIKE %:search%)
            """)
    Page<QuestionEntity> findAll(String search, Pageable pageable);

    @Query("""
            SELECT q
            FROM QuestionEntity q
            JOIN ExamQuestionEntity eq ON q.id = eq.question.id
            WHERE eq.exam.id = :examId
            AND (q.questionText LIKE %:search% OR q.name LIKE %:search%)
            """)
    Page<QuestionEntity> findAllByExamId(UUID examId, String search, Pageable pageable);

    @Query("""
    SELECT new com.backend.programming.learning.system.course.service.dataaccess.question.entity.QuestionExamDataAccessDTO
    (q.id AS id, 
    q.difficulty AS difficulty, 
    q.name AS name, 
    q.questionText AS questionText, 
    q.qtype AS qtype, 
    eq.page AS page, 
    q.defaultMark AS defaultMark)
    FROM QuestionEntity q 
    JOIN ExamQuestionEntity eq ON eq.question.id = q.id
    WHERE LOWER(q.name) LIKE %:search%
        AND eq.exam.id = :examId 
        AND (:pageCurrent IS NULL OR eq.page = :pageCurrent)
    ORDER BY eq.page ASC
    """)
    List<QuestionExamDataAccessDTO> findAllByExamId(UUID examId, String search, Integer pageCurrent);
}
