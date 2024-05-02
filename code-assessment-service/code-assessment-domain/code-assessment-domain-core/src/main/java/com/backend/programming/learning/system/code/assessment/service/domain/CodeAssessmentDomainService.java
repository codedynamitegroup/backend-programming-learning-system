package com.backend.programming.learning.system.code.assessment.service.domain;

import com.backend.programming.learning.system.code.assessment.service.domain.entity.*;
import com.backend.programming.learning.system.code.assessment.service.domain.event.CodeQuestionsUpdatedEvent;
import com.backend.programming.learning.system.domain.valueobject.CopyState;

import java.util.List;

public interface CodeAssessmentDomainService {
    CodeQuestionsUpdatedEvent validateAndInitiateCodeQuestion(CodeQuestion codeQuestion);
    List<TestCase> initiateTestCases(List<TestCase> testCases);
    void cancelCopyCodeQuestions(CodeQuestion codeQuestion, CopyState state, List<String> failureMessages);

    CodeSubmission initiateCodeSubmission(CodeSubmission codeSubmission, List<TestCase> testCases, ProgrammingLanguageCodeQuestion programmingLanguageCodeQuestion, ProgrammingLangauge programmingLangauge);

    void increaseCodeSubmissionGradedTestCase(CodeSubmission codeSubmission);
}
