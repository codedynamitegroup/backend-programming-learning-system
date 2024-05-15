package com.backend.programming.learning.system.code.assessment.service.dataaccess.comment.repository;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.comment.entity.CommentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CommentJpaRepository extends JpaRepository<CommentEntity, UUID> {
    @Query("""
            select ce from CommentEntity ce
            where ce.sharedSolution.id = ?1 and ce.replyLevel = 0
            """)
    Page<CommentEntity> findRootCommentBySharedSolutionId(UUID sharedSolutionId, Pageable pageable);

    List<CommentEntity> findByReplyCommentIdOrderByCreatedAtDesc(UUID replyId);
}
