package com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_programminglanguage.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_programminglanguage.mapper.CerCourseProLanguageDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_programminglanguage.repository.CerCourseProLanguageJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourseProgrammingLanguage;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CertificateCourseProgrammingLanguageRepository;
import org.springframework.stereotype.Component;

@Component
public class CerCourseProLanguageRepositoryImpl implements CertificateCourseProgrammingLanguageRepository {

    private final CerCourseProLanguageJpaRepository cerCourseProLanguageJpaRepository;
    private final CerCourseProLanguageDataAccessMapper cerCourseProLanguageDataAccessMapper;

    public CerCourseProLanguageRepositoryImpl(CerCourseProLanguageJpaRepository cerCourseProLanguageJpaRepository,
                                              CerCourseProLanguageDataAccessMapper cerCourseProLanguageDataAccessMapper) {
        this.cerCourseProLanguageJpaRepository = cerCourseProLanguageJpaRepository;
        this.cerCourseProLanguageDataAccessMapper = cerCourseProLanguageDataAccessMapper;
    }

    @Override
    public CertificateCourseProgrammingLanguage saveCertificateCourseProgrammingLanguage(
            CertificateCourseProgrammingLanguage certificateCourseProgrammingLanguage) {
        return cerCourseProLanguageDataAccessMapper.
                certificateCourseProgrammingLanguageEntityToCertificateCourseProgrammingLanguage(
                cerCourseProLanguageJpaRepository
                        .save(cerCourseProLanguageDataAccessMapper
                                .certificateCourseProgrammingLanguageToCertificateCourseProgrammingLanguageEntity(
                                        certificateCourseProgrammingLanguage)));
    }
}
