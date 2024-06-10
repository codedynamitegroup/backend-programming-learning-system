package com.backend.programming.learning.system.core.service.dataaccess.chapter_resource_user.listener;

import com.backend.programming.learning.system.core.service.dataaccess.chapter_resource_user.entity.ChapterResourceUserEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.chapter.ChapterResponseEntity;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.chapter.ChapterRedisService;
import jakarta.persistence.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ChapterResourceUserListener {
    private final ChapterRedisService chapterRedisService;

    public ChapterResourceUserListener(ChapterRedisService chapterRedisService) {
        this.chapterRedisService = chapterRedisService;
    }

    @PrePersist
    public void prePersist(ChapterResourceUserEntity chapterResourceUserEntity) {
        log.info("PrePersist");
    }

    @PostPersist
    public void postPersist(ChapterResourceUserEntity chapterResourceUserEntity) {
        log.info("PostPersist");
        chapterRedisService.clearAllChapters();
    }

    @PreUpdate
    public void preUpdate(ChapterResourceUserEntity chapterResourceUserEntity) {
        log.info("PreUpdate");
    }

    @PostUpdate
    public void postUpdate(ChapterResourceUserEntity chapterResourceUserEntity) {
        log.info("PostUpdate");
        chapterRedisService.clearAllChapters();
    }

    @PreRemove
    public void preRemove(ChapterResourceUserEntity chapterResourceUserEntity) {
        log.info("PreRemove");
    }

    @PostRemove
    public void postRemove(ChapterResourceUserEntity chapterResourceUserEntity) {
        log.info("PostRemove");
        chapterRedisService.clearAllChapters();
    }
}
