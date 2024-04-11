package com.backend.programming.learning.system.core.service.domain;

import com.backend.programming.learning.system.core.service.domain.event.CertificateCourseCreatedEvent;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.event.QuestionCreatedEvent;
import com.backend.programming.learning.system.core.service.domain.entity.Question;

public interface CoreDomainService {
    QuestionCreatedEvent createQuestion(Question question);
    CertificateCourseCreatedEvent createCertificateCourse(CertificateCourse certificateCourse);
}
