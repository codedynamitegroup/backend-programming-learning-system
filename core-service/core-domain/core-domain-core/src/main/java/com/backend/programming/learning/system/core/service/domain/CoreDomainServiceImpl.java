package com.backend.programming.learning.system.core.service.domain;

import com.backend.programming.learning.system.core.service.domain.entity.*;
import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionCreatedEvent;
import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionDeletedEvent;
import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionUpdatedEvent;
import lombok.extern.slf4j.Slf4j;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

@Slf4j
public class CoreDomainServiceImpl implements CoreDomainService {
    @Override
    public void createQuestion(Question question) {
        question.initializeQuestion();
        log.info("Question initialized with id: {}", question.getId().getValue());
    }

    @Override
    public QuestionCreatedEvent createQtypeCodeQuestion(Question question, QtypeCodeQuestion qtypeCodeQuestion) {
        qtypeCodeQuestion.initQtypeCodeQuestion();
        log.info("Qtype code question initiated with id: {}", qtypeCodeQuestion.getId().getValue());
        return new QuestionCreatedEvent(question, qtypeCodeQuestion.getId().getValue(), ZonedDateTime.now(ZoneId.of("UTC")));
    }

    @Override
    public QuestionCreatedEvent createQtypeEssayQuestion(Question question, QtypeEssayQuestion qtypeEssayQuestion) {
        qtypeEssayQuestion.initQtypeEssayQuestion();
        log.info("Qtype essay question initiated with id: {}", qtypeEssayQuestion.getId().getValue());
        return new QuestionCreatedEvent(question, qtypeEssayQuestion.getId().getValue(), ZonedDateTime.now(ZoneId.of("UTC")));
    }

    @Override
    public QuestionCreatedEvent createQtypeShortAnswerQuestion(Question question, QtypeShortAnswerQuestion qtypeEssayQuestion) {
        qtypeEssayQuestion.initQtypeShortAnswerQuestion();
        log.info("Qtype short answer question initiated with id: {}", qtypeEssayQuestion.getId().getValue());
        return new QuestionCreatedEvent(question, qtypeEssayQuestion.getId().getValue(), ZonedDateTime.now(ZoneId.of("UTC")));
    }

    @Override
    public QuestionCreatedEvent createQtypeMultipleChoiceQuestion(Question question, QtypeMultiChoiceQuestion qtypeMultipleChoiceQuestion) {
        qtypeMultipleChoiceQuestion.initQtypeMultipleChoiceQuestion();
        log.info("Qtype multiple choice question initiated with id: {}", qtypeMultipleChoiceQuestion.getId().getValue());
        return new QuestionCreatedEvent(question, qtypeMultipleChoiceQuestion.getId().getValue(), ZonedDateTime.now(ZoneId.of("UTC")));
    }

    @Override
    public QuestionDeletedEvent deleteQuestion(Question question, UUID qtypeId) {
        return new QuestionDeletedEvent(question, qtypeId, ZonedDateTime.now(ZoneId.of("UTC")));
    }

    @Override
    public QuestionUpdatedEvent updateQtypeCodeQuestion(Question question, QtypeCodeQuestion qtypeCodeQuestion) {
        return new QuestionUpdatedEvent(question, qtypeCodeQuestion.getId().getValue(), ZonedDateTime.now(ZoneId.of("UTC")));
    }

    @Override
    public QuestionUpdatedEvent updateQtypeEssayQuestion(Question question, QtypeEssayQuestion qtypeEssayQuestion) {
        return new QuestionUpdatedEvent(question, qtypeEssayQuestion.getId().getValue(), ZonedDateTime.now(ZoneId.of("UTC")));
    }

    @Override
    public QuestionUpdatedEvent updateQtypeShortAnswerQuestion(
            Question question,
            QtypeShortAnswerQuestion qtypeShortAnswerQuestion) {
        return new QuestionUpdatedEvent(question, qtypeShortAnswerQuestion.getId().getValue(), ZonedDateTime.now(ZoneId.of("UTC")));
    }

    @Override
    public QuestionUpdatedEvent updateQtypeMultipleChoiceQuestion(
            Question question,
            QtypeMultiChoiceQuestion qtypeMultiChoiceQuestion) {
        return new QuestionUpdatedEvent(question, qtypeMultiChoiceQuestion.getId().getValue(), ZonedDateTime.now(ZoneId.of("UTC")));
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
    public void createContestUser(ContestUser contestUser) {
        contestUser.initializeContestUser();
        log.info("Contest user created with id: {}", contestUser.getId().getValue());
    }

    @Override
    public void createCalendarEvent(CalendarEvent calendarEvent) {
        calendarEvent.initializeCalendarEvent();
        log.info("Calendar event created with id: {}", calendarEvent.getId().getValue());
    }
}
