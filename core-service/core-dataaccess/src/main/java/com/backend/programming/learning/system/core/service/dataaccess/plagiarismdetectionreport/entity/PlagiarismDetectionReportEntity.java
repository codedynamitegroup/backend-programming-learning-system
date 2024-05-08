package com.backend.programming.learning.system.core.service.dataaccess.plagiarismdetectionreport.entity;

import com.backend.programming.learning.system.core.service.dataaccess.programminglanguage.entity.ProgrammingLanguageEntity;
import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QuestionEntity;
import com.backend.programming.learning.system.core.service.domain.valueobject.PlagiarismDetectionReportStatus;
import lombok.*;

import jakarta.persistence.*;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "plagiarism_detection_report")
@Entity
public class PlagiarismDetectionReportEntity {
    @Id
    @Column(name = "id")
    private UUID id;
    private String name;
    private UUID examId;
    @ManyToOne
    @JoinColumn(name = "programming_language_id", referencedColumnName = "id")
    private ProgrammingLanguageEntity programmingLanguage;
    @ManyToOne
    @JoinColumn(name = "question_id", referencedColumnName = "id")
    private QuestionEntity question;
    @Enumerated(EnumType.STRING)
    private PlagiarismDetectionReportStatus status;
    private String comparedExamIds;
    private String pairsJsonContent;
    private ZonedDateTime createdAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlagiarismDetectionReportEntity that = (PlagiarismDetectionReportEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
