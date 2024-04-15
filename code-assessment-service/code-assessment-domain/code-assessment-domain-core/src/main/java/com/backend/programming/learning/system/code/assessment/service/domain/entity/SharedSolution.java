package com.backend.programming.learning.system.code.assessment.service.domain.entity;

import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.SharedSolutionId;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.valueobject.CodeSubmissionId;

import java.util.List;

public class SharedSolution extends AggregateRoot<SharedSolutionId> {
    private final CodeSubmissionId codeSubmissionId;
    private String sourceCode;
    private String approach;
    private String complexity;
    private Boolean isDeleted;
    private List<Comment> commentList;

    private SharedSolution(Builder builder) {
        codeSubmissionId = builder.codeSubmissionId;
        sourceCode = builder.sourceCode;
        approach = builder.approach;
        complexity = builder.complexity;
        isDeleted = builder.isDeleted;
        commentList = builder.commentList;
        super.setId(builder.id);
    }

    public static Builder builder() {
        return new Builder();
    }

    public CodeSubmissionId getCodeSubmissionId() {
        return codeSubmissionId;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public String getApproach() {
        return approach;
    }

    public String getComplexity() {
        return complexity;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public static final class Builder {
        private CodeSubmissionId codeSubmissionId;
        private String sourceCode;
        private String approach;
        private String complexity;
        private Boolean isDeleted;
        private List<Comment> commentList;
        private SharedSolutionId id;

        private Builder() {
        }

        public Builder codeSubmissionId(CodeSubmissionId val) {
            codeSubmissionId = val;
            return this;
        }

        public Builder sourceCode(String val) {
            sourceCode = val;
            return this;
        }

        public Builder approach(String val) {
            approach = val;
            return this;
        }

        public Builder complexity(String val) {
            complexity = val;
            return this;
        }

        public Builder isDeleted(Boolean val) {
            isDeleted = val;
            return this;
        }

        public Builder commentList(List<Comment> val) {
            commentList = val;
            return this;
        }

        public Builder id(SharedSolutionId val) {
            id = val;
            return this;
        }

        public SharedSolution build() {
            return new SharedSolution(this);
        }
    }
}
