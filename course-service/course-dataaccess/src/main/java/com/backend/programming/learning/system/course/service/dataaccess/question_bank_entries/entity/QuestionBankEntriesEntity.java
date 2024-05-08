package com.backend.programming.learning.system.course.service.dataaccess.question_bank_entries.entity;

import com.backend.programming.learning.system.course.service.dataaccess.question.entity.QuestionEntity;
import com.backend.programming.learning.system.course.service.dataaccess.question_bank_category.entity.QuestionBankCategoryEntity;
import lombok.*;

import jakarta.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "question_bank_entries")
public class QuestionBankEntriesEntity {
    @Id
    @Column(name = "id")
    private UUID id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id", referencedColumnName = "id")
    private QuestionEntity question;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_bank_category_id", referencedColumnName = "id")
    private QuestionBankCategoryEntity questionBankCategory;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionBankEntriesEntity that = (QuestionBankEntriesEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
