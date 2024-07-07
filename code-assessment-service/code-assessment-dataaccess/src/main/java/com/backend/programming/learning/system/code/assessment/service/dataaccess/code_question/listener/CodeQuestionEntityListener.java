package com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.listener;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.entity.CodeQuestionEntity;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.input.service.CodeQuestionRedisService;
import jakarta.persistence.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CodeQuestionEntityListener {
    private final CodeQuestionRedisService codeQuestionRedisService;

    public CodeQuestionEntityListener(CodeQuestionRedisService codeQuestionRedisService) {
        this.codeQuestionRedisService = codeQuestionRedisService;
    }

    @PrePersist
    public void prePersist(CodeQuestionEntity codeQuestionEntity) {
        log.info("PrePersist");
    }

    @PostPersist
    public void postPersist(CodeQuestionEntity codeQuestionEntity) {
        log.info("PostPersist");
        codeQuestionRedisService.clearAllCodeQuestions();
    }

    @PreUpdate
    public void preUpdate(CodeQuestionEntity codeQuestionEntity) {
        log.info("PreUpdate");
    }

    @PostUpdate
    public void postUpdate(CodeQuestionEntity codeQuestionEntity) {
        log.info("PostUpdate");
        codeQuestionRedisService.clearAllCodeQuestions();
    }

    @PreRemove
    public void preRemove(CodeQuestionEntity codeQuestionEntity) {
        log.info("PreRemove");
    }

    @PostRemove
    public void postRemove(CodeQuestionEntity codeQuestionEntity) {
        log.info("PostRemove");
        codeQuestionRedisService.clearAllCodeQuestions();
    }
}
