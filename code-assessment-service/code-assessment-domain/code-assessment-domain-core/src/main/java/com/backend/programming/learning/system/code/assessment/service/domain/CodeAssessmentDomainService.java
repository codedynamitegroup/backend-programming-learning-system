package com.backend.programming.learning.system.code.assessment.service.domain;

import com.backend.programming.learning.system.code.assessment.service.domain.entity.*;
import com.backend.programming.learning.system.code.assessment.service.domain.event.CodeQuestionsUpdatedEvent;
import com.backend.programming.learning.system.code.assessment.service.domain.event.user.*;
import com.backend.programming.learning.system.domain.valueobject.CopyState;

import java.util.List;

public interface CodeAssessmentDomainService {
    CodeQuestionsUpdatedEvent validateAndInitiateCodeQuestion(CodeQuestion codeQuestion);
    List<TestCase> initiateTestCases(List<TestCase> testCases);
    void cancelCopyCodeQuestions(CodeQuestion codeQuestion, CopyState state, List<String> failureMessages);

    CodeSubmission initiateCodeSubmission(CodeSubmission codeSubmission, List<TestCase> testCases, ProgrammingLanguageCodeQuestion programmingLanguageCodeQuestion, ProgrammingLangauge programmingLangauge);

    void calculateAvgTimeAndMemoryAndGrade(CodeSubmission codeSubmission, List<CodeSubmissionTestCase> cstc, String acceptedDescription);

    UserCreatedSuccessEvent createdUserSuccess(User user);
    UserCreatedFailEvent createdUserFail(User user, List<String> failureMessages);
    UserUpdatedSuccessEvent updatedUserSuccess(User user);
    UserUpdatedFailEvent updatedUserFail(User user, List<String> failureMessages);
    UserDeletedSuccessEvent deletedUserSuccess(User user);
    UserDeletedFailEvent deletedUserFail(User user, List<String> failureMessages);
    
    SharedSolution initiateSharedSolution(SharedSolution sharedSolution, List<Tag> tags);

    void initiateTags(List<Tag> tags);

    void intitateComment(Comment comment, Comment replyComment);
}
