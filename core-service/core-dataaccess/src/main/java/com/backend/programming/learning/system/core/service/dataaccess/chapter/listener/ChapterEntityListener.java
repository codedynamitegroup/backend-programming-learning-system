package com.backend.programming.learning.system.core.service.dataaccess.chapter.listener;

import com.backend.programming.learning.system.core.service.dataaccess.chapter.entity.ChapterEntity;
import com.backend.programming.learning.system.core.service.domain.ports.output.redis.ChapterRedisService;
import jakarta.persistence.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ChapterEntityListener {
    private final ChapterRedisService chapterRedisService;

    public ChapterEntityListener(ChapterRedisService chapterRedisService) {
        this.chapterRedisService = chapterRedisService;
    }

    @PrePersist
    public void prePersist(ChapterEntity chapterEntity) {
        log.info("PrePersist");
    }

    @PostPersist
    public void postPersist(ChapterEntity chapterEntity) {
        log.info("PostPersist");
        chapterRedisService.clearAllChapters();
    }

    @PreUpdate
    public void preUpdate(ChapterEntity chapterEntity) {
        log.info("PreUpdate");
    }

    @PostUpdate
    public void postUpdate(ChapterEntity chapterEntity) {
        log.info("PostUpdate");
        chapterRedisService.clearAllChapters();
    }

    @PreRemove
    public void preRemove(ChapterEntity chapterEntity) {
        log.info("PreRemove");
    }

    @PostRemove
    public void postRemove(ChapterEntity chapterEntity) {
        log.info("PostRemove");
        chapterRedisService.clearAllChapters();
    }
}
