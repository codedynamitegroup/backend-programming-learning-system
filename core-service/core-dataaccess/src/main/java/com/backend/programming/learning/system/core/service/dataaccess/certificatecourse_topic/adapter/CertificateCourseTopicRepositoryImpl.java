package com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_topic.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_topic.mapper.CertificateCourseTopicDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_topic.repository.CertificateCourseTopicJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourseProgrammingLanguage;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourseTopic;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CertificateCourseTopicRepository;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.core.service.domain.valueobject.TopicId;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CertificateCourseTopicRepositoryImpl implements CertificateCourseTopicRepository {

    private final CertificateCourseTopicJpaRepository certificateCourseTopicJpaRepository;
    private final CertificateCourseTopicDataAccessMapper certificateCourseTopicDataAccessMapper;

    public CertificateCourseTopicRepositoryImpl(CertificateCourseTopicJpaRepository certificateCourseTopicJpaRepository,
                                                CertificateCourseTopicDataAccessMapper certificateCourseTopicDataAccessMapper) {
        this.certificateCourseTopicJpaRepository = certificateCourseTopicJpaRepository;
        this.certificateCourseTopicDataAccessMapper = certificateCourseTopicDataAccessMapper;
    }

    @Override
    public CertificateCourseTopic saveCertificateCourseTopic(CertificateCourseTopic certificateCourseTopic) {
        return certificateCourseTopicDataAccessMapper.
                certificateCourseTopicEntityToCertificateCourseTopic(
                certificateCourseTopicJpaRepository.save(
                        certificateCourseTopicDataAccessMapper.
                                certificateCourseTopicToCertificateCourseTopicEntity(certificateCourseTopic)));
    }

    @Override
    public Optional<CertificateCourseTopic> findByCertificateCourseIdAndTopicId(CertificateCourseId certificateCourseId, TopicId topicId) {
        return certificateCourseTopicJpaRepository.findByCertificateCourseIdAndTopicId(
                certificateCourseId.getValue(),
                topicId.getValue())
                .map(certificateCourseTopicDataAccessMapper::certificateCourseTopicEntityToCertificateCourseTopic);
    }
}
