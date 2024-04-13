package com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.entity;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_programminglanguage.entity.CerCourseProLanguageEntity;
import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_topic.entity.CertificateCourseTopicEntity;
import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_user.entity.CertificateCourseUserEntity;
import com.backend.programming.learning.system.core.service.dataaccess.chapter.entity.ChapterEntity;
import com.backend.programming.learning.system.core.service.dataaccess.review.entity.ReviewEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.core.service.domain.valueobject.SkillLevel;
import javax.persistence.*;
import lombok.*;

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
    private Boolean isDeleted;

    @OneToMany(mappedBy = "certificateCourse")
    private List<ReviewEntity> reviews;

    @OneToMany(mappedBy = "certificateCourse")
    private List<ChapterEntity> chapters;

    @OneToMany(mappedBy = "certificateCourse")
    private List<CertificateCourseTopicEntity> certificateCourseTopics;

    @OneToMany(mappedBy = "certificateCourse")
    private List<CertificateCourseUserEntity> certificateCourseUsers;

    @OneToMany(mappedBy = "certificateCourse")
    private List<CerCourseProLanguageEntity> certificateCourseProgramingLanguages;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "created_by", referencedColumnName = "id")
    private UserEntity createdBy;

    @OneToOne(cascade = CascadeType.ALL)
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
