package com.backend.programming.learning.system.core.service.dataaccess.question.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QtypeCodeQuestionEntity;
import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QtypeEssayQuestionEntity;
import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QtypeMultichoiceQuestionEntity;
import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QtypeShortanswerQuestionEntity;
import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QuestionEntity;
import com.backend.programming.learning.system.core.service.dataaccess.question.mapper.QuestionDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.question.repository.*;
import com.backend.programming.learning.system.core.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.repository.UserJpaRepository;
import com.backend.programming.learning.system.core.service.domain.CoreDomainService;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQtypeEssayQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQtypeMultichoiceQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQtypeShortanswerQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQuestionClone;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.question.QueryAllQuestionByCategoryIdCommand;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.question.QuestionResponseEntity;
import com.backend.programming.learning.system.core.service.domain.entity.AnswerOfQuestion;
import com.backend.programming.learning.system.core.service.domain.entity.Organization;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeEssayQuestion;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeMultiChoiceQuestion;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeShortAnswerQuestion;
import com.backend.programming.learning.system.core.service.domain.entity.Question;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionCreatedEvent;
import com.backend.programming.learning.system.core.service.domain.exception.CoreDomainException;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.implement.service.question.saga.QuestionSagaHelper;
import com.backend.programming.learning.system.core.service.domain.mapper.question.QtypeEssayQuestionDataMapper;
import com.backend.programming.learning.system.core.service.domain.mapper.question.QtypeMultichoiceQuestionDataMapper;
import com.backend.programming.learning.system.core.service.domain.mapper.question.QtypeShortanswerQuestionDataMapper;
import com.backend.programming.learning.system.core.service.domain.mapper.question.QuestionDataMapper;
import com.backend.programming.learning.system.core.service.domain.outbox.scheduler.question.QuestionOutboxHelper;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.*;
import com.backend.programming.learning.system.domain.exception.question.QuestionNotFoundException;
import com.backend.programming.learning.system.domain.valueobject.QuestionType;
import com.backend.programming.learning.system.domain.valueobject.ServiceName;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Component
@Slf4j
@RequiredArgsConstructor
public class QuestionRepositoryImpl implements QuestionRepository {
    private final QuestionJpaRepository questionJpaRepository;
    private final QtypeCodeQuestionJpaRepository qtypeCodeQuestionJpaRepository;
    private final QtypeEssayQuestionJpaRepository qtypeEssayQuestionJpaRepository;
    private final QtypeMultichoiceQuestionJpaRepository qtypeMultichoiceQuestionJpaRepository;
    private final QtypeShortanswerQuestionJpaRepository qtypeShortanswerQuestionJpaRepository;
    private final QuestionDataAccessMapper questionDataAccessMapper;
    private final UserJpaRepository userJpaRepository;
    private final CoreDomainService coreDomainService;
    private final QtypeMultichoiceQuestionRepository qtypeMultichoiceQuestionRepository;
    private final QtypeMultichoiceQuestionDataMapper qtypeMultichoiceQuestionDataMapper;
    private final QuestionOutboxHelper questionOutboxHelper;
    private final QuestionDataMapper questionDataMapper;
    private final AnswerOfQuestionRepository answerOfQuestionRepository;
    private final QtypeShortanswerQuestionDataMapper qtypeShortanswerQuestionDataMapper;
    private final QtypeShortanswerQuestionRepository qtypeShortanswerQuestionRepository;
    private final QtypeEssayQuestionRepository qtypeEssayQuestionRepository;
    private final QtypeEssayQuestionDataMapper qtypeEssayQuestionDataMapper;
    private final OrganizationRepository organizationRepository;
    private final UserRepository userRepository;

    @Override
    public Question saveQuestion(Question question) {
        return questionDataAccessMapper.questionEntityToQuestion(questionJpaRepository
                .save(questionDataAccessMapper
                        .questionToQuestionEntity(question)));
    }

    @Override
    public Optional<Question> findQuestion(UUID id) {
        return questionJpaRepository.findById(id)
                .map(questionDataAccessMapper::questionEntityToQuestion);
    }

