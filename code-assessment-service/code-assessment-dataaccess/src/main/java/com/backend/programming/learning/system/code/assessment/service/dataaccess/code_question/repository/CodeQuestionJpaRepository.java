package com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.repository;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.entity.CodeQuestionEntity;
import com.backend.programming.learning.system.domain.valueobject.QuestionDifficulty;
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
            where 
                (?1 IS NULL OR cqte.tag.id in ?1)
                AND cqe.isPublic = ?6
                AND ((cast(?2 as text) IS NULL) or (upper(cqe.name) like upper(concat('%', cast(?2 as text), '%'))))
                AND ((cast(?3 as text) is NULL) OR (?3 = cqe.difficulty))
                AND ((?4 is null) or (?5 is null) or ((?4 = true) AND EXISTS (
                                    select cse from CodeSubmissionEntity cse
                                    where cse.codeQuestion.id = cqe.id
                                    and cse.grade = cqe.maxGrade
                                    and ?5 = cse.user.id
                                ))
                or ((?4 = false) and not exists (
                                    select cse from CodeSubmissionEntity cse
                                    where cse.codeQuestion.id = cqe.id
                                    and cse.grade = cqe.maxGrade
                                    and ?5 = cse.user.id
                                ))
                )
            group by cqe.id
            """)
    Page<CodeQuestionEntity> findAndFilterByTagIds(List<UUID> tagIs, String search, QuestionDifficulty difficulty, Boolean solved, UUID value, boolean isPublic, Pageable pageable);

}
