package com.backend.programming.learning.system.code.assessment.service.domain.entity;

import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.CodeSubmissionTestCaseId;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.GradingStatus;
import com.backend.programming.learning.system.domain.DomainConstants;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.valueobject.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

public class CodeSubmission extends AggregateRoot<CodeSubmissionId> {
    private final CodeQuestion codeQuestion;
    private final User user;
    private final ProgrammingLanguageId languageId;
    private String programmingLanguageName;
    private Double grade;
    private Double runTime;
    private Double memory;
    private String sourceCode;
    private String headCode;
    private String bodyCode;
    private String tailCode;
    private GradingStatus gradingStatus;
    private String aiAssessment;
    private String sonaqueAssessment;
    private Integer numOfTestCase;
    private Integer numOfTestCaseGraded;
    private CopyState copyState;
    private List<CodeSubmissionTestCase> codeSubmissionTestCaseList;
    private ProgrammingLanguageCodeQuestion programmingLanguageCodeQuestion;
    private Integer programmingLangaugeJudge0Id;
    private String statusDescription;
    private Integer version;
    private ZonedDateTime createdAt;

    public void setNumOfTestCaseGraded(Integer numOfTestCaseGraded) {
        this.numOfTestCaseGraded = numOfTestCaseGraded;
    }

    @Override
    public String toString() {
        return "CodeSubmission{" +
                "codeQuestionId=" + codeQuestion +
                ", userId=" + user.getId().getValue() +
                ", languageId=" + languageId +
                ", grade=" + grade +
                ", runTime=" + runTime +
                ", memory=" + memory +
                ", sourceCode='" + bodyCode + '\'' +
                ", gradingStatus=" + gradingStatus +
                ", aiAssessment='" + aiAssessment + '\'' +
                ", sonaqueAssessment='" + sonaqueAssessment + '\'' +
                ", numOfTestCase=" + numOfTestCase +
                ", numOfTestCaseGraded=" + numOfTestCaseGraded +
                ", copyState=" + copyState +
                '}';
    }

    private CodeSubmission(Builder builder) {
        super.setId(builder.id);
        codeQuestion = builder.codeQuestion;
        user = builder.user;
        languageId = builder.languageId;
        programmingLanguageName = builder.programmingLanguageName;
        grade = builder.grade;
        runTime = builder.runTime;
        memory = builder.memory;
        sourceCode = builder.sourceCode;
        headCode = builder.headCode;
        bodyCode = builder.bodyCode;
        tailCode = builder.tailCode;
        setGradingStatus(builder.gradingStatus);
        aiAssessment = builder.aiAssessment;
        sonaqueAssessment = builder.sonaqueAssessment;
        numOfTestCase = builder.numOfTestCase;
        setNumOfTestCaseGraded(builder.numOfTestCaseGraded);
        copyState = builder.copyState;
        setCodeSubmissionTestCaseList(builder.codeSubmissionTestCaseList);
        setProgrammingLanguageCodeQuestion(builder.programmingLanguageCodeQuestion);
        setProgrammingLangaugeJudge0Id(builder.programmingLangaugeJudge0Id);
        setStatusDescription(builder.statusDescription);
        version = builder.version;
        createdAt = builder.createdAt;
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

    public Integer getVersion() {
        return version;
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
    public CodeQuestion getCodeQuestion() {
        return codeQuestion;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public User getUser() {
        return user;
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

    public String getHeadCode() {
        return headCode;
    }

    public String getBodyCode() {
        return bodyCode;
    }

    public String getTailCode() {
        return tailCode;
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

        if(getId() == null)
            setId(new CodeSubmissionId(UUID.randomUUID()));
        gradingStatus = GradingStatus.GRADING;
        numOfTestCase = codeSubmissionTestCaseList.size();
        numOfTestCaseGraded = 0;
        copyState = CopyState.CREATING;
        programmingLanguageCodeQuestion = plcq;
        createdAt = ZonedDateTime.now(ZoneId.of(DomainConstants.UTC));
        version = 0;
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

    public void updateAvgTimeAndMemoryAndGrade(Double avgTime, Double avgMemory, long numOfPassedTestCase) {
        runTime = avgTime;
        memory = avgMemory;
        copyState = CopyState.UPDATING;
        grade = numOfPassedTestCase == numOfTestCase? codeQuestion.getMaxGrade().doubleValue() : codeQuestion.getMaxGrade().doubleValue() * (numOfPassedTestCase * 1.0 / numOfTestCase);
    }

    public String getProgrammingLanguageName() {
        return programmingLanguageName;
    }

    public void setProgrammingLanguageName(String programmingLanguageName) {
        this.programmingLanguageName = programmingLanguageName;
    }

    public static final class Builder {
        private CodeQuestion codeQuestion;
        private User user;
        private ProgrammingLanguageId languageId;
        private String programmingLanguageName;
        private Double grade;
        private Double runTime;
        private Double memory;
        private String sourceCode;
        private String headCode;
        private String bodyCode;
        private String tailCode;
        private GradingStatus gradingStatus;
        private String aiAssessment;
        private String sonaqueAssessment;
        private Integer numOfTestCase;
        private Integer numOfTestCaseGraded;
        private CopyState copyState;
        private List<CodeSubmissionTestCase> codeSubmissionTestCaseList;
        private ProgrammingLanguageCodeQuestion programmingLanguageCodeQuestion;
        private Integer programmingLangaugeJudge0Id;
        private String statusDescription;
        private Integer version;
        private ZonedDateTime createdAt;

        private CodeQuestionLangauge codeQuestionLangauge;
        private CodeSubmissionId id;

        private Builder() {
        }

        public Builder codeQuestion(CodeQuestion val) {
            codeQuestion = val;
            return this;
        }

        public Builder user(User val) {
            user = val;
            return this;
        }

        public Builder programmingLangaugeJudge0Id(Integer val) {
            programmingLangaugeJudge0Id = val;
            return this;
        }

        public Builder statusDescription(String val) {
            statusDescription = val;
            return this;
        }

        public Builder version(Integer val) {
            version = val;
            return this;
        }

        public Builder createdAt(ZonedDateTime val) {
            createdAt = val;
            return this;
        }

        public Builder languageId(ProgrammingLanguageId val) {
            languageId = val;
            return this;
        }

        public Builder programmingLanguageName(String val) {
            programmingLanguageName = val;
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

        public Builder headCode(String val) {
            headCode = val;
            return this;
        }

        public Builder bodyCode(String val) {
            bodyCode = val;
            return this;
        }

        public Builder tailCode(String val) {
            tailCode = val;
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