    @Override
    public List<QuestionResponseEntity> findAllQuestion() {
        return questionJpaRepository
                .findAll()
                .stream()
                .map(questionDataAccessMapper::questionEntityToQuestionResponseEntity)
                .toList();
    }

    @Override
    public void deleteQuestion(UUID id) {
        questionJpaRepository.findById(id)
                .ifPresent(
                        questionEntity -> {
//                            questionJpaRepository.delete(questionEntity);
                            switch (questionEntity.getQtype()) {
                                case CODE:
                                    qtypeCodeQuestionJpaRepository.findByQuestionId(id)
                                            .ifPresent(qtypeCodeQuestionJpaRepository::delete);
                                    break;
                                case ESSAY:
                                    qtypeEssayQuestionJpaRepository.findByQuestionId(id)
                                            .ifPresent(qtypeEssayQuestionJpaRepository::delete);
                                    break;
                                case MULTIPLE_CHOICE, TRUE_FALSE:
                                    qtypeMultichoiceQuestionJpaRepository.findByQuestionId(id)
                                            .ifPresent(qtypeMultichoiceQuestionJpaRepository::delete);
                                    break;
                                case SHORT_ANSWER:
                                    qtypeShortanswerQuestionJpaRepository.findByQuestionId(id)
                                            .ifPresent(qtypeShortanswerQuestionJpaRepository::delete);
                                    break;
                                default:
                                    throw new IllegalArgumentException("Invalid question type");
                            }
                        }
                );
        questionJpaRepository.deleteById(id);
    }

    @Override
    public QuestionType getQtype(UUID id) {
        return QuestionType.valueOf(questionJpaRepository.getQtype(id));
    }

    // Update Question and Answer of Question
    @Override
    public void updateQuestion(Question question) {
        Optional<QuestionEntity> questionEntity = questionJpaRepository.findById(question.getId().getValue());
        Optional<UserEntity> updatedByEntity = userJpaRepository.findById(question.getUpdatedBy().getId().getValue());

        if (questionEntity.isEmpty()) {
            log.error("Question not found with id: {}", question.getId().getValue());
            throw new QuestionNotFoundException("Question not found with id: " + question.getId().getValue());
        }
        if (updatedByEntity.isEmpty()) {
            log.error("User not found with id: {}", question.getUpdatedBy().getId().getValue());
            throw new UserNotFoundException("User not found with id: " + question.getUpdatedBy().getId().getValue());
        }

        QuestionEntity updatingQuestionEntity = questionEntity.get();
        updatingQuestionEntity.setUpdatedBy(updatedByEntity.get());

        questionJpaRepository.save(questionDataAccessMapper.setQuestionEntity(updatingQuestionEntity, question));
    }

    @Override
    public Page<QuestionResponseEntity> findAllQuestionByCategory(
            UUID categoryId,
            QueryAllQuestionByCategoryIdCommand queryAllQuestionByCategoryIdCommand) {
        Pageable pageRequest = Pageable.ofSize(queryAllQuestionByCategoryIdCommand.getPageSize())
                .withPage(queryAllQuestionByCategoryIdCommand.getPageNo());
        return questionJpaRepository
                .findAllByQuestionBankCategoryId(categoryId,
                        queryAllQuestionByCategoryIdCommand.getSearch(),
                        pageRequest)
                .map(questionDataAccessMapper::questionEntityToQuestionResponseEntity);
    }

    @Override
    public Page<QuestionResponseEntity> findAllQuestionByCategoryAndIsBasicType(
            UUID categoryId,
            QueryAllQuestionByCategoryIdCommand queryAllQuestionByCategoryIdCommand,
            boolean isBasicType) {
        Pageable pageRequest = Pageable.ofSize(queryAllQuestionByCategoryIdCommand.getPageSize())
                .withPage(queryAllQuestionByCategoryIdCommand.getPageNo());
        return questionJpaRepository
                .findAllByQuestionBankCategoryIdAndIsBasicType(
                        categoryId,
                        queryAllQuestionByCategoryIdCommand.getSearch(),
                        isBasicType,
                        pageRequest)
                .map(questionDataAccessMapper::questionEntityToQuestionResponseEntity);
    }

