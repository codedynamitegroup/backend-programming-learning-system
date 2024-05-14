package com.backend.programming.learning.system.core.service.dataaccess.topic.entity;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.entity.CertificateCourseEntity;
import com.backend.programming.learning.system.core.service.dataaccess.programminglanguage.entity.ProgrammingLanguageEntity;
import com.backend.programming.learning.system.core.service.dataaccess.topic_programminglanguage.entity.TopicProgrammingLanguageEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.core.service.domain.entity.ProgrammingLanguage;
import jakarta.persistence.*;

import com.backend.programming.learning.system.core.service.domain.entity.TopicProgrammingLanguage;
import lombok.*;
import org.hibernate.annotations.Formula;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "topic")
@Entity
public class TopicEntity {
    @Id
    @Column(name = "id")
    private UUID id;
    private String name;
    private String description;
    private String thumbnailUrl;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
    private List<TopicProgrammingLanguageEntity> topicProgrammingLanguages;

    @Basic(fetch = FetchType.LAZY)
    @Formula("(select count(*) from certificate_course cc where cc.topic_id = id)")
    private Integer numOfCertificateCourses;

    @ManyToOne
    @JoinColumn(name = "created_by", referencedColumnName = "id")
    private UserEntity createdBy;

    @ManyToOne
    @JoinColumn(name = "updated_by", referencedColumnName = "id")
    private UserEntity updatedBy;

    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TopicEntity that = (TopicEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
