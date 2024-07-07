package com.backend.programming.learning.system.core.service.dataaccess.chapter_resource.listener;

import com.backend.programming.learning.system.core.service.domain.dto.responseentity.chapter.ChapterResponseEntity;
import com.backend.programming.learning.system.core.service.domain.ports.output.redis.ChapterRedisService;
import jakarta.persistence.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ChapterResourceListener {
    private final ChapterRedisService chapterRedisService;

    public ChapterResourceListener(ChapterRedisService chapterRedisService) {
        this.chapterRedisService = chapterRedisService;
    }

    @PrePersist
    public void prePersist(ChapterResponseEntity chapterResponseEntity) {
        log.info("PrePersist");
    }

    @PostPersist
    public void postPersist(ChapterResponseEntity chapterResponseEntity) {
        log.info("PostPersist");
        chapterRedisService.clearAllChapters();
    }

    @PreUpdate
    public void preUpdate(ChapterResponseEntity chapterResponseEntity) {
        log.info("PreUpdate");
    }

    @PostUpdate
    public void postUpdate(ChapterResponseEntity chapterResponseEntity) {
        log.info("PostUpdate");
        chapterRedisService.clearAllChapters();
    }

    @PreRemove
    public void preRemove(ChapterResponseEntity chapterResponseEntity) {
        log.info("PreRemove");
    }

    @PostRemove
    public void postRemove(ChapterResponseEntity chapterResponseEntity) {
        log.info("PostRemove");
        chapterRedisService.clearAllChapters();
    }
}
