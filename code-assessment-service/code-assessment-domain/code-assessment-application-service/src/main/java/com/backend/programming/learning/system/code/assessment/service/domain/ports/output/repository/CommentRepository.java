package com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository;

import com.backend.programming.learning.system.code.assessment.service.domain.entity.Comment;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.CommentId;

import java.util.Optional;

public interface CommentRepository {
    Optional<Comment> findById(CommentId commentId);

    Comment save(Comment comment);
}
