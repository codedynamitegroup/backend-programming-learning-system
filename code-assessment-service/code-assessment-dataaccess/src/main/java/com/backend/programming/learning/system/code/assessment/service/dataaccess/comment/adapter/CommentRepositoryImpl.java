package com.backend.programming.learning.system.code.assessment.service.dataaccess.comment.adapter;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.comment.entity.CommentEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.comment.mapper.CommentDataAccessMapper;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.comment.repository.CommentJpaRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.Comment;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.CommentRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.CommentId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class CommentRepositoryImpl implements CommentRepository {
    final CommentJpaRepository commentJpaRepository;
    final CommentDataAccessMapper commentDataAccessMapper;

    public CommentRepositoryImpl(CommentJpaRepository commentJpaRepository, CommentDataAccessMapper commentDataAccessMapper) {
        this.commentJpaRepository = commentJpaRepository;
        this.commentDataAccessMapper = commentDataAccessMapper;
    }

    @Override
    public Optional<Comment> findById(CommentId commentId) {
        Optional<CommentEntity> comment = commentJpaRepository.findById(commentId.getValue());
        return comment.map(commentDataAccessMapper::entityToCommentIgnoreLazy);
    }

    @Override
    public Comment save(Comment comment) {
        CommentEntity commentEntity = commentJpaRepository.save(commentDataAccessMapper.commentToEntity(comment));
        return commentDataAccessMapper.entityToCommentIgnoreLazy(commentEntity);
    }
}
