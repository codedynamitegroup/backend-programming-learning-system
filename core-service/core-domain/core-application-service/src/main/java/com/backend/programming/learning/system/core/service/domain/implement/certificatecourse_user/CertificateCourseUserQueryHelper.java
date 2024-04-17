package com.backend.programming.learning.system.core.service.domain.implement.certificatecourse_user;

import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourseUser;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.exception.CertificateCourseNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CertificateCourseRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CertificateCourseUserRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class CertificateCourseUserQueryHelper {
    private final CertificateCourseUserRepository certificateCourseUserRepository;

    public CertificateCourseUserQueryHelper(CertificateCourseUserRepository certificateCourseUserRepository) {
        this.certificateCourseUserRepository = certificateCourseUserRepository;
    }

    @Transactional(readOnly = true)
    public Page<CertificateCourseUser> queryAllCertificateCourseUsers(
            UUID certificateCourseId,
            Integer pageNo,
            Integer pageSize,
            Boolean fetchAll) {
        return certificateCourseUserRepository.
                findAllByCertificateCourseId(certificateCourseId, pageNo, pageSize, fetchAll);
    }

}





















