package com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_programminglanguage.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.entity.CertificateCourseEntity;
import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.repository.CertificateCourseJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_programminglanguage.entity.CertificateCourseProgrammingLanguageEntity;
import com.backend.programming.learning.system.core.service.dataaccess.programminglanguage.entity.ProgrammingLanguageEntity;
import com.backend.programming.learning.system.core.service.dataaccess.programminglanguage.repository.ProgrammingLanguageJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourseProgrammingLanguage;
import com.backend.programming.learning.system.core.service.domain.exception.CertificateCourseNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.ProgrammingLanguageNotFoundException;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.domain.valueobject.ProgrammingLanguageId;
import org.springframework.stereotype.Component;

@Component
public class CertificateCourseProgrammingLanguageDataAccessMapper {

    private final CertificateCourseJpaRepository certificateCourseJpaRepository;
    private final ProgrammingLanguageJpaRepository programmingLanguageJpaRepository;

    public CertificateCourseProgrammingLanguageDataAccessMapper(CertificateCourseJpaRepository certificateCourseJpaRepository,
                                                                ProgrammingLanguageJpaRepository programmingLanguageJpaRepository) {
        this.certificateCourseJpaRepository = certificateCourseJpaRepository;
        this.programmingLanguageJpaRepository = programmingLanguageJpaRepository;
    }

    public CertificateCourseProgrammingLanguageEntity certificateCourseProgrammingLanguageToCertificateCourseProgrammingLanguageEntity(
            CertificateCourseProgrammingLanguage certificateCourseProgrammingLanguage) {
        CertificateCourseEntity certificateCourse = certificateCourseJpaRepository
                .findById(certificateCourseProgrammingLanguage.getCertificateCourseId().getValue())
                .orElseThrow(() -> new CertificateCourseNotFoundException("Certificate course with id: " +
                        certificateCourseProgrammingLanguage.getCertificateCourseId().getValue() + " could not be found!")
                );

        ProgrammingLanguageEntity programmingLanguage = programmingLanguageJpaRepository
                .findById(certificateCourseProgrammingLanguage.getProgrammingLanguageId().getValue())
                .orElseThrow(() -> new ProgrammingLanguageNotFoundException("Programming language with id: " +
                        certificateCourseProgrammingLanguage.getProgrammingLanguageId().getValue() + " could not be found!")
                );

        return CertificateCourseProgrammingLanguageEntity.builder()
                .certificateCourse(certificateCourse)
                .programmingLanguage(programmingLanguage)
                .build();
    }

    public CertificateCourseProgrammingLanguage certificateCourseProgrammingLanguageEntityToCertificateCourseProgrammingLanguage(CertificateCourseProgrammingLanguageEntity certificateCourseProgrammingLanguageEntity) {
        return CertificateCourseProgrammingLanguage.builder()
                .certificateCourseId(new CertificateCourseId(certificateCourseProgrammingLanguageEntity.getCertificateCourse().getId()))
                .programmingLanguageId(new ProgrammingLanguageId(certificateCourseProgrammingLanguageEntity.getProgrammingLanguage().getId()))
                .build();
    }
}
