package com.backend.programming.learning.system.entity;

import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.valueobject.QuestionBankCategoryId;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
public class QuestionBankCategory extends AggregateRoot<QuestionBankCategoryId> {
    private String name;
    private User createdBy;
    private User updatedBy;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    public void initializeQuestionBankCategory() {
        this.setId(new QuestionBankCategoryId(UUID.randomUUID()));
        this.setCreatedAt(ZonedDateTime.now());
        this.setUpdatedAt(ZonedDateTime.now());
    }
}
