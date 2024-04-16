package com.backend.programming.learning.system.core.service.dataaccess.topic_programminglanguage.entity;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.entity.CertificateCourseEntity;
import com.backend.programming.learning.system.core.service.dataaccess.programminglanguage.entity.ProgrammingLanguageEntity;
import com.backend.programming.learning.system.core.service.dataaccess.topic.entity.TopicEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "topic_programming_language")
@Entity
public class TopicProgrammingLanguageEntity {
    @Id
    @Column(name = "id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "topic_id", referencedColumnName = "id")
    private TopicEntity topic;

    @ManyToOne
    @JoinColumn(name = "programming_language_id", referencedColumnName = "id")
    private ProgrammingLanguageEntity programmingLanguage;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TopicProgrammingLanguageEntity that = (TopicProgrammingLanguageEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
