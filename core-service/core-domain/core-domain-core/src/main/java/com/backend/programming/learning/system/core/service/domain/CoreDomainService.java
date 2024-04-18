package com.backend.programming.learning.system.core.service.domain;

import com.backend.programming.learning.system.core.service.domain.entity.*;
import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionCreatedEvent;
import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionDeletedEvent;
import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionUpdatedEvent;

import java.util.UUID;

public interface CoreDomainService {
    // question
    void createQuestion(Question question);

    QuestionCreatedEvent createQtypeCodeQuestion(Question question, QtypeCodeQuestion qtypeCodeQuestion);
    QuestionCreatedEvent createQtypeEssayQuestion(Question question, QtypeEssayQuestion qtypeEssayQuestion);
    QuestionCreatedEvent createQtypeShortAnswerQuestion(Question question, QtypeShortAnswerQuestion qtypeEssayQuestion);
    QuestionCreatedEvent createQtypeMultipleChoiceQuestion(Question question, QtypeMultiChoiceQuestion qtypeMultipleChoiceQuestion);

    QuestionDeletedEvent deleteQuestion(Question question, UUID qtypeId);
    QuestionUpdatedEvent updateQtypeCodeQuestion(Question question, QtypeCodeQuestion qtypeCodeQuestion);
    QuestionUpdatedEvent updateQtypeEssayQuestion(Question question, QtypeEssayQuestion qtypeEssayQuestion);
    QuestionUpdatedEvent updateQtypeShortAnswerQuestion(Question question, QtypeShortAnswerQuestion qtypeShortAnswerQuestion);
    QuestionUpdatedEvent updateQtypeMultipleChoiceQuestion(Question question, QtypeMultiChoiceQuestion qtypeMultiChoiceQuestion);

    //
    void createAnswerOfQuestion(AnswerOfQuestion answerOfQuestion);
    void createCertificateCourse(CertificateCourse certificateCourse);
    void createReview(Review review);
    void createTopic(Topic topic);
    void createContest(Contest contest);
    void createNotification(Notification notification);
    void createChapter(Chapter chapter);
    void createCertificateCourseUser(CertificateCourseUser certificateCourseUser);
    void createContestUser(ContestUser contestUser);
}
