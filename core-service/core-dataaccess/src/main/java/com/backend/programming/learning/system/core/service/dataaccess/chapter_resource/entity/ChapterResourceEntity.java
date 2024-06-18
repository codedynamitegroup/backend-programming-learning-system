package com.backend.programming.learning.system.core.service.dataaccess.chapter_resource.entity;

import com.backend.programming.learning.system.core.service.dataaccess.chapter.entity.ChapterEntity;
import com.backend.programming.learning.system.core.service.dataaccess.chapter.listener.ChapterEntityListener;
import com.backend.programming.learning.system.core.service.dataaccess.chapter_resource.listener.ChapterResourceListener;
import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QuestionEntity;
import com.backend.programming.learning.system.core.service.domain.valueobject.ResourceType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "chapter_resource")
@Entity
public class ChapterResourceEntity {
    @Id
    @Column(name = "id")
    private UUID id;
    private Integer no;
    @ManyToOne
    @JoinColumn(name = "chapter_id", referencedColumnName = "id")
    ChapterEntity chapter;
    @Enumerated(EnumType.STRING)
    private ResourceType resourceType;
    private String title;
    private String lessonHtml;
    private String youtubeVideoUrl;
    @ManyToOne
    @JoinColumn(name = "question_id", referencedColumnName = "id")
    QuestionEntity question;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChapterResourceEntity that = (ChapterResourceEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
