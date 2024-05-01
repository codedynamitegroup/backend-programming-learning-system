package com.backend.programming.learning.system.core.service.domain;

import com.backend.programming.learning.system.core.service.domain.entity.*;
import com.backend.programming.learning.system.core.service.domain.event.contest_user.ContestUserUpdatedEvent;
import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionCreatedEvent;
import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionDeletedEvent;
import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionUpdatedEvent;
import com.backend.programming.learning.system.core.service.domain.event.user.*;
import com.backend.programming.learning.system.core.service.domain.valueobject.UpdateState;

import java.util.List;
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
    ContestUserUpdatedEvent createContestUser(ContestUser contestUser);

    UserCreatedSuccessEvent createdUserSuccess(User user);
    UserCreatedFailEvent createdUserFail(User user, List<String> failureMessages);
    UserUpdatedSuccessEvent updatedUserSuccess(User user);
    UserUpdatedFailEvent updatedUserFail(User user, List<String> failureMessages);
    UserDeletedSuccessEvent deletedUserSuccess(User user);
    UserDeletedFailEvent deletedUserFail(User user, List<String> failureMessages);

    void updateContestUserCalendarEventState(ContestUser contestUser, String calendarEventId, UpdateState updateCalendarEventState);

}
