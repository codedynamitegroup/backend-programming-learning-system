package com.backend.programming.learning.system.core.service.domain;

import com.backend.programming.learning.system.core.service.domain.entity.Question;
import com.backend.programming.learning.system.core.service.domain.event.CertificateCourseCreatedEvent;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.event.QuestionCreatedEvent;

public interface CoreDomainService {
    QuestionCreatedEvent createQuestion(Question question);
    void createCertificateCourse(CertificateCourse certificateCourse);
}
