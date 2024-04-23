package com.backend.programming.learning.system.entity;

import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.valueobject.ExamSubmissionId;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class ExamSubmission extends AggregateRoot<ExamSubmissionId> {
    private Exam exam;
    private User user;
    private String type;
    private Integer passStatus;

    public void initializeExamSubmission() {
        this.setId(new ExamSubmissionId(UUID.randomUUID()));
    }
}
