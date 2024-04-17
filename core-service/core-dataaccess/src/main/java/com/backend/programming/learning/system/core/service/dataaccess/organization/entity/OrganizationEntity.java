package com.backend.programming.learning.system.core.service.dataaccess.organization.entity;

import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QuestionEntity;
import lombok.*;

import javax.persistence.*;
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
@Table(name = "organization")
public class OrganizationEntity {
    @Id
    @Column(name = "id")
    private UUID id;
    private String description;
    private String name;
    private String moodleUrl;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    @OneToMany(mappedBy = "organization", cascade = CascadeType.REMOVE)
    private List<QuestionEntity> questions;

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
