package com.backend.programming.learning.system.core.service.domain;

import com.backend.programming.learning.system.core.service.domain.entity.*;
import com.backend.programming.learning.system.core.service.domain.event.contest_user.ContestUserUpdatedEvent;
import com.backend.programming.learning.system.core.service.domain.event.organization.*;
import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionCreatedEvent;
import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionDeletedEvent;
import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionUpdatedEvent;
import com.backend.programming.learning.system.core.service.domain.event.user.*;
import com.backend.programming.learning.system.core.service.domain.valueobject.UpdateState;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.domain.DomainConstants;
import lombok.extern.slf4j.Slf4j;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Slf4j
public class CoreDomainServiceImpl implements CoreDomainService {
    @Override
    public void createQuestion(Question question) {
        question.initializeQuestion();
        question.setCopyState(CopyState.CREATING);

        log.info("Question initialized with id: {}", question.getId().getValue());
    }

    @Override
    public QuestionCreatedEvent createQtypeCodeQuestion(Question question, QtypeCodeQuestion qtypeCodeQuestion) {
        qtypeCodeQuestion.initQtypeCodeQuestion();
        question.setCopyState(CopyState.CREATING);

        log.info("Qtype code question initiated with id: {}", qtypeCodeQuestion.getId().getValue());
        return new QuestionCreatedEvent(question, qtypeCodeQuestion.getId().getValue(), ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM)));
    }

    @Override
    public QuestionCreatedEvent createQtypeEssayQuestion(Question question, QtypeEssayQuestion qtypeEssayQuestion) {
        qtypeEssayQuestion.initQtypeEssayQuestion();
        question.setCopyState(CopyState.CREATING);

        log.info("Qtype essay question initiated with id: {}", qtypeEssayQuestion.getId().getValue());
        return new QuestionCreatedEvent(question, qtypeEssayQuestion.getId().getValue(), ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM)));
    }

    @Override
    public QuestionCreatedEvent createQtypeShortAnswerQuestion(Question question, QtypeShortAnswerQuestion qtypeEssayQuestion) {
        qtypeEssayQuestion.initQtypeShortAnswerQuestion();
        question.setCopyState(CopyState.CREATING);

        log.info("Qtype short answer question initiated with id: {}", qtypeEssayQuestion.getId().getValue());
        return new QuestionCreatedEvent(question, qtypeEssayQuestion.getId().getValue(), ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM)));
    }

    @Override
    public QuestionCreatedEvent createQtypeMultipleChoiceQuestion(Question question, QtypeMultiChoiceQuestion qtypeMultipleChoiceQuestion) {
        qtypeMultipleChoiceQuestion.initQtypeMultipleChoiceQuestion();
        question.setCopyState(CopyState.CREATING);

        log.info("Qtype multiple choice question initiated with id: {}", qtypeMultipleChoiceQuestion.getId().getValue());
        return new QuestionCreatedEvent(question, qtypeMultipleChoiceQuestion.getId().getValue(), ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM)));
    }

    @Override
    public QuestionDeletedEvent deleteQuestion(
            Question question,
            UUID qtypeId,
            QtypeShortAnswerQuestion qtypeShortAnswerQuestion,
            QtypeEssayQuestion qtypeEssayQuestion,
            QtypeMultiChoiceQuestion qtypeMultiChoiceQuestion,
            QtypeCodeQuestion qtypeCodeQuestion) {
        question.setCopyState(CopyState.DELETING);
        return new QuestionDeletedEvent(question,
                qtypeId, ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM)),
                qtypeCodeQuestion,
                qtypeMultiChoiceQuestion,
                qtypeEssayQuestion,
                qtypeShortAnswerQuestion);
    }

    @Override
    public QuestionUpdatedEvent updateQtypeCodeQuestion(Question question,
                                                        QtypeCodeQuestion qtypeCodeQuestion,
                                                        Question prevQuestion,
                                                        QtypeCodeQuestion prevQtypeCodeQuestion) {
        question.setCopyState(CopyState.UPDATING);
        return new QuestionUpdatedEvent(question,
                qtypeCodeQuestion.getId().getValue(),
                ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM)),
                prevQuestion, prevQtypeCodeQuestion,
                null,
                null,
                null);
    }

    @Override
    public QuestionUpdatedEvent updateQtypeEssayQuestion(Question question,
                                                         QtypeEssayQuestion qtypeEssayQuestion,
                                                         Question prevQuestion,
                                                         QtypeEssayQuestion prevQtypeEssayQuestion) {
        question.setCopyState(CopyState.UPDATING);
        return new QuestionUpdatedEvent(question,
                qtypeEssayQuestion.getId().getValue(),
                ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM)),
                prevQuestion,
                null,
                null,
                prevQtypeEssayQuestion,
                null);
    }

    @Override
    public QuestionUpdatedEvent updateQtypeShortAnswerQuestion(Question question,
                                                               QtypeShortAnswerQuestion qtypeShortAnswerQuestion,
                                                               Question prevQuestion,
                                                               QtypeShortAnswerQuestion prevQtypeShortAnswerQuestion) {
        question.setCopyState(CopyState.UPDATING);
        return new QuestionUpdatedEvent(question,
                qtypeShortAnswerQuestion.getId().getValue(),
                ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM)),
                prevQuestion,
                null,
                null,
                null,
                prevQtypeShortAnswerQuestion);
    }

    @Override
    public QuestionUpdatedEvent updateQtypeMultipleChoiceQuestion(Question question,
                                                                  QtypeMultiChoiceQuestion qtypeMultiChoiceQuestion,
                                                                  Question prevQuestion,
                                                                  QtypeMultiChoiceQuestion prevQtypeMultiChoiceQuestion ) {
        question.setCopyState(CopyState.UPDATING);
        return new QuestionUpdatedEvent(question,
                qtypeMultiChoiceQuestion.getId().getValue(),
                ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM)),
                prevQuestion,
                null,
                prevQtypeMultiChoiceQuestion,
                null,
                null);
    }

    @Override
    public void deleteQuestion(Question question) {

    }

    @Override
    public void rollbackQuestion(Question question) {

    }

    @Override
    public void rollbackQtypeCodeQuestion(QtypeCodeQuestion qtypeCodeQuestion) {

    }

    @Override
    public void rollbackQtypeEssayQuestion(QtypeEssayQuestion qtypeEssayQuestion) {

    }

    @Override
    public void rollbackQtypeShortAnswerQuestion(QtypeShortAnswerQuestion qtypeShortAnswerQuestion) {

    }

    @Override
    public void rollbackQtypeMultipleChoiceQuestion(QtypeMultiChoiceQuestion qtypeMultiChoiceQuestion) {

    }

    @Override
    public void rollbackAnswerOfQuestion(List<AnswerOfQuestion> answerOfQuestionList) {

    }

    @Override
    public void createAnswerOfQuestion(AnswerOfQuestion answerOfQuestion) {
        answerOfQuestion.initializeAnswerOfQuestion();
        log.info("Answer of question initiated with id: {}", answerOfQuestion.getId().getValue());
    }

    @Override
    public void createCertificateCourse(CertificateCourse certificateCourse) {
        certificateCourse.initializeCertificateCourse();
        log.info("Certificate course created with id: {}", certificateCourse.getId().getValue());
    }

    @Override
    public void createReview(Review review) {
        review.initializeReview();
        log.info("Review created with id: {}", review.getId().getValue());
    }

    @Override
    public void createTopic(Topic topic) {
        topic.initializeTopic();
        log.info("Topic created with id: {}", topic.getId().getValue());
    }

    @Override
    public void createContest(Contest contest) {
        contest.initializeContest();
        log.info("Contest created with id: {}", contest.getId().getValue());
    }

    @Override
    public void createNotification(Notification notification) {
        notification.initializeNotification();
        log.info("Notification created with id: {}", notification.getId().getValue());
    }

    @Override
    public void createChapter(Chapter chapter) {
        chapter.initializeChapter();
        log.info("Chapter created with id: {}", chapter.getId().getValue());
    }

    @Override
    public void createCertificateCourseUser(CertificateCourseUser certificateCourseUser) {
        certificateCourseUser.initializeCertificateCourseUser();
        log.info("Certificate course user created with id: {}", certificateCourseUser.getId().getValue());
    }

    @Override
    public ContestUserUpdatedEvent createContestUser(ContestUser contestUser) {
        contestUser.initializeContestUser();
        log.info("Contest user created with id: {}", contestUser.getId().getValue());
        return new ContestUserUpdatedEvent(contestUser, ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM)));
    }

    @Override
    public UserCreatedSuccessEvent createdUserSuccess(User user) {
        return new UserCreatedSuccessEvent(user,
                ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM)));
    }

    @Override
    public UserCreatedFailEvent createdUserFail(User user, List<String> failureMessages) {
        return new UserCreatedFailEvent(user,
                ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM)), failureMessages);
    }

    @Override
    public UserUpdatedSuccessEvent updatedUserSuccess(User user) {
        return new UserUpdatedSuccessEvent(user,
                ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM)));
    }

    @Override
    public UserUpdatedFailEvent updatedUserFail(User user, List<String> failureMessages) {
        return new UserUpdatedFailEvent(user,
                ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM)),
                failureMessages);
    }

    @Override
    public UserDeletedSuccessEvent deletedUserSuccess(User user) {
        return new UserDeletedSuccessEvent(user,
                ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM)));
    }

    @Override
    public UserDeletedFailEvent deletedUserFail(User user, List<String> failureMessages) {
        return new UserDeletedFailEvent(user,
                ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM)),
                failureMessages);
    }

    @Override
    public OrganizationCreatedSuccessEvent createdOrganizationSuccess(Organization organization) {
        return new OrganizationCreatedSuccessEvent(organization,
                ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM)));
    }

    @Override
    public OrganizationCreatedFailEvent createdOrganizationFail(Organization organization, List<String> failureMessages) {
        return new OrganizationCreatedFailEvent(organization,
                ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM)), failureMessages);
    }

    @Override
    public OrganizationUpdatedSuccessEvent updatedOrganizationSuccess(Organization organization) {
        return new OrganizationUpdatedSuccessEvent(organization,
                ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM)));
    }

    @Override
    public OrganizationUpdatedFailEvent updatedOrganizationFail(Organization organization, List<String> failureMessages) {
        return new OrganizationUpdatedFailEvent(organization,
                ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM)), failureMessages);
    }

    @Override
    public OrganizationDeletedSuccessEvent deletedOrganizationSuccess(Organization organization) {
        return new OrganizationDeletedSuccessEvent(organization,
                ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM)));
    }

    @Override
    public OrganizationDeletedFailEvent deletedOrganizationFail(Organization organization, List<String> failureMessages) {
        return new OrganizationDeletedFailEvent(organization,
                ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM)), failureMessages);
    }

    @Override
    public void updateContestUserCalendarEventState(ContestUser contestUser, String calendarEventId, UpdateState updateCalendarEventState) {
        contestUser.setCalendarEventId(calendarEventId != null ? UUID.fromString(calendarEventId) : null);
        contestUser.setUpdateCalendarEventState(updateCalendarEventState);
        log.info("Contest user calendar event state updated with calendar event id: {} and update calendar event state: {}",
                calendarEventId, updateCalendarEventState);
    }
}
