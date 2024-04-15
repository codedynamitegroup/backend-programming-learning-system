package com.backend.programming.learning.system.core.service.dataaccess.code_submission.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "code_submission")
@Entity
public class CodeSubmissionEntity {
    @Id
    @Column(name = "id")
    private UUID id;
    private UUID codeQuestionId;
    private UUID userId;
    private UUID programmingLanguageId;
    private String sourceCode;
    private Float grade;
    private Boolean pass;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CodeSubmissionEntity that = (CodeSubmissionEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
