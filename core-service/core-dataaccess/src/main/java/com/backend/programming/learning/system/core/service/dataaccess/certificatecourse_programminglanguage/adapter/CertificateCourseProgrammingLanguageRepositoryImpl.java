package com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_programminglanguage.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_programminglanguage.mapper.CertificateCourseProgrammingLanguageDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_programminglanguage.repository.CertificateCourseProgrammingLanguageJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourseProgrammingLanguage;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CertificateCourseProgrammingLanguageRepository;
import org.springframework.stereotype.Component;

@Component
public class CertificateCourseProgrammingLanguageRepositoryImpl implements CertificateCourseProgrammingLanguageRepository {

    private final CertificateCourseProgrammingLanguageJpaRepository certificateCourseProgrammingLanguageJpaRepository;
    private final CertificateCourseProgrammingLanguageDataAccessMapper certificateCourseProgrammingLanguageDataAccessMapper;

    public CertificateCourseProgrammingLanguageRepositoryImpl(CertificateCourseProgrammingLanguageJpaRepository certificateCourseProgrammingLanguageJpaRepository,
                                                              CertificateCourseProgrammingLanguageDataAccessMapper certificateCourseProgrammingLanguageDataAccessMapper) {
        this.certificateCourseProgrammingLanguageJpaRepository = certificateCourseProgrammingLanguageJpaRepository;
        this.certificateCourseProgrammingLanguageDataAccessMapper = certificateCourseProgrammingLanguageDataAccessMapper;
    }

    @Override
    public CertificateCourseProgrammingLanguage saveCertificateCourseProgrammingLanguage(
            CertificateCourseProgrammingLanguage certificateCourseProgrammingLanguage) {
        return certificateCourseProgrammingLanguageDataAccessMapper.
                certificateCourseProgrammingLanguageEntityToCertificateCourseProgrammingLanguage(
                certificateCourseProgrammingLanguageJpaRepository
                        .save(certificateCourseProgrammingLanguageDataAccessMapper
                                .certificateCourseProgrammingLanguageToCertificateCourseProgrammingLanguageEntity(
                                        certificateCourseProgrammingLanguage)));
    }
}
