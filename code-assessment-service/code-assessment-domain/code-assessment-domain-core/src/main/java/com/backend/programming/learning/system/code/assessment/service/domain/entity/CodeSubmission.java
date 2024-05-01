package com.backend.programming.learning.system.code.assessment.service.domain.entity;

import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.CodeSubmissionTestCaseId;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.GradingStatus;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.ProgrammingLanguageId;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.valueobject.*;

import java.util.List;
import java.util.UUID;

public class CodeSubmission extends AggregateRoot<CodeSubmissionId> {
    private CodeQuestionId codeQuestionId;
    private UserId userId;
    private ProgrammingLanguageId languageId;
    private Double grade;
    private Double runTime;
    private Double memory;
    private String sourceCode;
    private GradingStatus gradingStatus;
    private String aiAssessment;
    private String sonaqueAssessment;
    private Integer numOfTestCase;
    private Integer numOfTestCaseGraded;
    private CopyState copyState;
    private List<CodeSubmissionTestCase> codeSubmissionTestCaseList;
    private ProgrammingLanguageCodeQuestion programmingLanguageCodeQuestion;
    private Integer programmingLangaugeJudge0Id;

    private CodeSubmission(Builder builder) {
        codeQuestionId = builder.codeQuestionId;
        userId = builder.userId;
        languageId = builder.languageId;
        grade = builder.grade;
        runTime = builder.runTime;
        memory = builder.memory;
        sourceCode = builder.sourceCode;
        gradingStatus = builder.gradingStatus;
        aiAssessment = builder.aiAssessment;
        sonaqueAssessment = builder.sonaqueAssessment;
        numOfTestCase = builder.numOfTestCase;
        numOfTestCaseGraded = builder.numOfTestCaseGraded;
        copyState = builder.copyState;
        setCodeSubmissionTestCaseList(builder.codeSubmissionTestCaseList);
        setProgrammingLanguageCodeQuestion(builder.programmingLanguageCodeQuestion);
        super.setId(builder.id);
    }

    public static Builder builder() {
        return new Builder();
    }

    public ProgrammingLanguageCodeQuestion getProgrammingLanguageCodeQuestion() {
        return programmingLanguageCodeQuestion;
    }

    public void setProgrammingLanguageCodeQuestion(ProgrammingLanguageCodeQuestion programmingLanguageCodeQuestion) {
        this.programmingLanguageCodeQuestion = programmingLanguageCodeQuestion;
    }

    public void setGradingStatus(GradingStatus gradingStatus) {
        this.gradingStatus = gradingStatus;
    }

    public Integer getProgrammingLangaugeJudge0Id() {
        return programmingLangaugeJudge0Id;
    }

    public void setProgrammingLangaugeJudge0Id(Integer programmingLangaugeJudge0Id) {
        this.programmingLangaugeJudge0Id = programmingLangaugeJudge0Id;
    }

    public Integer getNumOfTestCase() {
        return numOfTestCase;
    }

    public Integer getNumOfTestCaseGraded() {
        return numOfTestCaseGraded;
    }

    public CopyState getCopyState() {
        return copyState;
    }

    public List<CodeSubmissionTestCase> getCodeSubmissionTestCaseList() {
        return codeSubmissionTestCaseList;
    }
    public CodeQuestionId getCodeQuestionId() {
        return codeQuestionId;
    }

    public UserId getUserId() {
        return userId;
    }

    public ProgrammingLanguageId getLanguageId() {
        return languageId;
    }

    public Double getGrade() {
        return grade;
    }

    public Double getRunTime() {
        return runTime;
    }

    public Double getMemory() {
        return memory;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public GradingStatus getGradingStatus() {
        return gradingStatus;
    }

    public String getAiAssessment() {
        return aiAssessment;
    }

    public String getSonaqueAssessment() {
        return sonaqueAssessment;
    }

    public void initiate(List<TestCase> testCases, ProgrammingLanguageCodeQuestion plcq) {
        codeSubmissionTestCaseList =
                testCases.stream().map(this::initiateCodeSubmissionTestCase)
                        .toList();

        setId(new CodeSubmissionId(UUID.randomUUID()));
        gradingStatus = GradingStatus.GRADING;
        numOfTestCase = codeSubmissionTestCaseList.size();
        numOfTestCaseGraded = 0;
        copyState = CopyState.CREATING;
        programmingLanguageCodeQuestion = plcq;
    }

    private CodeSubmissionTestCase initiateCodeSubmissionTestCase(TestCase testCase) {
        return CodeSubmissionTestCase.builder()
                .id(new CodeSubmissionTestCaseId(UUID.randomUUID()))
                .testCase(testCase)
                .codeSubmission(this)
                .judgeToken("hi")
                .build();
    }

    public void setCodeSubmissionTestCaseList(List<CodeSubmissionTestCase> codeSubmissionTestCaseList) {
        this.codeSubmissionTestCaseList = codeSubmissionTestCaseList;
    }

    public static final class Builder {
        private CodeQuestionId codeQuestionId;
        private UserId userId;
        private ProgrammingLanguageId languageId;
        private Double grade;
        private Double runTime;
        private Double memory;
        private String sourceCode;
        private GradingStatus gradingStatus;
        private String aiAssessment;
        private String sonaqueAssessment;
        private Integer numOfTestCase;
        private Integer numOfTestCaseGraded;
        private CopyState copyState;
        private List<CodeSubmissionTestCase> codeSubmissionTestCaseList;
        private ProgrammingLanguageCodeQuestion programmingLanguageCodeQuestion;
        private Integer programmingLangaugeJudge0Id;

        private CodeSubmissionId id;
        private CodeQuestionLangauge codeQuestionLangauge;

        private Builder() {
        }

        public Builder codeQuestionId(CodeQuestionId val) {
            codeQuestionId = val;
            return this;
        }

        public Builder userId(UserId val) {
            userId = val;
            return this;
        }
        public Builder programmingLangaugeJudge0Id(Integer val){
            programmingLangaugeJudge0Id = val;
            return this;
        }
        public Builder languageId(ProgrammingLanguageId val) {
            languageId = val;
            return this;
        }

        public Builder grade(Double val) {
            grade = val;
            return this;
        }

        public Builder runTime(Double val) {
            runTime = val;
            return this;
        }

        public Builder memory(Double val) {
            memory = val;
            return this;
        }

        public Builder sourceCode(String val) {
            sourceCode = val;
            return this;
        }

        public Builder gradingStatus(GradingStatus val) {
            gradingStatus = val;
            return this;
        }

        public Builder aiAssessment(String val) {
            aiAssessment = val;
            return this;
        }

        public Builder sonaqueAssessment(String val) {
            sonaqueAssessment = val;
            return this;
        }

        public Builder numOfTestCase(Integer val) {
            numOfTestCase = val;
            return this;
        }

        public Builder numOfTestCaseGraded(Integer val) {
            numOfTestCaseGraded = val;
            return this;
        }

        public Builder copyState(CopyState val) {
            copyState = val;
            return this;
        }

        public Builder codeSubmissionTestCaseList(List<CodeSubmissionTestCase> val) {
            codeSubmissionTestCaseList = val;
            return this;
        }

        public Builder programmingLanguageCodeQuestion(ProgrammingLanguageCodeQuestion val) {
            programmingLanguageCodeQuestion = val;
            return this;
        }

        public Builder codeQuestionLangauge(CodeQuestionLangauge val) {
            codeQuestionLangauge = val;
            return this;
        }

        public Builder id(CodeSubmissionId val) {
            id = val;
            return this;
        }

        public CodeSubmission build() {
            return new CodeSubmission(this);
        }
    }
}
