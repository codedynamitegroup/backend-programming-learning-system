package com.backend.programming.learning.system.core.service.dataaccess.contest_question.repository;

import com.backend.programming.learning.system.core.service.dataaccess.contest_question.entity.ContestQuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ContestQuestionJpaRepository extends JpaRepository<ContestQuestionEntity, UUID> {
    Optional<ContestQuestionEntity> findById(UUID id);
    List<ContestQuestionEntity> findAllContestQuestionsByContestId(UUID contestId);

    @Modifying
    @Query("delete from ContestQuestionEntity cq where cq.contest.id = :contestId")
    void deleteAllContestQuestionsByContestId(UUID contestId);
}
