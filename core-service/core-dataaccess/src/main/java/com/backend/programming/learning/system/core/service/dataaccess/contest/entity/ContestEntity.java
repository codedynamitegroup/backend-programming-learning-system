package com.backend.programming.learning.system.core.service.dataaccess.contest.entity;

import com.backend.programming.learning.system.core.service.dataaccess.contest.listener.ContestListener;
import com.backend.programming.learning.system.core.service.dataaccess.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Formula;

import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contest")
@Entity
@EntityListeners(ContestListener.class)
public class ContestEntity {
    @Id
    @Column(name = "id")
    private UUID id;

    private String name;
    private String description;
    private String prizes;
    private String rules;
    private String scoring;
    private String thumbnailUrl;
    private ZonedDateTime startTime;
    private ZonedDateTime endTime;
    private Boolean isPublic;
    private Boolean isRestrictedForum;
    private Boolean isDisabledForum;

    @ManyToOne
    @JoinColumn(name = "created_by", referencedColumnName = "id")
    private UserEntity createdBy;

    @ManyToOne
    @JoinColumn(name = "updated_by", referencedColumnName = "id")
    private UserEntity updatedBy;

    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContestEntity that = (ContestEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
