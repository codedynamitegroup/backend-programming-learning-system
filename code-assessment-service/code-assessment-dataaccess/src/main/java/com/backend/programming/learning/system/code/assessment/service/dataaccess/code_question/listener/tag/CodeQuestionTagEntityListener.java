package com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.listener.tag;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.entity.tag.CodeQuestionTagEntity;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.redis.CodeQuestionRedisService;
import jakarta.persistence.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CodeQuestionTagEntityListener {
    private final CodeQuestionRedisService codeQuestionRedisService;

    public CodeQuestionTagEntityListener(CodeQuestionRedisService codeQuestionRedisService) {
        this.codeQuestionRedisService = codeQuestionRedisService;
    }

    @PrePersist
    public void prePersist(CodeQuestionTagEntity codeQuestionTagEntity) {
        log.info("PrePersist");
    }

    @PostPersist
    public void postPersist(CodeQuestionTagEntity codeQuestionTagEntity) {
        log.info("PostPersist");
        codeQuestionRedisService.clearAllCodeQuestions();
    }

    @PreUpdate
    public void preUpdate(CodeQuestionTagEntity codeQuestionTagEntity) {
        log.info("PreUpdate");
    }

    @PostUpdate
    public void postUpdate(CodeQuestionTagEntity codeQuestionTagEntity) {
        log.info("PostUpdate");
        codeQuestionRedisService.clearAllCodeQuestions();
    }

    @PreRemove
    public void preRemove(CodeQuestionTagEntity codeQuestionTagEntity) {
        log.info("PreRemove");
    }

    @PostRemove
    public void postRemove(CodeQuestionTagEntity codeQuestionTagEntity) {
        log.info("PostRemove");
        codeQuestionRedisService.clearAllCodeQuestions();
    }
}
