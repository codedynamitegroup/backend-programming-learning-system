package com.backend.programming.learning.system.code.assessment.service.domain.implement.service.shared_solution.comment;

import com.backend.programming.learning.system.code.assessment.service.domain.CodeAssessmentDomainService;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.comment.CreateCommentCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.update.shared_solution.comment.UpdateCommentCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.Comment;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.User;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.CodeAssessmentDomainException;
import com.backend.programming.learning.system.code.assessment.service.domain.implement.service.GenericHelper;
import com.backend.programming.learning.system.code.assessment.service.domain.implement.service.ValidateHelper;
import com.backend.programming.learning.system.code.assessment.service.domain.mapper.shared_solution.comment.CommentDataMapper;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.CommentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

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

    public Comment createComment(CreateCommentCommand command) {
        User user = validateHelper.validateUser(command.getUserId());

        validateHelper.validateSharedSolution(command.getSharedSolutionId());

        Comment replyComment = command.getReplyId() == null? null: validateHelper.validateComment(command.getReplyId());

        Comment comment = commentDataMapper.createCommentCommandToCommand(command, user);
        codeAssessmentDomainService.intitateComment(comment, replyComment);

        return commentRepository.save(comment);

    }

    public void updateComment(UpdateCommentCommand command) {
        User user = validateHelper.validateUser(command.getUserId());

        validateHelper.validateSharedSolution(command.getSharedSolutionId());

        Comment comment = validateHelper.validateComment(command.getCommentId());

        if(!comment.getUser().equals(user))
            throw new CodeAssessmentDomainException("User " + command.getUserId() + "does not own comment " + command.getCommentId());

        Comment updatedComment = commentDataMapper.updateCommentCommandToComment(command);
        genericHelper.mapRepositoryAttributeToUpdateAttribute(comment, updatedComment, Comment.class);

        commentRepository.save(comment);
    }
}
