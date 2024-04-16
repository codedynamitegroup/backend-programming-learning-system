package com.backend.programming.learning.system.core.service.domain;

import com.backend.programming.learning.system.core.service.domain.entity.*;
import com.backend.programming.learning.system.core.service.domain.event.QuestionCreatedEvent;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;

public interface CoreDomainService {
    QuestionCreatedEvent createQuestion(Question question);
    void createQtypeCodeQuestion(QtypeCodeQuestion qtypeCodeQuestion);
    void createQtypeEssayQuestion(QtypeEssayQuestion qtypeEssayQuestion);
    void createQtypeShortAnswerQuestion(QtypeShortAnswerQuestion qtypeEssayQuestion);
     void createQtypeMultipleChoiceQuestion(QtypeMultiChoiceQuestion qtypeMultipleChoiceQuestion);
    void createCertificateCourse(CertificateCourse certificateCourse);
    void createReview(Review review);
    void createTopic(Topic topic);
    void createContest(Contest contest);
    void createNotification(Notification notification);
    void createChapter(Chapter chapter);
    void createCertificateCourseUser(CertificateCourseUser certificateCourseUser);
    void createContestUser(ContestUser contestUser);
}
