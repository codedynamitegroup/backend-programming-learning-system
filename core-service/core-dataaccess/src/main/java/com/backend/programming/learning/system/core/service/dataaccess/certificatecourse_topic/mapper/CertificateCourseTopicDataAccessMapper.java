package com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_topic.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.entity.CertificateCourseEntity;
import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.repository.CertificateCourseJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_topic.entity.CertificateCourseTopicEntity;
import com.backend.programming.learning.system.core.service.dataaccess.topic.entity.TopicEntity;
import com.backend.programming.learning.system.core.service.dataaccess.topic.repository.TopicJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourseTopic;
import com.backend.programming.learning.system.core.service.domain.exception.CertificateCourseNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.TopicNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseTopicId;
import com.backend.programming.learning.system.core.service.domain.valueobject.TopicId;
import org.springframework.stereotype.Component;

@Component
public class CertificateCourseTopicDataAccessMapper {
    private final CertificateCourseJpaRepository certificateCourseJpaRepository;
    private final TopicJpaRepository topicJpaRepository;

    public CertificateCourseTopicDataAccessMapper(CertificateCourseJpaRepository certificateCourseJpaRepository,
                                                  TopicJpaRepository topicJpaRepository) {
        this.certificateCourseJpaRepository = certificateCourseJpaRepository;
        this.topicJpaRepository = topicJpaRepository;
    }


    public CertificateCourseTopicEntity certificateCourseTopicToCertificateCourseTopicEntity(
            CertificateCourseTopic certificateCourseTopic) {
        CertificateCourseEntity certificateCourse = certificateCourseJpaRepository
                .findById(certificateCourseTopic.getCertificateCourseId().getValue())
                .orElseThrow(() -> new CertificateCourseNotFoundException("Certificate course with id: " +
                        certificateCourseTopic.getCertificateCourseId().getValue() + " could not be found!")
                );

        TopicEntity topic = topicJpaRepository
                .findById(certificateCourseTopic.getTopicId().getValue())
                .orElseThrow(() -> new TopicNotFoundException("Topic with id: " +
                        certificateCourseTopic.getTopicId().getValue() + " could not be found!")
                );

        return CertificateCourseTopicEntity.builder()
                .id(certificateCourseTopic.getId().getValue())
                .certificateCourse(certificateCourse)
                .topic(topic)
                .build();
    }

    public CertificateCourseTopic certificateCourseTopicEntityToCertificateCourseTopic(
            CertificateCourseTopicEntity certificateCourseTopicEntity) {
        return CertificateCourseTopic.builder()
                .id(new CertificateCourseTopicId(certificateCourseTopicEntity.getId()))
                .certificateCourseId(new CertificateCourseId(
                        certificateCourseTopicEntity.getCertificateCourse().getId()))
                .topicId(new TopicId(certificateCourseTopicEntity.getTopic().getId()))
                .build();
    }
}
