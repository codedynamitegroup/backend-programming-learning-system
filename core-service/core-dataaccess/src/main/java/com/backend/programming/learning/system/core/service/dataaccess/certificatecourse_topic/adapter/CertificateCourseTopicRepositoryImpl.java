package com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_topic.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_programminglanguage.mapper.CertificateCourseProgrammingLanguageDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_programminglanguage.repository.CertificateCourseProgrammingLanguageJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_topic.mapper.CertificateCourseTopicDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_topic.repository.CertificateCourseTopicJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourseProgrammingLanguage;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourseTopic;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CertificateCourseProgrammingLanguageRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CertificateCourseTopicRepository;
import org.springframework.stereotype.Component;

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
}