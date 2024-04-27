package com.backend.programming.learning.system.core.service.domain.implement.service.certificatecourse;

import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.entity.Chapter;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.exception.CertificateCourseNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CertificateCourseRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ChapterRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class CertificateCourseDeleteHelper {
    private final CertificateCourseRepository certificateCourseRepository;

    public CertificateCourseDeleteHelper(CertificateCourseRepository certificateCourseRepository) {
        this.certificateCourseRepository = certificateCourseRepository;
    }

    @Transactional
    public void deleteCertificateCourseById(UUID certificateCourseId) {
        int deletedRows = certificateCourseRepository.deleteCertificateCourse(certificateCourseId);
        if (deletedRows == 0) {
            log.warn("Could not delete certificate course with id: {}",
                    certificateCourseId);
            throw new CertificateCourseNotFoundException("Could not delete certificate course with id: " +
                    certificateCourseId);
        }
        log.info("Certificate course deleted with id: {}", certificateCourseId);
    }
}





















