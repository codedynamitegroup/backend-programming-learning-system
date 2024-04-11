package com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.adapter;

import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CertificateCourseRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CertificateCourseRepositoryImpl implements CertificateCourseRepository {

    @Override
    public CertificateCourse saveCertificateCourse(CertificateCourse certificateCourse) {
        return null;
    }
}
