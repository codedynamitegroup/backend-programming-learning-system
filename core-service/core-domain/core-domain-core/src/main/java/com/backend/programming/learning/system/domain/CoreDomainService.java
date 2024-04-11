package com.backend.programming.learning.system.domain;

import com.backend.programming.learning.system.domain.entity.Question;
import com.backend.programming.learning.system.domain.event.Question.QuestionCreatedEvent;

import com.backend.programming.learning.system.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.domain.event.CertificateCourseCreatedEvent;

public interface CoreDomainService {
    QuestionCreatedEvent createQuestion(Question question);
    CertificateCourseCreatedEvent createCertificateCourse(CertificateCourse certificateCourse);
}
