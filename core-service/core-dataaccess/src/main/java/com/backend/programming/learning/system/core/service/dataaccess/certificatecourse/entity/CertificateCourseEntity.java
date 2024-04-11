package com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "certificate_course")
@Entity
public class CertificateCourseEntity {
    @Id
    private UUID id;
    private String name;
    private String description;
    @Enumerated(EnumType.STRING)
    private String skill_level;
    private Float avg_rating;
    private UUID topic_id;
    private LocalDateTime start_time;
    private LocalDateTime end_time;
    private Boolean is_deleted;
    private UUID created_by;
    private UUID updated_by;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private String failureMessages;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CertificateCourseEntity that = (CertificateCourseEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
