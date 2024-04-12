package com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_programminglanguage.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.entity.CertificateCourseEntity;
import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_programminglanguage.entity.CertificateCourseProgrammingLanguageEntity;
import com.backend.programming.learning.system.core.service.dataaccess.chapter.entity.ChapterEntity;
import com.backend.programming.learning.system.core.service.dataaccess.chapter.mapper.ChapterDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.review.entity.ReviewEntity;
import com.backend.programming.learning.system.core.service.dataaccess.review.mapper.ReviewDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.repository.UserJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourseProgrammingLanguage;
import com.backend.programming.learning.system.core.service.domain.entity.Chapter;
import com.backend.programming.learning.system.core.service.domain.entity.Review;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.domain.valueobject.ProgrammingLanguageId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CertificateCourseProgrammingLanguageDataAccessMapper {

    public CertificateCourseProgrammingLanguageEntity certificateCourseProgrammingLanguageToCertificateCourseProgrammingLanguageEntity(CertificateCourseProgrammingLanguage certificateCourseProgrammingLanguage) {
        return CertificateCourseProgrammingLanguageEntity.builder()
                .certificateCourseId(certificateCourseProgrammingLanguage.getCertificateCourseId().getValue())
                .programmingLanguageId(certificateCourseProgrammingLanguage.getProgrammingLanguageId().getValue())
                .build();
    }

    public CertificateCourseProgrammingLanguage certificateCourseProgrammingLanguageEntityToCertificateCourseProgrammingLanguage(CertificateCourseProgrammingLanguageEntity certificateCourseProgrammingLanguageEntity) {
        return CertificateCourseProgrammingLanguage.builder()
                .certificateCourseId(new CertificateCourseId(certificateCourseProgrammingLanguageEntity.getCertificateCourseId()))
                .programmingLanguageId(new ProgrammingLanguageId(certificateCourseProgrammingLanguageEntity.getProgrammingLanguageId()))
                .build();
    }
}
