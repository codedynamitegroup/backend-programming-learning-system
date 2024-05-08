package com.backend.programming.learning.system.code.assessment.service.dataaccess.user.entity;

import lombok.*;

import jakarta.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user", schema = "public")
public class UserEntity {
    @Id
    @Column(name = "id")
    private UUID id;

    private String email;
    private ZonedDateTime dob;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String avatarUrl;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private Boolean isDeleted;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
