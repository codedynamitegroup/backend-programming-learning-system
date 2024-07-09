package com.backend.programming.learning.system.code.assessment.service.domain;

import com.backend.programming.learning.system.code.assessment.service.domain.entity.*;
import com.backend.programming.learning.system.code.assessment.service.domain.event.code_question.CodeQuestionsUpdatedEvent;
import com.backend.programming.learning.system.code.assessment.service.domain.event.code_submission.CodeSubmissionUpdatedEvent;
import com.backend.programming.learning.system.code.assessment.service.domain.event.user.*;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;
import com.backend.programming.learning.system.domain.valueobject.CopyState;

import java.util.List;
import java.util.UUID;

public interface CodeAssessmentDomainService {
    CodeQuestionsUpdatedEvent validateAndInitiateCodeQuestion(CodeQuestion codeQuestion);
    List<TestCase> initiateTestCases(List<TestCase> testCases);
    void cancelCopyCodeQuestions(CodeQuestion codeQuestion, CopyState state, List<String> failureMessages);

    CodeSubmissionUpdatedEvent initiateCodeSubmission(CodeSubmission codeSubmission, List<TestCase> testCases, ProgrammingLanguageCodeQuestion programmingLanguageCodeQuestion, ProgrammingLanguage programmingLangauge);

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

    void inititateProgrammingLanguage(ProgrammingLanguage programmingLanguage);

    CodeQuestion getDetailCodeQuestion(CodeQuestion codeQuestion, List<TestCase> sampleTestCase, List<CodeSubmission> codeSubmission, List<ProgrammingLanguageCodeQuestion> languages);

    ProgrammingLanguageCodeQuestion initProgrammingLanguageCodeQuestion(Float timeLimit, Float memoryLimit, String bodyCode, CodeQuestionId codeQuestionId, UUID id);

    ProgrammingLanguageCodeQuestion initProgrammingLanguageCodeQuestion(Float timeLimit, Float memoryLimit, String headCode, String bodyCode, String tailCode ,CodeQuestionId codeQuestionId, UUID id);

    CodeQuestionsUpdatedEvent updateCodeQuestion(CodeQuestion codeQuestion);

    CodeQuestion getAdminDetailCodeQuestion(CodeQuestion codeQuestion, List<TestCase> testcases, List<ProgrammingLanguageCodeQuestion> languages, List<Tag> tags);
}
