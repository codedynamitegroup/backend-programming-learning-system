package com.backend.programming.learning.system.course.service.domain.entity;

import com.backend.programming.learning.system.course.service.domain.valueobject.AssignmentAIGradeReportId;
import com.backend.programming.learning.system.course.service.domain.valueobject.CalendarEventId;
import com.backend.programming.learning.system.domain.DomainConstants;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.valueobject.AssignmentAIGradeReportStatus;
import com.backend.programming.learning.system.domain.valueobject.UserId;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

public class AssignmentAIGradeReport extends AggregateRoot<AssignmentAIGradeReportId> {
    private AssignmentAIGradeReportStatus status;

    private String question;
    private String studentSubmissions;
    private String feedbackSubmissions;
    private String feedbackLanguage;

    private RubricUser rubricUser;
    private Assignment assignment;
    private ZonedDateTime createdAt;

    public void initializeAssignmentAIGradeReport() {
        setId(new AssignmentAIGradeReportId(UUID.randomUUID()));
        createdAt = ZonedDateTime.now(ZoneId.of(DomainConstants.UTC));
        status = AssignmentAIGradeReportStatus.PENDING;
    }

    private AssignmentAIGradeReport(Builder builder) {
        super.setId(builder.assignmentAIGradeReportId);
        setStatus(builder.status);
        setQuestion(builder.question);
        setStudentSubmissions(builder.studentSubmissions);
        setFeedbackSubmissions(builder.feedbackSubmissions);
        setRubricUser(builder.rubricUser);
        setCreatedAt(builder.createdAt);
        setFeedbackLanguage(builder.feedbackLanguage);
        setAssignment(builder.assignment);
    }

    public AssignmentAIGradeReportStatus getStatus() {
        return status;
    }

    public void setStatus(AssignmentAIGradeReportStatus status) {
        this.status = status;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getStudentSubmissions() {
        return studentSubmissions;
    }

    public void setStudentSubmissions(String studentSubmissions) {
        this.studentSubmissions = studentSubmissions;
    }

    public String getFeedbackSubmissions() {
        return feedbackSubmissions;
    }

    public void setFeedbackSubmissions(String feedbackSubmissions) {
        this.feedbackSubmissions = feedbackSubmissions;
    }

    public RubricUser getRubricUser() {
        return rubricUser;
    }

    public void setRubricUser(RubricUser rubricUser) {
        this.rubricUser = rubricUser;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getFeedbackLanguage() {
        return feedbackLanguage;
    }

    public void setFeedbackLanguage(String feedbackLanguage) {
        this.feedbackLanguage = feedbackLanguage;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static final class Builder {
        private AssignmentAIGradeReportId assignmentAIGradeReportId;
        private AssignmentAIGradeReportStatus status;
        private String question;
        private String studentSubmissions;
        private String feedbackSubmissions;
        private String feedbackLanguage;
        private RubricUser rubricUser;
        private Assignment assignment;
        private ZonedDateTime createdAt;

        private Builder() {
        }

        public Builder id(AssignmentAIGradeReportId val) {
            assignmentAIGradeReportId = val;
            return this;
        }

        public Builder status(AssignmentAIGradeReportStatus val) {
            status = val;
            return this;
        }

        public Builder question(String val) {
            question = val;
            return this;
        }

        public Builder studentSubmissions(String val) {
            studentSubmissions = val;
            return this;
        }

        public Builder feedbackSubmissions(String val) {
            feedbackSubmissions = val;
            return this;
        }

        public Builder feedbackLanguage(String val) {
            feedbackLanguage = val;
            return this;
        }

        public Builder rubricUser(RubricUser val) {
            rubricUser = val;
            return this;
        }

        public Builder assignment(Assignment val) {
            assignment = val;
            return this;
        }

        public Builder createdAt(ZonedDateTime val) {
            createdAt = val;
            return this;
        }

        public AssignmentAIGradeReport build() {
            return new AssignmentAIGradeReport(this);
        }
    }
}
