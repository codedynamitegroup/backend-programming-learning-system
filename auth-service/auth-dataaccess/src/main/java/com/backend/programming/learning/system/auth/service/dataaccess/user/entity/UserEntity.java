package com.backend.programming.learning.system.auth.service.dataaccess.user.entity;

import com.backend.programming.learning.system.auth.service.dataaccess.organization.entity.OrganizationEntity;
import com.backend.programming.learning.system.auth.service.dataaccess.role.entity.RoleEntity;
import jakarta.persistence.*;

import com.backend.programming.learning.system.domain.valueobject.CopyState;
import lombok.*;

import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "main_user")
@Entity
public class UserEntity {
    @Id
    private UUID id;
    private String email;
    private String username;
    private ZonedDateTime dob;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String avatarUrl;
    private String refreshToken;
    private Boolean isLinkedWithGoogle;
    private Boolean isLinkedWithMicrosoft;
    private Boolean isLinkedWithSystemAccount;
    private String emailLinkedGoogle;
    private String emailLinkedMicrosoft;
    private ZonedDateTime lastLogin;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private Boolean isDeleted;
    private Integer otp;

    @ManyToOne
    @JoinColumn(name = "organization_id", referencedColumnName = "id")
    private OrganizationEntity organization;

    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    Set<RoleEntity> roles;

    private ZonedDateTime otpExpireAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
