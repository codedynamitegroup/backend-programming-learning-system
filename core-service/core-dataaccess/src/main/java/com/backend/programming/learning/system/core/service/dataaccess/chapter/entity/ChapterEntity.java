package com.backend.programming.learning.system.core.service.dataaccess.chapter.entity;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.entity.CertificateCourseEntity;
import com.backend.programming.learning.system.core.service.dataaccess.chapter_question.entity.ChapterQuestionEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.entity.UserEntity;
import javax.persistence.*;
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
@Table(name = "chapter")
@Entity
public class ChapterEntity {
    @Id
    @Column(name = "id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "certificate_course_id", referencedColumnName = "id")
    private CertificateCourseEntity certificateCourse;

    private Integer no;
    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name = "created_by", referencedColumnName = "id")
    private UserEntity createdBy;

    @ManyToOne
    @JoinColumn(name = "updated_by", referencedColumnName = "id")
    private UserEntity updatedBy;

    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    @OneToMany(mappedBy = "chapter", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    Set<ChapterQuestionEntity> chapterQuestions;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChapterEntity that = (ChapterEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