    @Override
    public List<QuestionCreatedEvent> cloneQuestion(List<CreateQuestionClone> questionClones) {
        Map<UUID, QuestionEntity> questionMap = new HashMap<>();
        List<QuestionEntity> questionEntities = questionJpaRepository.findAllById(questionClones
                        .stream()
                        .map(CreateQuestionClone::questionId)
                        .toList())
                .stream()
                .peek(questionEntity -> questionMap
                        .put(questionEntity.getId(), questionDataAccessMapper.cloneQuestionEntity(questionEntity)))
                .toList();

        List<QuestionCreatedEvent> questionCreatedEvents = new ArrayList<>();
        Organization organization = getOrganization(questionEntities.get(0).getOrganization().getId());
        User user = getUser(questionEntities.get(0).getCreatedBy().getId());

        questionJpaRepository.saveAllAndFlush(questionMap.values());

        questionClones.forEach(createQuestionClone -> {
            switch (questionMap.get(createQuestionClone.questionId()).getQtype().toString()) {
                case "CODE":
                    qtypeCodeQuestionJpaRepository.findByQuestionId(createQuestionClone.questionId())
                            .ifPresent(qtypeCodeQuestion -> {
                                QuestionEntity newQuestion = questionMap.get(createQuestionClone.questionId());
                                QtypeCodeQuestionEntity newQtypeCodeQuestion = questionDataAccessMapper
                                        .cloneQtypeCodeQuestionEntity(qtypeCodeQuestion, newQuestion);
                                qtypeCodeQuestionJpaRepository.save(newQtypeCodeQuestion);
                            });
                    break;
                case "ESSAY":
                    qtypeEssayQuestionJpaRepository.findByQuestionId(createQuestionClone.questionId())
                            .ifPresent(qtypeEssayQuestion -> {
                                QuestionEntity newQuestion = questionMap.get(createQuestionClone.questionId());
                                QtypeEssayQuestionEntity newQtypeEssayQuestion =
                                        questionDataAccessMapper.cloneQtypeEssayQuestionEntity(qtypeEssayQuestion, newQuestion);
                                qtypeEssayQuestionJpaRepository.save(newQtypeEssayQuestion);

                                Question createdQuestion = questionDataAccessMapper.questionEntityToQuestion(newQuestion);
                                CreateQtypeEssayQuestionCommand createQtypeEssayQuestionCommand =
                                        new CreateQtypeEssayQuestionCommand(organization.getId().getValue(),
                                                user.getId().getValue(),
                                                user.getId().getValue(),
                                                createdQuestion.getDifficulty().name(),
                                                createdQuestion.getName(),
                                                createdQuestion.getQuestionText(),
                                                createdQuestion.getGeneralFeedback(),
                                                BigDecimal.valueOf( createdQuestion.getDefaultMark()),
                                                createdQuestion.getqtype().name(),
                                                answerOfQuestionListToAnswerOfQuestionEntityList(createdQuestion.getAnswers()),
                                                null,
                                                true,
                                                newQtypeEssayQuestion.getResponseFormat(),
                                                newQtypeEssayQuestion.getResponseRequired(),
                                                newQtypeEssayQuestion.getResponseFieldLines(),
                                                newQtypeEssayQuestion.getMinWordLimit(),
                                                newQtypeEssayQuestion.getMaxWordLimit(),
                                                newQtypeEssayQuestion.getAttachments(),
                                                newQtypeEssayQuestion.getAttachmentsRequired(),
                                                newQtypeEssayQuestion.getGraderInfo(),
                                                newQtypeEssayQuestion.getGraderInfoFormat(),
                                                newQtypeEssayQuestion.getResponseTemplate(),
                                                newQtypeEssayQuestion.getMaxBytes(),
                                                newQtypeEssayQuestion.getFileTypesList());

                                QtypeEssayQuestion qtypeEssayQuestion1 = qtypeEssayQuestionDataMapper
                                        .createQtypeEssayQuestionCommandToQtypeEssayQuestion(createQtypeEssayQuestionCommand, createdQuestion);

                                // init QtypeEssayQuestion
                                QuestionCreatedEvent questionCreatedEvent = coreDomainService.createQtypeEssayQuestion(createdQuestion, qtypeEssayQuestion1);
//                                qtypeEssayQuestionRepository.saveQtypeEssayQuestion(qtypeEssayQuestion1);

                                questionCreatedEvents.add(questionCreatedEvent);

                            });
                    break;
                case "MULTIPLE_CHOICE":
                    qtypeMultichoiceQuestionJpaRepository.findByQuestionId(createQuestionClone.questionId())
                            .ifPresent(qtypeMultichoiceQuestion -> {
                                QuestionEntity newQuestion = questionMap.get(createQuestionClone.questionId());
                                QtypeMultichoiceQuestionEntity qtypeMultichoiceQuestionSave =
                                        questionDataAccessMapper.cloneQtypeMultichoiceQuestionEntity(qtypeMultichoiceQuestion, newQuestion);
                                qtypeMultichoiceQuestionJpaRepository.save(qtypeMultichoiceQuestionSave);

                                Question question = questionDataAccessMapper.questionEntityToQuestion(newQuestion);
                                // save answer
                                if (question.getAnswers() != null) {
                                    for (AnswerOfQuestion answerOfQuestion : question.getAnswers()) {
                                        coreDomainService.createAnswerOfQuestion(answerOfQuestion);
                                        saveAnswer(answerOfQuestion);
                                    }
                                }
                                Question createdQuestion = questionDataAccessMapper.questionEntityToQuestion(newQuestion);
                                CreateQtypeMultichoiceQuestionCommand createQtypeMultichoiceQuestionCommand = new CreateQtypeMultichoiceQuestionCommand(
                                        organization.getId().getValue(),
                                        user.getId().getValue(),
                                        user.getId().getValue(),
                                        createdQuestion.getDifficulty().name(),
                                        createdQuestion.getName(),
                                        createdQuestion.getQuestionText(),
                                        createdQuestion.getGeneralFeedback(),
                                        BigDecimal.valueOf(createdQuestion.getDefaultMark()),
                                        createdQuestion.getqtype().name(),
                                        answerOfQuestionListToAnswerOfQuestionEntityList(createdQuestion.getAnswers()),
                                        null,
                                        true,
                                        qtypeMultichoiceQuestionSave.getSingle(),
                                        qtypeMultichoiceQuestionSave.getShuffleAnswers(),
                                        qtypeMultichoiceQuestionSave.getCorrectFeedback(),
                                        qtypeMultichoiceQuestionSave.getPartiallyCorrectFeedback(),
                                        qtypeMultichoiceQuestionSave.getIncorrectFeedback(),
                                        qtypeMultichoiceQuestionSave.getAnswerNumbering(),
                                        qtypeMultichoiceQuestionSave.getShowNumCorrect(),
                                        qtypeMultichoiceQuestionSave.getShowStandardInstruction()
                                );
                                QtypeMultiChoiceQuestion qtypeMultiChoiceQuestion = qtypeMultichoiceQuestionDataMapper
                                        .createQuestionCommandToQtypeMultiChoiceQuestion(createQtypeMultichoiceQuestionCommand, createdQuestion);

                                // init QtypeMultiChoiceQuestion
                                QuestionCreatedEvent questionCreatedEvent = coreDomainService.createQtypeMultipleChoiceQuestion(createdQuestion, qtypeMultiChoiceQuestion);
//                                qtypeMultichoiceQuestionRepository.saveQtypeMultipleChoiceQuestion(qtypeMultiChoiceQuestion);

                                questionCreatedEvents.add(questionCreatedEvent);
                                log.info("Qtype Multi Choice Question created with id: {}", qtypeMultiChoiceQuestion.getId().getValue());

                            });
                    break;
                case "SHORT_ANSWER":
                    qtypeShortanswerQuestionJpaRepository.findByQuestionId(createQuestionClone.questionId())
                            .ifPresent(qtypeShortanswerQuestion -> {
                                QuestionEntity newQuestion = questionMap.get(createQuestionClone.questionId());
                                QtypeShortanswerQuestionEntity qtypeShortanswerQuestionSave =
                                        questionDataAccessMapper.cloneQtypeShortanswerQuestionEntity(qtypeShortanswerQuestion, newQuestion);

                                qtypeShortanswerQuestionJpaRepository.save(qtypeShortanswerQuestionSave);


                                Question question = questionDataAccessMapper.questionEntityToQuestion(newQuestion);
                                coreDomainService.createQuestionV2(question);
//                                saveQuestion(question);

                                // save answer
                                if (question.getAnswers() != null) {
                                    for (AnswerOfQuestion answerOfQuestion : question.getAnswers()) {
                                        coreDomainService.createAnswerOfQuestion(answerOfQuestion);
                                        saveAnswer(answerOfQuestion);
                                    }
                                }

                                Question createdQuestion = questionDataMapper.setQuestionWithAnswers(question, question.getAnswers());

                                CreateQtypeShortanswerQuestionCommand createQtypeShortanswerQuestionCommand =
                                        new CreateQtypeShortanswerQuestionCommand(
                                                organization.getId().getValue(),
                                                user.getId().getValue(),
                                                user.getId().getValue(),
                                                createdQuestion.getDifficulty().name(),
                                                createdQuestion.getName(),
                                                createdQuestion.getQuestionText(),
                                                createdQuestion.getGeneralFeedback(),
                                                BigDecimal.valueOf(createdQuestion.getDefaultMark()),
                                                createdQuestion.getqtype().name(),
                                                answerOfQuestionListToAnswerOfQuestionEntityList(createdQuestion.getAnswers()),
                                                null,
                                                true,
                                                qtypeShortanswerQuestionSave.getCaseSensitive()
                                        );
                                QtypeShortAnswerQuestion qtypeShortAnswerQuestion = qtypeShortanswerQuestionDataMapper
                                        .createQuestionCommandToQtypeShortAnswerQuestion(createQtypeShortanswerQuestionCommand, createdQuestion);

                                // init QtypeShortAnswerQuestion
                                QuestionCreatedEvent questionCreatedEvent = coreDomainService.createQtypeShortAnswerQuestion(createdQuestion, qtypeShortAnswerQuestion);
//                                qtypeShortanswerQuestionRepository.saveQtypeShortAnswerQuestion(qtypeShortAnswerQuestion);

                                questionCreatedEvents.add(questionCreatedEvent);
                            });
                    break;
                case "TRUE_FALSE":
                    qtypeMultichoiceQuestionJpaRepository.findByQuestionId(createQuestionClone.questionId())
                            .ifPresent(qtypeMultichoiceQuestion -> {
                                QuestionEntity newQuestion = questionMap.get(createQuestionClone.questionId());
                                QtypeMultichoiceQuestionEntity qtypeMultichoiceQuestionSave =
                                        questionDataAccessMapper.cloneQtypeMultichoiceQuestionEntity(qtypeMultichoiceQuestion, newQuestion);
                                qtypeMultichoiceQuestionJpaRepository.save(qtypeMultichoiceQuestionSave);


                                Question question = questionDataAccessMapper.questionEntityToQuestion(newQuestion);
                                // save answer
                                if (question.getAnswers() != null) {
                                    for (AnswerOfQuestion answerOfQuestion : question.getAnswers()) {
                                        coreDomainService.createAnswerOfQuestion(answerOfQuestion);
                                        saveAnswer(answerOfQuestion);
                                    }
                                }
                                Question createdQuestion = questionDataMapper.setQuestionWithAnswers(question, question.getAnswers());
                                CreateQtypeMultichoiceQuestionCommand createQtypeMultichoiceQuestionCommand = new CreateQtypeMultichoiceQuestionCommand(
                                        organization.getId().getValue(),
                                        user.getId().getValue(),
                                        user.getId().getValue(),
                                        createdQuestion.getDifficulty().name(),
                                        createdQuestion.getName(),
                                        createdQuestion.getQuestionText(),
                                        createdQuestion.getGeneralFeedback(),
                                        BigDecimal.valueOf(createdQuestion.getDefaultMark()),
                                        createdQuestion.getqtype().name(),
                                        answerOfQuestionListToAnswerOfQuestionEntityList(createdQuestion.getAnswers()),
                                        null,
                                        true,
                                        qtypeMultichoiceQuestionSave.getSingle(),
                                        qtypeMultichoiceQuestionSave.getShuffleAnswers(),
                                        qtypeMultichoiceQuestionSave.getCorrectFeedback(),
                                        qtypeMultichoiceQuestionSave.getPartiallyCorrectFeedback(),
                                        qtypeMultichoiceQuestionSave.getIncorrectFeedback(),
                                        qtypeMultichoiceQuestionSave.getAnswerNumbering(),
                                        qtypeMultichoiceQuestionSave.getShowNumCorrect(),
                                        qtypeMultichoiceQuestionSave.getShowStandardInstruction()
                                );
                                QtypeMultiChoiceQuestion qtypeMultiChoiceQuestion = qtypeMultichoiceQuestionDataMapper
                                        .createQuestionCommandToQtypeMultiChoiceQuestion(createQtypeMultichoiceQuestionCommand, createdQuestion);

                                // init QtypeMultiChoiceQuestion
                                QuestionCreatedEvent questionCreatedEvent = coreDomainService.createQtypeMultipleChoiceQuestion(createdQuestion, qtypeMultiChoiceQuestion);
//                                qtypeMultichoiceQuestionRepository.saveQtypeMultipleChoiceQuestion(qtypeMultiChoiceQuestion);
                                questionCreatedEvents.add(questionCreatedEvent);
                            });
                    break;
                default:
                    throw new IllegalArgumentException("Invalid question type");
            }
        });

        return questionCreatedEvents;
    }

