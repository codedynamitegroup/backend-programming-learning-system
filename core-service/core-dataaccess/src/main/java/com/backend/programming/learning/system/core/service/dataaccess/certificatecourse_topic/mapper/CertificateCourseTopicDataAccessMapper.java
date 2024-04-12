package com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_topic.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_topic.entity.CertificateCourseTopicEntity;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourseTopic;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseTopicId;
import com.backend.programming.learning.system.core.service.domain.valueobject.TopicId;
import org.springframework.stereotype.Component;

@Component
public class CertificateCourseTopicDataAccessMapper {

    public CertificateCourseTopicEntity certificateCourseTopicToCertificateCourseTopicEntity(
            CertificateCourseTopic certificateCourseTopic) {
        return CertificateCourseTopicEntity.builder()
                .id(certificateCourseTopic.getId().getValue())
                .certificateCourseId(certificateCourseTopic.getCertificateCourseId().getValue())
                .topicId(certificateCourseTopic.getTopicId().getValue())
                .build();
    }

    public CertificateCourseTopic certificateCourseTopicEntityToCertificateCourseTopic(
            CertificateCourseTopicEntity certificateCourseTopicEntity) {
        return CertificateCourseTopic.builder()
                .id(new CertificateCourseTopicId(certificateCourseTopicEntity.getId()))
                .certificateCourseId(new CertificateCourseId(certificateCourseTopicEntity.getCertificateCourseId()))
                .topicId(new TopicId(certificateCourseTopicEntity.getTopicId()))
                .build();
    }
}
