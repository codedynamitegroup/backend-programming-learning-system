package com.backend.programming.learning.system.core.service.domain.ports.output.redis;

import com.backend.programming.learning.system.core.service.domain.dto.method.query.certificatecourse.QueryAllCertificateCoursesResponse;

import java.util.UUID;

public interface CertificateCourseRedisService {
    void clearAllCertificateCourses(); // clear cache
    QueryAllCertificateCoursesResponse getAllCertificateCourses(
            String courseName,
            UUID filterTopicId);
    void saveAllCertificateCourses(QueryAllCertificateCoursesResponse queryAllCertificateCoursesResponse,
                                   String courseName,
                                   UUID filterTopicId);
}
