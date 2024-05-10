package com.backend.programming.learning.system.code.assessment.service.dataaccess.comment.adapter;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.comment.entity.CommentEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.comment.entity.vote.CommentVoteEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.comment.mapper.CommentDataAccessMapper;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.comment.mapper.CommentVoteDataAccessMapper;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.comment.repository.CommentJpaRepository;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.comment.repository.CommentVoteJpaRepository;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.general_mapper.GeneralMapper;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.Comment;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.CommentRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.CommentId;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.SharedSolutionId;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.Vote;
import com.backend.programming.learning.system.domain.valueobject.QueryOrderBy;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class CommentRepositoryImpl implements CommentRepository {
    final CommentJpaRepository commentJpaRepository;
    final CommentDataAccessMapper commentDataAccessMapper;
    final CommentVoteJpaRepository commentVoteJpaRepository;
    final CommentVoteDataAccessMapper commentVoteDataAccessMapper;
    final GeneralMapper generalMapper;

    public CommentRepositoryImpl(CommentJpaRepository commentJpaRepository, CommentDataAccessMapper commentDataAccessMapper, CommentVoteJpaRepository commentVoteJpaRepository, CommentVoteDataAccessMapper commentVoteDataAccessMapper, GeneralMapper generalMapper) {
        this.commentJpaRepository = commentJpaRepository;
        this.commentDataAccessMapper = commentDataAccessMapper;
        this.commentVoteJpaRepository = commentVoteJpaRepository;
        this.commentVoteDataAccessMapper = commentVoteDataAccessMapper;
        this.generalMapper = generalMapper;
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

    @Override
    public void deleteById(CommentId commentId) {
        commentJpaRepository.deleteById(commentId.getValue());
    }

    @Override
    public Page<Comment> findBySharedSolutionId(SharedSolutionId sharedSolutionId, UserId userId, Integer pageNum, Integer pageSize, QueryOrderBy orderBy) {
        Pageable pageable
                = PageRequest
                .of(pageNum,
                        pageSize,
                        Sort.by(generalMapper.QueryOrderByToSortDirection(orderBy), CommentEntity.Fields.createdAt));

        Page<CommentEntity> commentEntities = commentJpaRepository.findRootCommentBySharedSolutionId(sharedSolutionId.getValue(), pageable);

        Page<Comment> comments = commentEntities
                .map(commentEntity->{
                    Optional<CommentVoteEntity> commentVoteEntityOpt
                            = commentVoteJpaRepository.findById(
                                    commentVoteDataAccessMapper
                                            .commentIdAndUserIdToEntityId(
                                                    commentEntity.getId(),
                                                    userId.getValue()));
                    Vote vote = commentVoteEntityOpt.map(CommentVoteEntity::getVoteType).orElse(null);
                    return commentDataAccessMapper.entityToComment(commentEntity, vote);
                });


        return comments;
    }

    @Override
    public List<Comment> findReplyByRootCommentId(CommentId commentId, UserId userId) {
        List<CommentEntity> commentEntities = commentJpaRepository.findByReplyCommentIdOrderByCreatedAtDesc(commentId.getValue());

        List<Comment> result = commentEntities.stream()
                .map(commentEntity -> {
                    Optional<CommentVoteEntity> commentVoteEntityOpt
                            = commentVoteJpaRepository.findById(
                            commentVoteDataAccessMapper
                                    .commentIdAndUserIdToEntityId(
                                            commentEntity.getId(),
                                            userId.getValue()));
                    Vote vote = commentVoteEntityOpt.map(CommentVoteEntity::getVoteType).orElse(null);
                    return commentDataAccessMapper.entityToComment(commentEntity, vote);
                })
                .toList();
        return result;
    }

}
