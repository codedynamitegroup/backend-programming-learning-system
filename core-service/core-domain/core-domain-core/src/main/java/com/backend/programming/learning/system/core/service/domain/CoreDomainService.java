package com.backend.programming.learning.system.core.service.domain;

import com.backend.programming.learning.system.core.service.domain.entity.*;
import com.backend.programming.learning.system.core.service.domain.event.contest_user.ContestUserUpdatedEvent;
import com.backend.programming.learning.system.core.service.domain.event.organization.*;
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
    void createQuestionV2(Question question);
    // create qtype
    QuestionCreatedEvent createQtypeCodeQuestion(Question question, QtypeCodeQuestion qtypeCodeQuestion);
    QuestionCreatedEvent createQtypeEssayQuestion(Question question, QtypeEssayQuestion qtypeEssayQuestion);
    QuestionCreatedEvent createQtypeShortAnswerQuestion(Question question, QtypeShortAnswerQuestion qtypeEssayQuestion);
    QuestionCreatedEvent createQtypeMultipleChoiceQuestion(Question question, QtypeMultiChoiceQuestion qtypeMultipleChoiceQuestion);

    // delete
    QuestionDeletedEvent deleteQuestion(
            Question question,
            UUID qtypeId,
            QtypeShortAnswerQuestion qtypeShortAnswerQuestion,
            QtypeEssayQuestion qtypeEssayQuestion,
            QtypeMultiChoiceQuestion qtypeMultiChoiceQuestion,
            QtypeCodeQuestion qtypeCodeQuestion);

    // update qtype
    QuestionUpdatedEvent updateQtypeCodeQuestion(
            Question question,
            QtypeCodeQuestion qtypeCodeQuestion,
            Question prevQuestion,
            QtypeCodeQuestion prevQtypeCodeQuestion);
    QuestionUpdatedEvent updateQtypeEssayQuestion(
            Question question,
            QtypeEssayQuestion qtypeEssayQuestion,
            Question prevQuestion,
            QtypeEssayQuestion prevQtypeEssayQuestion);
    QuestionUpdatedEvent updateQtypeShortAnswerQuestion(
            Question question,
            QtypeShortAnswerQuestion qtypeShortAnswerQuestion,
            Question prevQuestion,
            QtypeShortAnswerQuestion prevQtypeShortAnswerQuestion);
    QuestionUpdatedEvent updateQtypeMultipleChoiceQuestion(
            Question question,
            QtypeMultiChoiceQuestion qtypeMultiChoiceQuestion,
            Question prevQuestion,
            QtypeMultiChoiceQuestion prevQtypeMultiChoiceQuestion);

    void deleteQuestion(Question question);
    void rollbackQuestion(Question question);
    void rollbackQtypeCodeQuestion(QtypeCodeQuestion qtypeCodeQuestion);
    void rollbackQtypeEssayQuestion(QtypeEssayQuestion qtypeEssayQuestion);
    void rollbackQtypeShortAnswerQuestion(QtypeShortAnswerQuestion qtypeShortAnswerQuestion);
    void rollbackQtypeMultipleChoiceQuestion(QtypeMultiChoiceQuestion qtypeMultiChoiceQuestion);
    void rollbackAnswerOfQuestion(List<AnswerOfQuestion> answerOfQuestionList);

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

    OrganizationCreatedSuccessEvent createdOrganizationSuccess(Organization organization);
    OrganizationCreatedFailEvent createdOrganizationFail(Organization organization, List<String> failureMessages);
    OrganizationUpdatedSuccessEvent updatedOrganizationSuccess(Organization organization);
    OrganizationUpdatedFailEvent updatedOrganizationFail(Organization organization, List<String> failureMessages);
    OrganizationDeletedSuccessEvent deletedOrganizationSuccess(Organization organization);
    OrganizationDeletedFailEvent deletedOrganizationFail(Organization organization, List<String> failureMessages);

    void updateContestUserCalendarEventState(ContestUser contestUser, String calendarEventId, UpdateState updateCalendarEventState);
}
