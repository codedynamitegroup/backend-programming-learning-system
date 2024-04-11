package com.backend.programming.learning.system.auth.service.dataaccess.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "credit_entry")
@Entity
public class UserEntity {
    @Id
    private UUID id;
    private String email;
    private String password;
    private LocalDateTime dob;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String avatarUrl;
    private String refreshToken;
    private String lastIp;
    private ZonedDateTime lastLogin;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private boolean isDeleted;

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
