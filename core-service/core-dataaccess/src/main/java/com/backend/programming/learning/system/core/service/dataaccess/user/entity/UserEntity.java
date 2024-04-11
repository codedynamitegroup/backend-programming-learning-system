package com.backend.programming.learning.system.core.service.dataaccess.user.entity;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.entity.CertificateCourseEntity;
import com.backend.programming.learning.system.core.service.dataaccess.chapter.entity.ChapterEntity;
import com.backend.programming.learning.system.core.service.dataaccess.contest.entity.ContestEntity;
import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QuestionEntity;
import com.backend.programming.learning.system.core.service.dataaccess.review.entity.ReviewEntity;
import com.backend.programming.learning.system.core.service.dataaccess.topic.entity.TopicEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    private UUID id;

    private String email;
    private String name;
    private Date date;
    private String displayName;
    private String avatarUrl;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    @OneToOne(mappedBy = "createdBy")
    private QuestionEntity questionCreatedBy;

    @OneToOne(mappedBy = "updatedBy")
    private QuestionEntity questionUpdatedBy;

    @OneToOne(mappedBy = "createdBy")
    private CertificateCourseEntity certificateCourseCreatedBy;

    @OneToOne(mappedBy = "updatedBy")
    private CertificateCourseEntity certificateCourseUpdatedBy;

    @OneToOne(mappedBy = "createdBy")
    private TopicEntity topicCreatedBy;

    @OneToOne(mappedBy = "updatedBy")
    private TopicEntity topicUpdatedBy;

    @OneToOne(mappedBy = "createdBy")
    private ChapterEntity chapterCreatedBy;

    @OneToOne(mappedBy = "updatedBy")
    private ChapterEntity chapterUpdatedBy;

    @OneToOne(mappedBy = "createdBy")
    private ReviewEntity reviewCreatedBy;

    @OneToOne(mappedBy = "updatedBy")
    private ReviewEntity reviewUpdatedBy;

    @OneToOne(mappedBy = "createdBy")
    private ContestEntity contestCreatedBy;

    @OneToOne(mappedBy = "updatedBy")
    private ContestEntity contestUpdatedBy;
}
