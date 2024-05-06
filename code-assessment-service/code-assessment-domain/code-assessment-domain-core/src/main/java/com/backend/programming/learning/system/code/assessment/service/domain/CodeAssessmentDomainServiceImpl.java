package com.backend.programming.learning.system.code.assessment.service.domain;

import com.backend.programming.learning.system.code.assessment.service.domain.entity.*;
import com.backend.programming.learning.system.code.assessment.service.domain.event.CodeQuestionsUpdatedEvent;
import com.backend.programming.learning.system.code.assessment.service.domain.event.user.*;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.GradingStatus;
import com.backend.programming.learning.system.domain.DomainConstants;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import lombok.extern.slf4j.Slf4j;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@Slf4j
public class CodeAssessmentDomainServiceImpl implements CodeAssessmentDomainService{
    @Override
    public CodeQuestionsUpdatedEvent
    validateAndInitiateCodeQuestion(CodeQuestion codeQuestion) {

        codeQuestion.validateCodeQuestion();
        codeQuestion.initializeCodeQuestion();
        log.info("Code question with id: {} is initiated", codeQuestion.getId().getValue());
        return new CodeQuestionsUpdatedEvent(codeQuestion, ZonedDateTime.now(ZoneId.of("UTC")));
    }

    @Override
    public List<TestCase> initiateTestCases(List<TestCase> testCases) {
        testCases.forEach(TestCase::initiate);
        return testCases;
    }

    @Override
    public void cancelCopyCodeQuestions(CodeQuestion codeQuestion, CopyState state, List<String> failureMessages) {
        codeQuestion.initCancelCopy(state, failureMessages);
    }

    @Override
    public CodeSubmission initiateCodeSubmission(CodeSubmission codeSubmission, CodeQuestion codeQuestion, List<TestCase> testCases, ProgrammingLanguageCodeQuestion programmingLanguageCodeQuestion, ProgrammingLangauge programmingLangauge) {
        codeSubmission.initiate(codeQuestion ,testCases, programmingLanguageCodeQuestion);
        codeSubmission.setProgrammingLangaugeJudge0Id(programmingLangauge.getJudge0_compilerApiId());

        return codeSubmission;
    }

    @Override
    public void increaseCodeSubmissionGradedTestCase(CodeSubmission codeSubmission) {
        codeSubmission.increaseGradedTestCaseByOne();
    }

    @Override
    public void calculateAvgTimeAndMemoryAndGrade(CodeSubmission codeSubmission, List<CodeSubmissionTestCase> cstc, String acceptedDescription) {
        boolean notAllAccepted = cstc.stream().anyMatch(item -> !item.getStatusDescription().equals(acceptedDescription));
        if(!notAllAccepted){
            Double avgTime = cstc.stream()
                    .mapToDouble(item -> item.getRunTime().doubleValue())
                    .average()
                    .orElse(Double.NaN);
            Double avgMemory = cstc.stream()
                    .mapToDouble(item -> item.getMemory().doubleValue())
                    .average()
                    .orElse(Double.NaN);
            codeSubmission.updateAvgTimeAndMemoryAndGrade(avgTime, avgMemory, cstc.size());
        }
        else
            codeSubmission.updateAvgTimeAndMemoryAndGrade
                    (null , null,
                            cstc.stream()
                                    .filter(item-> item.getStatusDescription().equals(acceptedDescription))
                                    .count());

        codeSubmission.setGradingStatus(GradingStatus.GRADED);
    }

    @Override
    public UserCreatedSuccessEvent createdUserSuccess(User user) {
        return new UserCreatedSuccessEvent(user,
                ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM)));
    }

    @Override
    public UserCreatedFailEvent createdUserFail(User user, List<String> failureMessages) {
        return new UserCreatedFailEvent(user,
                ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM)), failureMessages);
    }

    @Override
    public UserUpdatedSuccessEvent updatedUserSuccess(User user) {
        return new UserUpdatedSuccessEvent(user,
                ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM)));
    }

    @Override
    public UserUpdatedFailEvent updatedUserFail(User user, List<String> failureMessages) {
        return new UserUpdatedFailEvent(user,
                ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM)),
                failureMessages);
    }

    @Override
    public UserDeletedSuccessEvent deletedUserSuccess(User user) {
        return new UserDeletedSuccessEvent(user,
                ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM)));
    }

    @Override
    public UserDeletedFailEvent deletedUserFail(User user, List<String> failureMessages) {
        return new UserDeletedFailEvent(user,
                ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM)),
                failureMessages);
    }
}
