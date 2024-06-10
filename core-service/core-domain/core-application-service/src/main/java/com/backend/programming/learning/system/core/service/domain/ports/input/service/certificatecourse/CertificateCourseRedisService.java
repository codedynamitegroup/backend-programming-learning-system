package com.backend.programming.learning.system.core.service.domain.ports.input.service.certificatecourse;

import com.backend.programming.learning.system.core.service.domain.dto.method.query.certificatecourse.QueryAllCertificateCoursesResponse;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.UUID;

public interface CertificateCourseRedisService {
    void clearAllCertificateCourses(); // clear cache
    QueryAllCertificateCoursesResponse getAllCertificateCourses(
            String courseName,
            UUID filterTopicId) throws JsonProcessingException;
    void saveAllCertificateCourses(QueryAllCertificateCoursesResponse queryAllCertificateCoursesResponse,
                                   String courseName,
                                   UUID filterTopicId);
}
