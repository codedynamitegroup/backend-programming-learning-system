package com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.entity.tag;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.entity.CodeQuestionEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.entity.SharedSolutionEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.entity.tag.SharedSolutionTagEntityId;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.tag.entity.TagEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tag_code_question")
@IdClass(CodeQuestionTagEntityId.class)
public class CodeQuestionTagEntity {
    @Id
    @ManyToOne
    @JoinColumn(name = "code_question_id", referencedColumnName = "id")
    CodeQuestionEntity codeQuestion;

    @Id
    @ManyToOne
    @JoinColumn(name = "tag_id", referencedColumnName = "id")
    TagEntity tag;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CodeQuestionTagEntity that = (CodeQuestionTagEntity) o;
        return Objects.equals(codeQuestion, that.codeQuestion) && Objects.equals(tag, that.tag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeQuestion, tag);
    }
}