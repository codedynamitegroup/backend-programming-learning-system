package com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository;

import com.backend.programming.learning.system.code.assessment.service.domain.entity.Comment;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.CommentId;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.SharedSolutionId;
import com.backend.programming.learning.system.domain.valueobject.QueryOrderBy;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface CommentRepository {
    Optional<Comment> findById(CommentId commentId);

    Comment save(Comment comment);

    void deleteById(CommentId commentId);

    Page<Comment> findBySharedSolutionId(SharedSolutionId sharedSolutionId, UserId userId, Integer pageNum, Integer pageSize, QueryOrderBy orderBy);

    List<Comment> findReplyByRootCommentId(CommentId commentId, UserId userId);
}
