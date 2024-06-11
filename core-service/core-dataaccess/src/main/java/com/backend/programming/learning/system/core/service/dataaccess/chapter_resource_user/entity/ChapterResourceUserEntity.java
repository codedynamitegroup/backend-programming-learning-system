package com.backend.programming.learning.system.core.service.dataaccess.chapter_resource_user.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "chapter_resource_user")
@Entity
public class ChapterResourceUserEntity {
    @Id
    @Column(name = "id")
    private UUID id;
    private UUID chapterResourceId;
    private UUID userId;
    private Boolean isViewed;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChapterResourceUserEntity that = (ChapterResourceUserEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
