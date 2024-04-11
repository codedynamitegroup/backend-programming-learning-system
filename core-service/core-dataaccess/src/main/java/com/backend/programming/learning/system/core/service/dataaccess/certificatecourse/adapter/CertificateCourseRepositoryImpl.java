package com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.adapter;

import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.domain.core.service.ports.output.repository.CoreRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CertificateCourseRepositoryImpl implements CoreRepository {

    @Override
    public CertificateCourse saveCertificateCourse(CertificateCourse certificateCourse) {
        return null;
    }
}
