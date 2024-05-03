package com.backend.programming.learning.system.auth.service.dataaccess.organization.entity;

import com.backend.programming.learning.system.auth.service.dataaccess.role.entity.RoleEntity;
import com.backend.programming.learning.system.auth.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.domain.valueobject.UserId;
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
@Table(name = "main_organization")
@Entity
public class OrganizationEntity {
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
    private String email;
    private String phone;
    private String address;
    private String apiKey;
    private String moodleUrl;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private Boolean isDeleted;

    @OneToMany(mappedBy = "organization")
    private List<RoleEntity> roles;

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
