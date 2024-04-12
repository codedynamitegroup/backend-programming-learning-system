package com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_user.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_topic.entity.CertificateCourseTopicEntity;
import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_user.entity.CertificateCourseUserEntity;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourseTopic;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourseUser;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseTopicId;
import com.backend.programming.learning.system.core.service.domain.valueobject.TopicId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

@Component
public class CertificateCourseUserDataAccessMapper {

    public CertificateCourseUserEntity certificateCourseUserToCertificateCourseUserEntity(
            CertificateCourseUser certificateCourseUser) {
        return CertificateCourseUserEntity.builder()
                .id(certificateCourseUser.getId().getValue())
                .certificateCourseId(certificateCourseUser.getCertificateCourseId().getValue())
                .userId(certificateCourseUser.getUserId().getValue())
                .startTime(certificateCourseUser.getStartTime())
                .isCompleted(certificateCourseUser.getCompleted())
                .completedAt(certificateCourseUser.getCompletedAt())
                .build();
    }

    public CertificateCourseUser certificateCourseUserEntityToCertificateCourseUser(
            CertificateCourseUserEntity certificateCourseUserEntity) {
        return CertificateCourseUser.builder()
                .certificateCourseId(new CertificateCourseId(certificateCourseUserEntity.getCertificateCourseId()))
                .userId(new UserId(certificateCourseUserEntity.getUserId()))
                .startTime(certificateCourseUserEntity.getStartTime())
                .isCompleted(certificateCourseUserEntity.getIsCompleted())
                .completedAt(certificateCourseUserEntity.getCompletedAt())
                .build();
    }
}
