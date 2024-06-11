package com.backend.programming.learning.system.core.service.dataaccess.contest.listener;

import com.backend.programming.learning.system.core.service.dataaccess.chapter_resource_user.entity.ChapterResourceUserEntity;
import com.backend.programming.learning.system.core.service.dataaccess.contest.entity.ContestEntity;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.chapter.ChapterRedisService;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.contest.ContestRedisService;
import jakarta.persistence.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContestListener {
    private final ContestRedisService contestRedisService;

    public ContestListener(ContestRedisService contestRedisService) {
        this.contestRedisService = contestRedisService;
    }

    @PrePersist
    public void prePersist(ContestEntity contestEntity) {
        log.info("PrePersist");
    }

    @PostPersist
    public void postPersist(ContestEntity contestEntity) {
        log.info("PostPersist");
        contestRedisService.clearAllContests();
    }

    @PreUpdate
    public void preUpdate(ContestEntity contestEntity) {
        log.info("PreUpdate");
    }

    @PostUpdate
    public void postUpdate(ContestEntity contestEntity) {
        log.info("PostUpdate");
        contestRedisService.clearAllContests();
    }

    @PreRemove
    public void preRemove(ContestEntity contestEntity) {
        log.info("PreRemove");
    }

    @PostRemove
    public void postRemove(ContestEntity contestEntity) {
        log.info("PostRemove");
        contestRedisService.clearAllContests();
    }
}
