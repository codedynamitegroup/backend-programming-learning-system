package com.backend.programming.learning.system.code.assessment.service.domain.implement.service.code_submission;

import com.backend.programming.learning.system.code.assessment.service.domain.CodeAssessmentDomainService;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_submission.CreateCodeSubmissionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.*;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.CodeAssessmentDomainException;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.code_question.CodeQuestionNotFoundException;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.programming_language.ProgrammingLanguageNotFoundException;
import com.backend.programming.learning.system.code.assessment.service.domain.mapper.code_submission.CodeSubmissionDataMapper;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.*;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.code_question.CodeQuestionRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.code_submssion.CodeSubmissionRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.programming_language_code_question.ProgrammingLanguageCodeQuestionId;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.ProgrammingLanguageId;
import com.backend.programming.learning.system.domain.exception.user.UserNotFoundException;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@Slf4j
public class CodeSubmissionHelper {
    private final CodeAssessmentDomainService codeAssessmentDomainService;
    private final CodeSubmissionDataMapper codeSubmissionDataMapper;
    private final CodeSubmissionRepository codeSubmissionRepository;
    private final CodeQuestionRepository codeQuestionRepository;
    private final ProgrammingLanguageRepository programmingLanguageRepository;
    private final TestCaseRepository testCaseRepository;
    private final UserRepository userRepository;
    private final CodeSubmissionTestCaseRepository codeSubmissionTestCaseRepository;
    private final ProgrammingLanguageCodeQuestionRepository programmingLanguageCodeQuestionRepository;


    public CodeSubmissionHelper(CodeAssessmentDomainService codeAssessmentDomainService, CodeSubmissionDataMapper codeSubmissionDataMapper, CodeSubmissionRepository codeSubmissionRepository, CodeQuestionRepository codeQuestionRepository, ProgrammingLanguageRepository programmingLanguageRepository, TestCaseRepository testCaseRepository, UserRepository userRepository, CodeSubmissionTestCaseRepository codeSubmissionTestCaseRepository, ProgrammingLanguageCodeQuestionRepository programmingLanguageCodeQuestionRepository) {
        this.codeAssessmentDomainService = codeAssessmentDomainService;
        this.codeSubmissionDataMapper = codeSubmissionDataMapper;
        this.codeSubmissionRepository = codeSubmissionRepository;
        this.codeQuestionRepository = codeQuestionRepository;
        this.programmingLanguageRepository = programmingLanguageRepository;
        this.testCaseRepository = testCaseRepository;
        this.userRepository = userRepository;
        this.codeSubmissionTestCaseRepository = codeSubmissionTestCaseRepository;
        this.programmingLanguageCodeQuestionRepository = programmingLanguageCodeQuestionRepository;
    }

    public CodeSubmission createCodeSubmission(CreateCodeSubmissionCommand createCodeSubmissionCommand) {
        CodeSubmission codeSubmission = initAndSaveCodeSubmission(createCodeSubmissionCommand);
        //send judge to get token
        //send 5 time
        //store token if success

        //change codesubmission state if sending failed and throw error

        return codeSubmission;
    }
    @Transactional
    public CodeSubmission initAndSaveCodeSubmission(CreateCodeSubmissionCommand createCodeSubmissionCommand){
        CodeSubmission codeSubmission = codeSubmissionDataMapper.createCodeSubmissionCommandToCodeSubmission(createCodeSubmissionCommand);

        validateUser(createCodeSubmissionCommand.getUserId());
        validateCodeQuestion(createCodeSubmissionCommand.getCodeQuestionId());
        validateLanguage(createCodeSubmissionCommand.getLanguageId(), createCodeSubmissionCommand.getCodeQuestionId());

        List<TestCase> testCases = testCaseRepository.getTestCaseByCodeQuestionId(new CodeQuestionId(createCodeSubmissionCommand.getCodeQuestionId()));
        codeAssessmentDomainService.initiateCodeSubmission(codeSubmission, testCases);

        CodeSubmission codeSubmissionRes = codeSubmissionRepository.save(codeSubmission);
        codeSubmissionTestCaseRepository.save(codeSubmission.getCodeSubmissionTestCaseList());

        return codeSubmissionRes;
    }

    private void validateLanguage(UUID languageId, UUID codeQuestionId) {
        Optional<ProgrammingLangauge> langauge = programmingLanguageRepository.findById(new ProgrammingLanguageId(languageId));

        if (langauge.isEmpty()) {
            log.warn("Could not find programming language with id: {}", languageId);
            throw new ProgrammingLanguageNotFoundException("Could not find programming language with id: " + languageId);
        }
        Optional<ProgrammingLanguageCodeQuestion> plcq
                = programmingLanguageCodeQuestionRepository
                .findById(new ProgrammingLanguageCodeQuestionId
                        (new ProgrammingLanguageId(languageId), new CodeQuestionId(codeQuestionId)));

        if (plcq.isEmpty()) {
            log.warn("lanquage with id {} does not support code question {}", languageId, codeQuestionId);
            throw new CodeAssessmentDomainException("lanquage with id " + languageId + " does not support code question " + codeQuestionId);
        }
    }

    private void validateCodeQuestion(UUID codeQuestionId) {
        Optional<CodeQuestion> codeQuestion = codeQuestionRepository.findById(new CodeQuestionId(codeQuestionId));

        if (codeQuestion.isEmpty()) {
            log.warn("Could not find code question with id: {}", codeQuestionId);
            throw new CodeQuestionNotFoundException("Could not find code question with id: " + codeQuestionId);
        }

    }

    private void validateUser(UUID userId) {
        Optional<User> user = userRepository.findById(new UserId(userId));

        if (user.isEmpty()) {
            log.warn("Could not find user with id: {}", userId);
            throw new UserNotFoundException("Could not find user with id: " + userId);
        }
    }
}
