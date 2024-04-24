package com.backend.programming.learning.system.entity;


import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.valueobject.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
public class Question extends AggregateRoot<QuestionId> {
    private Organization organization;
    private QuestionDifficulty difficulty;
    private String name;
    private String questionText;
    private String generalFeedback;
    private float defaultMark;
    private QuestionType qtype;
    private List<String> failureMessages;
    private Boolean isQuestionBank;
    private QuestionBankCategory questionBankCategory;

    private User createdBy;
    private User updatedBy;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    public void initializeQuestion() {
        setId(new QuestionId(UUID.randomUUID()));
        setCreatedAt(ZonedDateTime.now());
        setUpdatedAt(ZonedDateTime.now());
    }
}
