package com.backend.programming.learning.system.core.service.dataaccess.question.entity;

import com.backend.programming.learning.system.core.service.dataaccess.chapter_resource.entity.ChapterResourceEntity;
import com.backend.programming.learning.system.core.service.dataaccess.organization.entity.OrganizationEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.domain.valueobject.QuestionDifficulty;
import com.backend.programming.learning.system.domain.valueobject.QuestionType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
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

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "org_id", referencedColumnName = "id")
    private OrganizationEntity organization;

    @Enumerated(EnumType.STRING)
    private QuestionDifficulty difficulty;
    private String name;
    private String questionText;
    private String generalFeedback;
    private BigDecimal defaultMark;

    @Enumerated(EnumType.STRING)
    private CopyState copyState;

    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    private UUID questionBankCategoryId;
    private Boolean isOrgQuestionBank;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "question_id")
    private List<AnswerOfQuestionEntity> answerOfQuestions;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "created_by", referencedColumnName = "id")
    private UserEntity createdBy;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "updated_by", referencedColumnName = "id")
    private UserEntity updatedBy;

    @Enumerated(EnumType.STRING)
    private QuestionType qtype;

    @OneToMany(mappedBy = "question")
    Set<ChapterResourceEntity> chapterQuestions;

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
