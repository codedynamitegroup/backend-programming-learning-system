package com.backend.programming.learning.system.code.assessment.service.domain.implement.service;

import com.backend.programming.learning.system.code.assessment.service.domain.entity.*;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.CodeAssessmentDomainException;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.code_question.CodeQuestionNotFoundException;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.code_question.tag.CodeQuestionTagNotFoundException;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.code_submission.CodeSubmissionNotFound;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.programming_language.ProgrammingLanguageNotFoundException;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.shared_solution.SharedSolutionNotFound;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.shared_solution.SharedSolutionVoteNotFound;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.shared_solution.comment.CommentNotFoundException;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.tag.TagNotFoundException;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.test_case.TestCaseNotFoundException;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.*;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.code_question.CodeQuestionRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.code_submssion.CodeSubmissionRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.CommentId;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.SharedSolutionId;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.TagId;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.code_question_tag.CodeQuestionTagId;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.comment_vote.CommentVoteId;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.programming_language_code_question.ProgrammingLanguageCodeQuestionId;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.shared_solution_vote.SharedSolutionVoteId;
import com.backend.programming.learning.system.domain.exception.user.UserNotFoundException;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;
import com.backend.programming.learning.system.domain.valueobject.CodeSubmissionId;
import com.backend.programming.learning.system.domain.valueobject.ProgrammingLanguageId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@Slf4j
public class ValidateHelper {
    private final CodeQuestionRepository codeQuestionRepository;
    private final ProgrammingLanguageRepository programmingLanguageRepository;
    private final TestCaseRepository testCaseRepository;
    private final UserRepository userRepository;
    private final TagRepository tagRepository;
    private final SharedSolutionRepository sharedSolutionRepository;
    private final ProgrammingLanguageCodeQuestionRepository programmingLanguageCodeQuestionRepository;
    private final CommentRepository commentRepository;
    private final CodeSubmissionRepository codeSubmissionRepository;

    public ValidateHelper(CodeQuestionRepository codeQuestionRepository, ProgrammingLanguageRepository programmingLanguageRepository, TestCaseRepository testCaseRepository, UserRepository userRepository, TagRepository tagRepository, SharedSolutionRepository sharedSolutionRepository, ProgrammingLanguageCodeQuestionRepository programmingLanguageCodeQuestionRepository, CommentRepository commentRepository, CodeSubmissionRepository codeSubmissionRepository) {
        this.codeQuestionRepository = codeQuestionRepository;
        this.programmingLanguageRepository = programmingLanguageRepository;
        this.testCaseRepository = testCaseRepository;
        this.userRepository = userRepository;
        this.tagRepository = tagRepository;
        this.sharedSolutionRepository = sharedSolutionRepository;
        this.programmingLanguageCodeQuestionRepository = programmingLanguageCodeQuestionRepository;
        this.commentRepository = commentRepository;
        this.codeSubmissionRepository = codeSubmissionRepository;
    }

    public List<TestCase> validateTestCasesByCodeQuestionId(UUID codeQuestionId) {
        List<TestCase> testCases = testCaseRepository.getTestCaseByCodeQuestionId(new CodeQuestionId(codeQuestionId));
        if(testCases.isEmpty()){
            log.error("This code question has no test case to submit!");
            throw new TestCaseNotFoundException("This code question has no test case to submit");
        }
        return testCases;
    }

    public ProgrammingLanguageCodeQuestion validateProgrammingLanguageCodeQuestion(UUID languageId, UUID codeQuestionId) {
        Optional<ProgrammingLanguageCodeQuestion> plcq
                = programmingLanguageCodeQuestionRepository
                .findById(new ProgrammingLanguageCodeQuestionId
                        (new ProgrammingLanguageId(languageId), new CodeQuestionId(codeQuestionId)));

        if (plcq.isEmpty()) {
            log.error("lanquage with id {} does not support code question {}", languageId, codeQuestionId);
            throw new CodeAssessmentDomainException("lanquage with id " + languageId + " does not support code question " + codeQuestionId);
        }
        return plcq.get();
    }

    public ProgrammingLanguage validateLanguage(UUID languageId, UUID codeQuestionId) {
        Optional<ProgrammingLanguage> langauge = programmingLanguageRepository.findById(new ProgrammingLanguageId(languageId));

        if (langauge.isEmpty()) {
            log.error("Could not find programming language with id: {}", languageId);
            throw new ProgrammingLanguageNotFoundException("Could not find programming language with id: " + languageId);
        }
        return langauge.get();
    }

    public CodeQuestion validateCodeQuestion(UUID codeQuestionId) {
        Optional<CodeQuestion> codeQuestion = codeQuestionRepository.findById(new CodeQuestionId(codeQuestionId));

        if (codeQuestion.isEmpty()) {
            log.error("Could not find code question with id: {}", codeQuestionId);
            throw new CodeQuestionNotFoundException("Could not find code question with id: " + codeQuestionId);
        }
        return codeQuestion.get();

    }

    public User validateUser(UUID userId) {
        Optional<User> user = userRepository.findById(new UserId(userId));

        if (user.isEmpty()) {
            log.error("Could not find user with id: {}", userId);
            throw new UserNotFoundException("Could not find user with id: " + userId);
        }
        return user.get();
    }

    @Transactional
    public List<Tag> validateTagsById(List<UUID> tagIds) {
        return tagIds.stream().map(id->{
            Optional<Tag> tagOpt = tagRepository.findById(new TagId(id));
            if(tagOpt.isPresent())
                return tagOpt.get();
            else {
                log.error("Tag with id {} not found", id);
                throw new TagNotFoundException("Tag with id: " + id + " not found");
            }
        }).toList();
    }

