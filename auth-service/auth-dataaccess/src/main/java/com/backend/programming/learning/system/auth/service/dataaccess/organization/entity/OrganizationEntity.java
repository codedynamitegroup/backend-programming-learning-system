package com.backend.programming.learning.system.auth.service.dataaccess.organization.entity;

import com.backend.programming.learning.system.domain.valueobject.UserId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "main_organization")
@Entity
public class OrganizationEntity {
    @Id
    private UUID id;
    private UUID createdBy;
    private UUID updatedBy;
    private String description;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String apiKey;
    private String moodleUrl;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private Boolean isDeleted;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrganizationEntity that = (OrganizationEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}