package com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.entity;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.entity.CodeQuestionEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.user.entity.UserEntity;
import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="shared_solution")
public class SharedSolutionEntity {
    @Id
    UUID id;

    @ManyToOne
    @JoinColumn(name="code_question_id", referencedColumnName = "id")
    private CodeQuestionEntity codeQuestion;

    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private UserEntity user;

    Integer viewNumber;
    String content;
    String title;

    ZonedDateTime createdAt;
    ZonedDateTime updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SharedSolutionEntity that = (SharedSolutionEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
