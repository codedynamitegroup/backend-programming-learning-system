package com.backend.programming.learning.system.course.service.domain.entity;

import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.course.service.domain.valueobject.QuestionSubmissionId;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class QuestionSubmission extends AggregateRoot<QuestionSubmissionId> {
    private User user;
    private ExamSubmission examSubmission;
    private Question question;
    private Integer passStatus;
    private Float grade;
    private String content;
    private String rightAnswer;
    private Integer numFile;

    public void initializeQuestionSubmission() {
        this.setId(new QuestionSubmissionId(UUID.randomUUID()));
    }
}
