package com.backend.programming.learning.system.course.service.dataaccess.question_bank_category.entity;

import com.backend.programming.learning.system.course.service.dataaccess.user.entity.UserEntity;
import lombok.*;

import jakarta.persistence.*;
import java.time.ZonedDateTime;
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

    private String name;
    private String description;

    private Boolean isOrgQuestionBank;

    @OneToOne
    @JoinColumn(name = "created_by", referencedColumnName = "id")
    private UserEntity createdBy;

    @OneToOne
    @JoinColumn(name = "updated_by", referencedColumnName = "id")
    private UserEntity updatedBy;

    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

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
