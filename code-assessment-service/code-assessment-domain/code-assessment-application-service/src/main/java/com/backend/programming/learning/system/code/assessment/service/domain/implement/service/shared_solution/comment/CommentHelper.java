package com.backend.programming.learning.system.code.assessment.service.domain.implement.service.shared_solution.comment;

import com.backend.programming.learning.system.code.assessment.service.domain.CodeAssessmentDomainService;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.comment.CreateCommentCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.comment.vote.VoteCommentCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.tag.AddTagsToSharedSolutionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.shared_solution.comment.DeleteCommentCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.shared_solution.comment.vote.UnvoteCommentCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.shared_solution.tag.DeleteSharedSolutionTagCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution.comment.GetReplyCommentCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution.comment.GetSolutionCommentCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.update.shared_solution.comment.UpdateCommentCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.Comment;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.CommentVote;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.SharedSolution;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.User;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.CodeAssessmentDomainException;
import com.backend.programming.learning.system.code.assessment.service.domain.implement.service.GenericHelper;
import com.backend.programming.learning.system.code.assessment.service.domain.implement.service.ValidateHelper;
import com.backend.programming.learning.system.code.assessment.service.domain.mapper.shared_solution.comment.CommentDataMapper;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.CommentRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.CommentId;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.SharedSolutionId;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.comment_vote.CommentVoteId;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class CommentHelper {
    final GenericHelper genericHelper;
    final CommentRepository commentRepository;
    final CommentDataMapper commentDataMapper;
    final ValidateHelper validateHelper;
    final CodeAssessmentDomainService codeAssessmentDomainService;

    public CommentHelper(GenericHelper genericHelper, CommentRepository commentRepository, CommentDataMapper commentDataMapper, ValidateHelper validateHelper, CodeAssessmentDomainService codeAssessmentDomainService) {
        this.genericHelper = genericHelper;
        this.commentRepository = commentRepository;
        this.commentDataMapper = commentDataMapper;
        this.validateHelper = validateHelper;
        this.codeAssessmentDomainService = codeAssessmentDomainService;
    }

    @Transactional
    public Comment createComment(CreateCommentCommand command) {
        User user = validateHelper.validateUserByEmail(command.getEmail());

        SharedSolution sharedSolution = validateHelper.validateSharedSolution(command.getSharedSolutionId());

        Comment replyComment = command.getReplyId() == null? null: validateHelper.validateComment(command.getReplyId());

        if(replyComment != null && !replyComment.getSharedSolutionId().equals(sharedSolution.getId())){
            throw new CodeAssessmentDomainException("Shared solution " + command.getSharedSolutionId() + "does not own root comment " + command.getReplyId());
        }

        Comment comment = commentDataMapper.createCommentCommandToCommand(command, user);
        codeAssessmentDomainService.intitateComment(comment, replyComment);

        return commentRepository.save(comment);

    }

    @Transactional
    public void updateComment(UpdateCommentCommand command) {
        User user = validateHelper.validateUserByEmail(command.getEmail());

        Comment comment = validateHelper.validateComment(command.getCommentId());

        if(!comment.getUser().equals(user))
            throw new CodeAssessmentDomainException("User " + user.getId().getValue() + "does not own comment " + command.getCommentId());

        Comment updatedComment = commentDataMapper.updateCommentCommandToComment(command);
        genericHelper.mapRepositoryAttributeToUpdateAttribute(comment, updatedComment, Comment.class);

        commentRepository.save(comment);
    }

    @Transactional
    public void deleteComment(DeleteCommentCommand command) {
        User user = validateHelper.validateUserByEmail(command.getEmail());
        Comment comment = validateHelper.validateComment(command.getCommentId());

        if(!comment.getUser().equals(user))
            throw new CodeAssessmentDomainException("User " + user.getId().getValue() + "does not own comment " + command.getCommentId());

        commentRepository.deleteById(new CommentId(command.getCommentId()));
    }

    @Transactional
    public Page<Comment> getComments(GetSolutionCommentCommand command) {
        User user = validateHelper.validateUserByEmail(command.getEmail());
        SharedSolution sharedSolution = validateHelper.validateSharedSolution(command.getSharedSolutionId());

        return commentRepository.findBySharedSolutionId(
                sharedSolution.getId(),
                user.getId(),
                command.getPageNum(),
                command.getPageSize(),
                command.getOrderBy());
    }

    @Transactional
    public List<Comment> getReplyComments(GetReplyCommentCommand command) {
        User user = validateHelper.validateUser(command.getUserId());
        Comment comment = validateHelper.validateComment(command.getRootCommentId());

        return commentRepository.findReplyByRootCommentId(comment.getId(), user.getId());

    }

    @Transactional
    public void voteComment(VoteCommentCommand command) {
        validateHelper.validateUser(command.getUserId());
        validateHelper.validateComment(command.getCommentId());
        CommentVote commentVote = commentDataMapper.voteCommentCommandToCommentVote(command);
        commentRepository.vote(commentVote);

    }

    @Transactional
    public void unvoteComment(UnvoteCommentCommand command) {
        CommentVoteId commentVoteId = commentDataMapper.unvoteCommentCommandToCommentVoteId(command);
        validateHelper.validateCommentVote(commentVoteId);

        commentRepository.unvote(commentVoteId);
    }


}
