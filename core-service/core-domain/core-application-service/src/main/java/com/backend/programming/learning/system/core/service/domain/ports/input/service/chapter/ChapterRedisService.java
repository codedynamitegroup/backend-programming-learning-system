package com.backend.programming.learning.system.core.service.domain.ports.input.service.chapter;

import com.backend.programming.learning.system.core.service.domain.dto.method.query.certificatecourse.QueryAllCertificateCoursesResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.chapter.QueryAllChaptersResponse;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.UUID;

public interface ChapterRedisService {
    void clearAllChapters(); // clear cache
    QueryAllChaptersResponse getAllChapters(
            UUID certificateCourseId
    );
    void saveAllChapters(QueryAllChaptersResponse queryAllChaptersResponse,
                                   UUID certificateCourseId);
}
