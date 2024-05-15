package com.backend.programming.learning.system.code.assessment.service.dataaccess.comment.repository;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.comment.entity.vote.CommentVoteEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.comment.entity.vote.CommentVoteEntityId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentVoteJpaRepository extends JpaRepository<CommentVoteEntity, CommentVoteEntityId> {
}