    public SharedSolution validateSharedSolution(UUID sharedSolutionId, UUID voteUserId){
        Optional<SharedSolution> sharedSolutionOpt =
                sharedSolutionRepository.findById(sharedSolutionId, voteUserId);
        if(sharedSolutionOpt.isPresent()){
            return sharedSolutionOpt.get();
        }else{
            log.error("Solution with id: {} not found", sharedSolutionId);
            throw new SharedSolutionNotFound("Solution with id: " + sharedSolutionId + " not found");
        }
    }
    public SharedSolution validateSharedSolution(UUID sharedSolutionId){
        Optional<SharedSolution> sharedSolutionOpt =
                sharedSolutionRepository.findById(sharedSolutionId);
        if(sharedSolutionOpt.isPresent()){
            return sharedSolutionOpt.get();
        }else{
            log.error("Solution with id: {} not found", sharedSolutionId);
            throw new SharedSolutionNotFound("Solution with id: " + sharedSolutionId + " not found");
        }
    }

    public SharedSolutionVote validateSharedSolutionVote(SharedSolutionVoteId id) {
        Optional<SharedSolutionVote> sharedSolutionVoteOpt =
                sharedSolutionRepository.findSharedSolutionVoteById(id);
        UserId userId = id.getValue().getUserId();
        SharedSolutionId sharedSolutionId = id.getValue().getSharedSolutionId();
        if(sharedSolutionVoteOpt.isPresent()){
            return sharedSolutionVoteOpt.get();
        }else{
            log.error("SharedSolutionVote with userId: {} and solutionId: {} not found", userId, sharedSolutionId);
            throw new SharedSolutionVoteNotFound("SharedSolutionVote with userId: " + userId.getValue() + " and solutionId: " + sharedSolutionId.getValue() + " not found");
        }
    }

    public Comment validateComment(UUID replyId) {
        Optional<Comment> commentOpt =
                commentRepository.findById(new CommentId(replyId));
        if(commentOpt.isPresent()){
            return commentOpt.get();
        }else{
            log.error("Comment with id: {} not found", replyId);
            throw new CommentNotFoundException("Comment with id: " + replyId + " not found");
        }
    }

    public CommentVote validateCommentVote(CommentVoteId commentVoteId) {
        Optional<CommentVote> commentVoteOpt =
                commentRepository.findCommentVoteId(commentVoteId);
        UserId userId = commentVoteId.getValue().getUserId();
        CommentId commentId = commentVoteId.getValue().getCommentId();
        if(commentVoteOpt.isPresent()){
            return commentVoteOpt.get();
        }else{
            log.error("CommentVote with userId: {} and comment: {} not found", userId, commentId);
            throw new CommentNotFoundException("SharedSolutionVote with userId: " + userId.getValue() + " and solutionId: " + commentId.getValue() + " not found");
        }
    }

    public CodeSubmission validateCodeSubmission(CodeSubmissionId codeSubmissionId) {
        Optional<CodeSubmission> codeSubmissionOpt = codeSubmissionRepository.findById(codeSubmissionId);
        if(codeSubmissionOpt.isPresent())
            return codeSubmissionOpt.get();
        else {
            log.error("codesubmission with id: {} not found", codeSubmissionId);
            throw new CodeSubmissionNotFound("codesubmission with id " + codeSubmissionId.getValue() + " not found");
        }
    }

    public Tag validateTagById(UUID id) {
        Optional<Tag> tagOpt = tagRepository.findById(new TagId(id));
        if(tagOpt.isPresent())
            return tagOpt.get();
        else {
            log.error("tag with id: {} not found", id);
            throw new TagNotFoundException("tag with id " + id + " not found");
        }
    }

    public ProgrammingLanguage validateProgrammingLanguage(ProgrammingLanguageId programmingLanguageId) {
        Optional<ProgrammingLanguage> plOpt = programmingLanguageRepository.findById(programmingLanguageId);
        if(plOpt.isPresent())
            return plOpt.get();
        else {
            log.error("programming language with id: {} not found", programmingLanguageId);
            throw new ProgrammingLanguageNotFoundException("programming language with id " + programmingLanguageId.getValue() + " not found");
        }
    }
    public List<ProgrammingLanguage> validateProgrammingLanguage(List<UUID> ids) {
        return ids.stream().map(id->{
            Optional<ProgrammingLanguage> plOpt = programmingLanguageRepository.findById(new ProgrammingLanguageId(id));
            if(plOpt.isPresent())
                return plOpt.get();
            else {
                log.error("Language with id {} not found", id);
                throw new ProgrammingLanguageNotFoundException("Language with id: " + id + " not found");
            }
        }).toList();
    }

    public List<CodeQuestionTag> validateCodeQuestionTagsById(List<CodeQuestionTagId> ids) {
        return ids.stream().map(id->{
            Optional<CodeQuestionTag> cqt = codeQuestionRepository.findCodeQuestionTagById(id);
            if(cqt.isPresent())
                return cqt.get();
            else {
                log.error("CodeQuestion {} with tag id {} not found", id.getValue().getCodeQuestionId(), id.getValue().getTagId());
                throw new CodeQuestionTagNotFoundException("CodeQuestion " + id.getValue().getCodeQuestionId().getValue() + " with tag id " + id.getValue().getTagId().getValue() + " not found");
            }
        }).toList();
    }

    public User validateUserByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);

        if (user.isEmpty()) {
            log.error("Could not find user with email: {}", email);
            throw new UserNotFoundException("Could not find user with email: " + email);
        }
        return user.get();
    }
}
