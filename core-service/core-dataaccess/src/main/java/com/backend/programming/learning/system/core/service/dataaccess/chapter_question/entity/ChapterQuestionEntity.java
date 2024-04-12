package com.backend.programming.learning.system.core.service.dataaccess.chapter_question.entity;

import com.backend.programming.learning.system.core.service.dataaccess.chapter.entity.ChapterEntity;
import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QuestionEntity;
import com.backend.programming.learning.system.core.service.dataaccess.review.entity.ReviewEntity;
import com.backend.programming.learning.system.core.service.dataaccess.topic.entity.TopicEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.core.service.domain.valueobject.SkillLevel;
import javax.persistence.*;
import lombok.*;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "chapter_question")
@Entity
public class ChapterQuestionEntity {
    @Id
    @Column(name = "id")
    private UUID id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "chapter_id", referencedColumnName = "id")
    ChapterEntity chapter;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id", referencedColumnName = "id")
    QuestionEntity question;

    private Float grade;
    private Boolean pass;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChapterQuestionEntity that = (ChapterQuestionEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
