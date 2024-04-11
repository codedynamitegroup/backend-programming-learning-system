package com.backend.programming.learning.system.core.service.domain;

<<<<<<< HEAD:core-service/core-domain/core-domain-core/src/main/java/com/backend/programming/learning/system/core/service/domain/CoreDomainServiceImpl.java
import com.backend.programming.learning.system.core.service.domain.event.CertificateCourseCreatedEvent;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
=======
import com.backend.programming.learning.system.domain.event.Question.QuestionCreatedEvent;
import com.backend.programming.learning.system.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.domain.event.CertificateCourseCreatedEvent;
>>>>>>> origin/main:core-service/core-domain/core-domain-core/src/main/java/com/backend/programming/learning/system/domain/CoreDomainServiceImpl.java
import lombok.extern.slf4j.Slf4j;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Slf4j
public class CoreDomainServiceImpl implements CoreDomainService {
    @Override
    public CertificateCourseCreatedEvent createCertificateCourse(CertificateCourse certificateCourse) {
        return new CertificateCourseCreatedEvent(certificateCourse, ZonedDateTime.now(ZoneId.of("Asis/Ho_Chi_Minh")));
    }
    @Override
    public QuestionCreatedEvent createQuestion(Question question) {
        question.initializeQuestion();

        log.info("Question created with id: {}", question.getId().getValue());

        return new QuestionCreatedEvent(question, ZonedDateTime.now(ZoneId.of("UTC")));
    }
}
