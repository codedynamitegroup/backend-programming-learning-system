package com.backend.programming.learning.system.course.service.dataaccess.question_bank_category.entity;

import com.backend.programming.learning.system.course.service.dataaccess.question_bank.entity.QuestionBankEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "question_bank_category")
public class QuestionBankCategoryEntity {
    @Id
    @Column(name = "id")
    private UUID id;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_bank_id", referencedColumnName = "id")
    private QuestionBankEntity questionBank;

    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionBankCategoryEntity that = (QuestionBankCategoryEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
