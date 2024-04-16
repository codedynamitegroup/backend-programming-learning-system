package com.backend.programming.learning.system.course.service.dataaccess.question.entity;

import com.backend.programming.learning.system.course.service.dataaccess.organization.entity.OrganizationEntity;
import com.backend.programming.learning.system.course.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.domain.valueobject.QuestionDifficulty;
import com.backend.programming.learning.system.domain.valueobject.QuestionType;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Objects;
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "org_id", referencedColumnName = "id")
    private OrganizationEntity organization;

    @Enumerated(EnumType.STRING)
    private QuestionDifficulty difficulty;
    private String name;
    private String questionText;
    private String generalFeedback;
    private Float defaultMark;

    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "created_by", referencedColumnName = "id")
    private UserEntity createdBy;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "updated_by", referencedColumnName = "id")
    private UserEntity updatedBy;

    @Enumerated(EnumType.STRING)
    private QuestionType qtype;

    @Enumerated(EnumType.STRING)
    private QuestionDifficulty qdifficulty;


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