    private void saveAnswer(AnswerOfQuestion answerOfQuestion) {
        AnswerOfQuestion savedAnswer = answerOfQuestionRepository.saveAnswerOfQuestion(answerOfQuestion);

        if (savedAnswer == null) {
            log.error("Could not save answer");

            throw new CoreDomainException("Could not save answer");
        }
        log.info("Answer saved with id {} and questionId {}", savedAnswer.getId().getValue(), savedAnswer.getId().getValue());
    }

    private Organization getOrganization(UUID organizationId) {
        Optional<Organization> organization = organizationRepository.findOrganization(organizationId);
        if (organization.isEmpty()) {
            log.warn("Organization with id: {} not found", organizationId);
            throw new CoreDomainException("Could not find organization with id: " + organizationId);
        }
        return organization.get();
    }

    private User getUser(UUID userId) {
        Optional<User> user = userRepository.findUser(userId);
        if (user.isEmpty()) {
            log.warn("User with id: {} not found", userId);
            throw new UserNotFoundException("Could not find user with id: " + userId);
        }
        return user.get();
    }

    private List<com.backend.programming.learning.system.core.service.domain.dto.method.create.question.AnswerOfQuestion> answerOfQuestionListToAnswerOfQuestionEntityList(List<AnswerOfQuestion> answers) {
        return answers
                .stream()
                .map(answerOfQuestion -> com.backend.programming.learning.system.core.service.domain.dto.method.create.question.AnswerOfQuestion.builder()
                        .answer(answerOfQuestion.getAnswer())
                        .fraction(answerOfQuestion.getFraction())
                        .feedback(answerOfQuestion.getFeedback())
                        .build())
                .toList();
    }

    @Override
    public Page<Question> findAllQuestionWithPagination(String qtype, String searchName, int pageNo, int pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);

        return questionJpaRepository.findAllQuestionWithPagination(qtype, searchName, paging)
                .map(questionDataAccessMapper::questionEntityToQuestion);
    }

    @Override
    public List<Question> findQuestionsByIds(List<UUID> uuids) {
        return questionJpaRepository.findAllById(uuids)
                .stream()
                .map(questionDataAccessMapper::questionEntityToQuestion)
                .toList();
    }
}
