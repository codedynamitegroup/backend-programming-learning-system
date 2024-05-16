package com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.entity;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_user.entity.CertificateCourseUserEntity;
import com.backend.programming.learning.system.core.service.dataaccess.chapter.entity.ChapterEntity;
import com.backend.programming.learning.system.core.service.dataaccess.review.entity.ReviewEntity;
import com.backend.programming.learning.system.core.service.dataaccess.topic.entity.TopicEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.core.service.domain.valueobject.SkillLevel;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Formula;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "certificate_course", schema = "public")
@Entity
public class CertificateCourseEntity {
    @Id
    @Column(name = "id")
    private UUID id;
    private String name;
    private String description;
    @Enumerated(EnumType.STRING)
    private SkillLevel skillLevel;
    private Float avgRating;

    private ZonedDateTime startTime;
    private ZonedDateTime endTime;

    @Basic(fetch = FetchType.LAZY)
    @Formula("(select count(*) from certificate_course_user ccu where ccu.certificate_course_id = id)")
    private Integer numOfStudents;

    @Basic(fetch = FetchType.LAZY)
    @Formula("(select count(*) from chapter c, chapter_question cq where c.certificate_course_id = id and c.id = cq.chapter_id)")
    private Integer numOfQuestions;

    @Basic(fetch = FetchType.LAZY)
    @Formula("(select count(*) from review r where r.certificate_course_id = id)")
    private Integer numOfReviews;

    @ManyToOne
    @JoinColumn(name = "topic_id", referencedColumnName = "id")
    private TopicEntity topic;

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
        CertificateCourseEntity that = (CertificateCourseEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
