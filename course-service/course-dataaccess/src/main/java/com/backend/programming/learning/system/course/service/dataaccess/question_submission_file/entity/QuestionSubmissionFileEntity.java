package com.backend.programming.learning.system.course.service.dataaccess.question_submission_file.entity;

import com.backend.programming.learning.system.course.service.dataaccess.question_submission.entity.QuestionSubmissionEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "question_submission_file")
public class QuestionSubmissionFileEntity {
    @Id
    @Column(name = "id")
    private UUID id;

    private String url;

    @ManyToOne
    @JoinColumn(name = "question_submission_id", referencedColumnName = "id")
    private QuestionSubmissionEntity questionSubmission;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionSubmissionFileEntity that = (QuestionSubmissionFileEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
