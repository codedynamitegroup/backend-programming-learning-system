package com.backend.programming.learning.system.core.service.dataaccess.contest_question.entity;

import com.backend.programming.learning.system.core.service.dataaccess.chapter.entity.ChapterEntity;
import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QuestionEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contest_question")
@Entity
public class ContestQuestionEntity {
    @Id
    @Column(name = "id")
    private UUID id;
    private UUID contestId;
    private UUID questionId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContestQuestionEntity that = (ContestQuestionEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
