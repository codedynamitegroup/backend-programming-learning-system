package com.backend.programming.learning.system.course.service.dataaccess.question.repository;

import com.backend.programming.learning.system.course.service.dataaccess.question.entity.QuestionEntity;
import net.bytebuddy.jar.asm.commons.Remapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface QuestionJpaRepository extends JpaRepository<QuestionEntity, UUID> {
    Optional<QuestionEntity> findById(UUID id);

    @Query("""
            SELECT q
            FROM QuestionEntity q
            WHERE q.questionBankCategoryId = :questionBankCategoryId
            """)
    Page<QuestionEntity> findAll(UUID questionBankCategoryId, Pageable pageable);
}
