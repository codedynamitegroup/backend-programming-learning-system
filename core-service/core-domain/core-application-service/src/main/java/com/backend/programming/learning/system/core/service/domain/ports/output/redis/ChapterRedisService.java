package com.backend.programming.learning.system.core.service.domain.ports.output.redis;

import com.backend.programming.learning.system.core.service.domain.dto.method.query.chapter.QueryAllChaptersResponse;

import java.util.UUID;

public interface ChapterRedisService {
    void clearAllChapters(); // clear cache
    QueryAllChaptersResponse getAllChapters(
            UUID certificateCourseId
    );
    void saveAllChapters(QueryAllChaptersResponse queryAllChaptersResponse,
                                   UUID certificateCourseId);
}
