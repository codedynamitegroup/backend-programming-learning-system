package com.backend.programming.learning.system.code.assessment.service.domain.implement.service;

import com.backend.programming.learning.system.code.assessment.service.domain.entity.*;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.CodeAssessmentDomainException;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.code_question.CodeQuestionNotFoundException;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.programming_language.ProgrammingLanguageNotFoundException;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.shared_solution.SharedSolutionNotFound;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.shared_solution.SharedSolutionVoteNotFound;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.tag.TagNotFoundException;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.test_case.TestCaseNotFoundException;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.*;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.code_question.CodeQuestionRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.ProgrammingLanguageId;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.SharedSolutionId;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.TagId;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.programming_language_code_question.ProgrammingLanguageCodeQuestionId;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.shared_solution_vote.SharedSolutionVoteId;
import com.backend.programming.learning.system.domain.exception.user.UserNotFoundException;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;
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


    public ValidateHelper(CodeQuestionRepository codeQuestionRepository, ProgrammingLanguageRepository programmingLanguageRepository, TestCaseRepository testCaseRepository, UserRepository userRepository, TagRepository tagRepository, SharedSolutionRepository sharedSolutionRepository, ProgrammingLanguageCodeQuestionRepository programmingLanguageCodeQuestionRepository) {
        this.codeQuestionRepository = codeQuestionRepository;
        this.programmingLanguageRepository = programmingLanguageRepository;
        this.testCaseRepository = testCaseRepository;
        this.userRepository = userRepository;
        this.tagRepository = tagRepository;
        this.sharedSolutionRepository = sharedSolutionRepository;
        this.programmingLanguageCodeQuestionRepository = programmingLanguageCodeQuestionRepository;
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

    public ProgrammingLangauge validateLanguage(UUID languageId, UUID codeQuestionId) {
        Optional<ProgrammingLangauge> langauge = programmingLanguageRepository.findById(new ProgrammingLanguageId(languageId));

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
}
