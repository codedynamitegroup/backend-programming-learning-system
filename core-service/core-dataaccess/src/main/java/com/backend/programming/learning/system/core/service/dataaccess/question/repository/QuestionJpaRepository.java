package com.backend.programming.learning.system.core.service.dataaccess.question.repository;

import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QuestionEntity;
import com.backend.programming.learning.system.core.service.domain.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface QuestionJpaRepository extends JpaRepository<QuestionEntity, UUID> {
    Optional<QuestionEntity> findById(UUID id);

    @Query("SELECT q.qtype FROM QuestionEntity q WHERE q.id = :id")
    String getQtype(UUID id);

    @Query("""
        SELECT q
        FROM QuestionEntity q
        WHERE q.questionBankCategoryId = :categoryId
        AND (q.name LIKE %:search%)
        ORDER BY q.updatedAt
    """)
    Page<QuestionEntity> findAllByQuestionBankCategoryId(UUID categoryId,
                                                         String search,
                                                         Pageable pageable);

    @Query("""
        SELECT q
        FROM QuestionEntity q
        WHERE q.questionBankCategoryId = :categoryId
        and ((:isBasicType = false and q.qtype = 'CODE') or (:isBasicType = true and q.qtype != 'CODE'))
        AND (q.name LIKE %:search%)
        ORDER BY q.updatedAt
    """)
    Page<QuestionEntity> findAllByQuestionBankCategoryIdAndIsBasicType(UUID categoryId,
                                                         String search,
                                                         boolean isBasicType,
                                                         Pageable pageable);

    @Query(value = """
        select qs.*
        from question qs
        where cast(?2 as text) IS NULL or UPPER(qs.name) like UPPER(concat('%', cast(?2 as text), '%'))
        and (?1 = '' or qs.qtype = ?1)
        order by qs.name
        """, nativeQuery = true)
    Page<QuestionEntity> findAllQuestionWithPagination(String qtype, String searchName, Pageable paging);
}
