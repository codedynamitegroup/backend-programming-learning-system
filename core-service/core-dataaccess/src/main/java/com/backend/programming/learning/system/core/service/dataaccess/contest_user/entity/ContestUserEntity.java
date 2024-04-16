package com.backend.programming.learning.system.core.service.dataaccess.contest_user.entity;

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
@Table(name = "contest_user")
@Entity
public class ContestUserEntity {
    @Id
    @Column(name = "id")
    private UUID id;
    private UUID userId;
    private UUID contestId;
    private Boolean isCompleted;
    private ZonedDateTime completedAt;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContestUserEntity that = (ContestUserEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
