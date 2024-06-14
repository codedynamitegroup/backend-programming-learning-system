package com.backend.programming.learning.system.course.service.dataaccess.answer_of_question.repository;

import com.backend.programming.learning.system.course.service.dataaccess.answer_of_question.entity.AnswerOfQuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public interface AnswerOfQuestionJpaRepository extends JpaRepository<AnswerOfQuestionEntity, UUID> {
    List<AnswerOfQuestionEntity> findAllByQuestionId(UUID questionId);

    @Modifying
    @Query(value = "DELETE FROM AnswerOfQuestionEntity a WHERE a.id IN :ids")
    void deleteAllByIdInQuery(@Param("ids") List<UUID> ids);

    @Modifying
    @Query(value = "DELETE FROM AnswerOfQuestionEntity a WHERE a.questionId = :questionId")
    void deleteAllByQuestionId(UUID questionId);
}
