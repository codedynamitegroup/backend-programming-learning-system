package com.backend.programming.learning.system.code.assessment.service.domain;

import com.backend.programming.learning.system.code.assessment.service.domain.entity.*;
import com.backend.programming.learning.system.code.assessment.service.domain.event.CodeQuestionsUpdatedEvent;
import com.backend.programming.learning.system.code.assessment.service.domain.event.user.*;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.CodeAssessmentDomainException;
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
    public CodeSubmission initiateCodeSubmission(CodeSubmission codeSubmission, List<TestCase> testCases, ProgrammingLanguageCodeQuestion programmingLanguageCodeQuestion, ProgrammingLangauge programmingLangauge) {
        codeSubmission.initiate(testCases, programmingLanguageCodeQuestion);
        codeSubmission.setProgrammingLangaugeJudge0Id(programmingLangauge.getJudge0_compilerApiId());

        return codeSubmission;
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
                ZonedDateTime.now(ZoneId.of(DomainConstants.UTC)));
    }
    
    public SharedSolution initiateSharedSolution(SharedSolution sharedSolution, List<Tag> tags) {
        sharedSolution.initiate(tags);
        return sharedSolution;
    }

    @Override
    public void initiateTags(List<Tag> tags){
        tags.forEach(Tag::inititate);
    }

    @Override
    public void intitateComment(Comment comment, Comment replyComment) {
        if(replyComment != null &&  replyComment.getReplyLevel() != 0)
            throw new CodeAssessmentDomainException("Reply comment must be the root comment with id " + replyComment.getReplyId().getValue());

        comment.initate(replyComment);
    }


    @Override
    public UserCreatedFailEvent createdUserFail(User user, List<String> failureMessages) {
        return new UserCreatedFailEvent(user,
                ZonedDateTime.now(ZoneId.of(DomainConstants.UTC)), failureMessages);
    }

    @Override
    public UserUpdatedSuccessEvent updatedUserSuccess(User user) {
        return new UserUpdatedSuccessEvent(user,
                ZonedDateTime.now(ZoneId.of(DomainConstants.UTC)));
    }

    @Override
    public UserUpdatedFailEvent updatedUserFail(User user, List<String> failureMessages) {
        return new UserUpdatedFailEvent(user,
                ZonedDateTime.now(ZoneId.of(DomainConstants.UTC)),
                failureMessages);
    }

    @Override
    public UserDeletedSuccessEvent deletedUserSuccess(User user) {
        return new UserDeletedSuccessEvent(user,
                ZonedDateTime.now(ZoneId.of(DomainConstants.UTC)));
    }

    @Override
    public UserDeletedFailEvent deletedUserFail(User user, List<String> failureMessages) {
        return new UserDeletedFailEvent(user,
                ZonedDateTime.now(ZoneId.of(DomainConstants.UTC)),
                failureMessages);
    }
}
