package com.backend.programming.learning.system.core.service.domain;

import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeCodeQuestion;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeEssayQuestion;
import com.backend.programming.learning.system.core.service.domain.entity.Question;
import com.backend.programming.learning.system.core.service.domain.event.QuestionCreatedEvent;

public interface CoreDomainService {
    QuestionCreatedEvent createQuestion(Question question);
    void createQtypeCodeQuestion(QtypeCodeQuestion qtypeCodeQuestion);
    void createQtypeEssayQuestion(QtypeEssayQuestion qtypeEssayQuestion);
    void createCertificateCourse(CertificateCourse certificateCourse);
}
