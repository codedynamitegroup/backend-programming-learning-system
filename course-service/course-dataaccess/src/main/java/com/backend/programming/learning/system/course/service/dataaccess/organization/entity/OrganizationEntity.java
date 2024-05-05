package com.backend.programming.learning.system.course.service.dataaccess.organization.entity;

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
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "organization", schema = "public")
public class OrganizationEntity {
    @Id
    @Column(name = "id")
    private UUID id;

    private String name;

    private String description;

    @Column(name = "api_key")
    private String apiKey;

    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    private String moodleUrl;
    private Boolean isDeleted;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrganizationEntity that = (OrganizationEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
