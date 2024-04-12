package com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_user.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "certificate_course_user")
@Entity
public class CertificateCourseUserEntity {
    @Id
    @Column(name = "id")
    private UUID id;
    private UUID userId;
    private UUID certificateCourseId;
    private ZonedDateTime startTime;
    private Boolean isCompleted;
    private ZonedDateTime completedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CertificateCourseUserEntity that = (CertificateCourseUserEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
