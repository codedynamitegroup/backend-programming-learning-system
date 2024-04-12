package com.backend.programming.learning.system.core.service.domain;

import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.event.CertificateCourseCreatedEvent;
import com.backend.programming.learning.system.core.service.domain.event.QuestionCreatedEvent;
import com.backend.programming.learning.system.core.service.domain.entity.Question;
import com.backend.programming.learning.system.domain.DomainConstants;
import lombok.extern.slf4j.Slf4j;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Slf4j
public class CoreDomainServiceImpl implements CoreDomainService {
    @Override
    public CertificateCourseCreatedEvent createCertificateCourse(CertificateCourse certificateCourse) {
        return new CertificateCourseCreatedEvent(certificateCourse, ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM)));
    }
    @Override
    public QuestionCreatedEvent createQuestion(Question question) {
        question.initializeQuestion();

        log.info("Question created with id: {}", question.getId().getValue());

        return new QuestionCreatedEvent(question, ZonedDateTime.now(ZoneId.of("UTC")));
    }
}
