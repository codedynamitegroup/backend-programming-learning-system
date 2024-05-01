package com.backend.programming.learning.system.code.assessment.service.domain.implement.service.code_submission;

import com.backend.programming.learning.system.code.assessment.service.domain.CodeAssessmentDomainService;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_submission.CreateCodeSubmissionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.*;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.CodeAssessmentDomainException;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.code_question.CodeQuestionNotFoundException;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.code_submission.CodeSubmissionJudgingServiceUnavailableException;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.programming_language.ProgrammingLanguageNotFoundException;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.test_case.TestCaseNotFoundException;
import com.backend.programming.learning.system.code.assessment.service.domain.mapper.code_submission.CodeSubmissionDataMapper;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.assessment.AssessmentSourceCodeByTestCases;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.*;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.code_question.CodeQuestionRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.code_submssion.CodeSubmissionRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.GradingStatus;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.programming_language_code_question.ProgrammingLanguageCodeQuestionId;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.ProgrammingLanguageId;
import com.backend.programming.learning.system.domain.exception.user.UserNotFoundException;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import io.netty.handler.timeout.ReadTimeoutException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClientRequestException;

import java.net.ConnectException;
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
    private final AssessmentSourceCodeByTestCases assessmentSourceCodeByTestCases;

    public CodeSubmissionHelper(CodeAssessmentDomainService codeAssessmentDomainService, CodeSubmissionDataMapper codeSubmissionDataMapper, CodeSubmissionRepository codeSubmissionRepository, CodeQuestionRepository codeQuestionRepository, ProgrammingLanguageRepository programmingLanguageRepository, TestCaseRepository testCaseRepository, UserRepository userRepository, CodeSubmissionTestCaseRepository codeSubmissionTestCaseRepository, ProgrammingLanguageCodeQuestionRepository programmingLanguageCodeQuestionRepository, AssessmentSourceCodeByTestCases assessmentSourceCodeByTestCases) {
        this.codeAssessmentDomainService = codeAssessmentDomainService;
        this.codeSubmissionDataMapper = codeSubmissionDataMapper;
        this.codeSubmissionRepository = codeSubmissionRepository;
        this.codeQuestionRepository = codeQuestionRepository;
        this.programmingLanguageRepository = programmingLanguageRepository;
        this.testCaseRepository = testCaseRepository;
        this.userRepository = userRepository;
        this.codeSubmissionTestCaseRepository = codeSubmissionTestCaseRepository;
        this.programmingLanguageCodeQuestionRepository = programmingLanguageCodeQuestionRepository;
        this.assessmentSourceCodeByTestCases = assessmentSourceCodeByTestCases;
    }

    //don't use @transactional here
    public CodeSubmission createCodeSubmission(CreateCodeSubmissionCommand createCodeSubmissionCommand) {
        CodeSubmission codeSubmission = initAndSaveCodeSubmission(createCodeSubmissionCommand);
        //send judge to get token and store token if success
        assessmentSourceCodeByTestCases.judge(codeSubmission);




        return codeSubmission;
    }
    @Transactional
    public CodeSubmission initAndSaveCodeSubmission(CreateCodeSubmissionCommand createCodeSubmissionCommand){
        CodeSubmission codeSubmission = codeSubmissionDataMapper.createCodeSubmissionCommandToCodeSubmission(createCodeSubmissionCommand);

        validateUser(createCodeSubmissionCommand.getUserId());
        validateCodeQuestion(createCodeSubmissionCommand.getCodeQuestionId());
        ProgrammingLangauge programmingLangauge = validateLanguage(createCodeSubmissionCommand.getLanguageId(), createCodeSubmissionCommand.getCodeQuestionId());
        ProgrammingLanguageCodeQuestion plcq =
                validateProgrammingLanguageCodeQuestion(createCodeSubmissionCommand.getLanguageId(), createCodeSubmissionCommand.getCodeQuestionId());

        List<TestCase> testCases =  validateTestCases(createCodeSubmissionCommand.getCodeQuestionId());
        codeAssessmentDomainService.initiateCodeSubmission(codeSubmission, testCases, plcq, programmingLangauge);

        codeSubmissionRepository.save(codeSubmission);
        codeSubmissionTestCaseRepository.save(codeSubmission.getCodeSubmissionTestCaseList());

        return codeSubmission;
    }

    private List<TestCase> validateTestCases(UUID codeQuestionId) {
        List<TestCase> testCases = testCaseRepository.getTestCaseByCodeQuestionId(new CodeQuestionId(codeQuestionId));
        if(testCases.isEmpty()){
            log.error("This code question has no test case to submit!");
            throw new TestCaseNotFoundException("This code question has no test case to submit");
        }
        return testCases;
    }

    private ProgrammingLanguageCodeQuestion validateProgrammingLanguageCodeQuestion(UUID languageId, UUID codeQuestionId) {
        Optional<ProgrammingLanguageCodeQuestion> plcq
                = programmingLanguageCodeQuestionRepository
                .findById(new ProgrammingLanguageCodeQuestionId
                        (new ProgrammingLanguageId(languageId), new CodeQuestionId(codeQuestionId)));

        if (plcq.isEmpty()) {
            log.warn("lanquage with id {} does not support code question {}", languageId, codeQuestionId);
            throw new CodeAssessmentDomainException("lanquage with id " + languageId + " does not support code question " + codeQuestionId);
        }
        return plcq.get();
    }

    private ProgrammingLangauge validateLanguage(UUID languageId, UUID codeQuestionId) {
        Optional<ProgrammingLangauge> langauge = programmingLanguageRepository.findById(new ProgrammingLanguageId(languageId));

        if (langauge.isEmpty()) {
            log.warn("Could not find programming language with id: {}", languageId);
            throw new ProgrammingLanguageNotFoundException("Could not find programming language with id: " + languageId);
        }
        return langauge.get();
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
