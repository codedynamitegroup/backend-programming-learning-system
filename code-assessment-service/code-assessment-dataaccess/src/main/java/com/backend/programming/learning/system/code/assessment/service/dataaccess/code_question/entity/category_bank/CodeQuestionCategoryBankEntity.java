package com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.entity.category_bank;


import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_submission.entity.contest.CodeSubmissionContestEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="code_question_category_bank")
public class CodeQuestionCategoryBankEntity {
    @Id
    private UUID codeQuestionId;

    private UUID categoryBankId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CodeQuestionCategoryBankEntity that = (CodeQuestionCategoryBankEntity) o;
        return Objects.equals(codeQuestionId, that.codeQuestionId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codeQuestionId);
    }
}
