package com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_topic.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "certificate_course_topic")
@Entity
public class CertificateCourseTopicEntity {
    @Id
    @Column(name = "id")
    private UUID id;
    private UUID certificateCourseId;
    private UUID topicId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CertificateCourseTopicEntity that = (CertificateCourseTopicEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
