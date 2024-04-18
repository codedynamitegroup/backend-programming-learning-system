package com.backend.programming.learning.system.code.assessment.service.dataaccess.question.entity;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.entity.CodeQuestionEntity;
import com.backend.programming.learning.system.domain.valueobject.QuestionDifficulty;
import com.backend.programming.learning.system.domain.valueobject.QuestionType;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "question")
public class QuestionEntity {
    @Id
    @Column(name = "id")
    private UUID id;

//    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
//    @JoinColumn(name = "org_id", referencedColumnName = "id")
//    private OrganizationEntity organization;
    private UUID org_id;

    @Enumerated(EnumType.STRING)
    private QuestionDifficulty difficulty;
    private String name;
    private String questionText;
    private String generalFeedback;
    private BigDecimal defaultMark;

    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    private UUID createdBy;
    private UUID updatedBy;

    @Enumerated(EnumType.STRING)
    private QuestionType qtype;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionEntity that = (QuestionEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
