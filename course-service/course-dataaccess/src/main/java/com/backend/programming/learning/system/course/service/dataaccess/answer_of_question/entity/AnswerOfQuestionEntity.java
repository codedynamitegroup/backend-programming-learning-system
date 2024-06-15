package com.backend.programming.learning.system.course.service.dataaccess.answer_of_question.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "answer_of_question")
public class AnswerOfQuestionEntity {
    @Id
    @Column(name = "id")
    private UUID id;

    private UUID questionId;
    private String feedback;
    private Float fraction;
    private String answer;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnswerOfQuestionEntity that = (AnswerOfQuestionEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
