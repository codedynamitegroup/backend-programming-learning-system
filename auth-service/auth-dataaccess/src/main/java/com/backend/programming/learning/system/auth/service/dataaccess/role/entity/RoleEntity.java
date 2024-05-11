package com.backend.programming.learning.system.auth.service.dataaccess.role.entity;

import jakarta.persistence.*;

import com.backend.programming.learning.system.auth.service.dataaccess.organization.entity.OrganizationEntity;
import com.backend.programming.learning.system.auth.service.dataaccess.user.entity.UserEntity;
import lombok.*;

import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "role")
@Entity
public class RoleEntity {
    @Id
    private UUID id;

    @OneToOne
    @JoinColumn(name = "created_by", referencedColumnName = "id")
    private UserEntity createdBy;

    @OneToOne
    @JoinColumn(name = "updated_by", referencedColumnName = "id")
    private UserEntity updatedBy;

    private String description;
    private String name;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleEntity that = (RoleEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
