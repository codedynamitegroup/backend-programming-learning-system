package com.backend.programming.learning.system.core.service.domain;

import com.backend.programming.learning.system.core.service.domain.entity.*;
import com.backend.programming.learning.system.core.service.domain.event.QuestionCreatedEvent;
import lombok.extern.slf4j.Slf4j;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Slf4j
public class CoreDomainServiceImpl implements CoreDomainService {
    @Override
    public QuestionCreatedEvent createQuestion(Question question) {
        question.initializeQuestion();

        log.info("Question created with id: {}", question.getId().getValue());

        return new QuestionCreatedEvent(question, ZonedDateTime.now(ZoneId.of("UTC")));
    }

    @Override
    public void createQtypeCodeQuestion(QtypeCodeQuestion qtypeCodeQuestion) {
        qtypeCodeQuestion.initQtypeCodeQuestion();
        log.info("Qtype code question created with id: {}", qtypeCodeQuestion.getId().getValue());
    }

    @Override
    public void createQtypeEssayQuestion(QtypeEssayQuestion qtypeEssayQuestion) {
        qtypeEssayQuestion.initQtypeEssayQuestion();
        log.info("Qtype essay question created with id: {}", qtypeEssayQuestion.getId().getValue());
    }

    @Override
    public void createQtypeShortAnswerQuestion(QtypeShortAnswerQuestion qtypeEssayQuestion) {
        qtypeEssayQuestion.initQtypeShortAnswerQuestion();
        log.info("Qtype short answer question created with id: {}", qtypeEssayQuestion.getId().getValue());
    }

    @Override
    public void createQtypeMultipleChoiceQuestion(QtypeMultiChoiceQuestion qtypeMultipleChoiceQuestion) {
        qtypeMultipleChoiceQuestion.initQtypeMultipleChoiceQuestion();
        log.info("Qtype multiple choice question created with id: {}", qtypeMultipleChoiceQuestion.getId().getValue());
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
}
