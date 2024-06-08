package com.backend.programming.learning.system.core.service.dataaccess.question.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QtypeCodeQuestionEntity;
import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QtypeEssayQuestionEntity;
import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QtypeMultichoiceQuestionEntity;
import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QtypeShortanswerQuestionEntity;
import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QuestionEntity;
import com.backend.programming.learning.system.core.service.dataaccess.question.mapper.QuestionDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.question.repository.QtypeCodeQuestionJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.question.repository.QtypeEssayQuestionJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.question.repository.QtypeMultichoiceQuestionJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.question.repository.QtypeShortanswerQuestionJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.question.repository.QuestionJpaRepository;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQuestionClone;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.question.QueryAllQuestionByCategoryIdCommand;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.question.QuestionResponseEntity;
import com.backend.programming.learning.system.core.service.domain.entity.Question;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.QtypeCodeQuestionRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.QtypeEssayQuestionRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.QtypeMultichoiceQuestionRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.QtypeShortanswerQuestionRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.QuestionRepository;
import com.backend.programming.learning.system.domain.exception.question.QuestionNotFoundException;
import com.backend.programming.learning.system.domain.valueobject.QuestionType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Component
public class QuestionRepositoryImpl implements QuestionRepository {
    private final QuestionJpaRepository questionJpaRepository;
    private final QtypeCodeQuestionJpaRepository qtypeCodeQuestionJpaRepository;
    private final QtypeEssayQuestionJpaRepository qtypeEssayQuestionJpaRepository;
    private final QtypeMultichoiceQuestionJpaRepository qtypeMultichoiceQuestionJpaRepository;
    private final QtypeShortanswerQuestionJpaRepository qtypeShortanswerQuestionJpaRepository;
    private final QuestionDataAccessMapper questionDataAccessMapper;

    public QuestionRepositoryImpl(QuestionJpaRepository questionJpaRepository, QtypeCodeQuestionRepositoryImpl qtypeCodeQuestionRepository, QtypeEssayQuestionRepositoryImpl qtypeEssayQuestionRepository, QtypeCodeQuestionRepository qtypeCodeQuestionRepository1, QtypeEssayQuestionRepository qtypeEssayQuestionRepository1, QtypeMultichoiceQuestionRepository qtypeMultichoiceQuestionRepository, QtypeShortanswerQuestionRepository qtypeShortanswerQuestionRepository, QtypeCodeQuestionJpaRepository qtypeCodeQuestionJpaRepository, QtypeEssayQuestionJpaRepository qtypeEssayQuestionJpaRepository, QtypeMultichoiceQuestionJpaRepository qtypeMultichoiceQuestionJpaRepository, QtypeShortanswerQuestionJpaRepository qtypeShortanswerQuestionJpaRepository,
                                  QuestionDataAccessMapper questionDataAccessMapper) {
        this.questionJpaRepository = questionJpaRepository;
        this.qtypeCodeQuestionJpaRepository = qtypeCodeQuestionJpaRepository;
        this.qtypeEssayQuestionJpaRepository = qtypeEssayQuestionJpaRepository;
        this.qtypeMultichoiceQuestionJpaRepository = qtypeMultichoiceQuestionJpaRepository;
        this.qtypeShortanswerQuestionJpaRepository = qtypeShortanswerQuestionJpaRepository;
        this.questionDataAccessMapper = questionDataAccessMapper;
    }

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
                                case MULTIPLE_CHOICE:
                                    qtypeMultichoiceQuestionJpaRepository.findByQuestionId(id)
                                            .ifPresent(qtypeMultichoiceQuestionJpaRepository::delete);
                                    break;
                                case SHORT_ANSWER:
                                    qtypeShortanswerQuestionJpaRepository.findByQuestionId(id)
                                            .ifPresent(qtypeShortanswerQuestionJpaRepository::delete);
                                    break;
                                case TRUE_FALSE:
                                    qtypeMultichoiceQuestionJpaRepository.findByQuestionId(id)
                                            .ifPresent(qtypeMultichoiceQuestionJpaRepository::delete);
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

        if (questionEntity.isEmpty()) {
            throw new QuestionNotFoundException("Question not found with id: " + question.getId().getValue());
        }

        questionJpaRepository.save(questionDataAccessMapper.setQuestionEntity(questionEntity.get(), question));
    }

    @Override
    public Page<QuestionResponseEntity> findAllQuestionByCategory(
            UUID categoryId,
            QueryAllQuestionByCategoryIdCommand queryAllQuestionByCategoryIdCommand) {
        Pageable pageRequest = Pageable.ofSize(queryAllQuestionByCategoryIdCommand.getPageSize())
                .withPage(queryAllQuestionByCategoryIdCommand.getPageNo());
        return questionJpaRepository
                .findAllByQuestionBankCategoryId(categoryId,
                        queryAllQuestionByCategoryIdCommand.getIsOrgQuestionBank(),
                        queryAllQuestionByCategoryIdCommand.getSearch(),
                        pageRequest)
                .map(questionDataAccessMapper::questionEntityToQuestionResponseEntity);
    }

    @Override
    public List<Question> cloneQuestion(List<CreateQuestionClone> questionClones) {
        Map<UUID, QuestionEntity> questionMap = new HashMap<>();
        List<QuestionEntity> questionEntities = questionJpaRepository.findAllById(questionClones
                        .stream()
                        .map(CreateQuestionClone::questionId)
                        .toList())
                .stream()
                .peek(questionEntity -> questionMap
                        .put(questionEntity.getId(), questionDataAccessMapper.cloneQuestionEntity(questionEntity)))
                .toList();

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
                            });
                    break;
                case "MULTIPLE_CHOICE":
                    qtypeMultichoiceQuestionJpaRepository.findByQuestionId(createQuestionClone.questionId())
                            .ifPresent(qtypeMultichoiceQuestion -> {
                                QuestionEntity newQuestion = questionMap.get(createQuestionClone.questionId());
                                QtypeMultichoiceQuestionEntity qtypeMultichoiceQuestionSave =
                                        questionDataAccessMapper.cloneQtypeMultichoiceQuestionEntity(qtypeMultichoiceQuestion, newQuestion);
                                qtypeMultichoiceQuestionJpaRepository.save(qtypeMultichoiceQuestionSave);
                            });
                    break;
                case "SHORT_ANSWER":
                    qtypeShortanswerQuestionJpaRepository.findByQuestionId(createQuestionClone.questionId())
                            .ifPresent(qtypeShortanswerQuestion -> {
                                QuestionEntity newQuestion = questionMap.get(createQuestionClone.questionId());
                                QtypeShortanswerQuestionEntity qtypeShortanswerQuestionSave =
                                        questionDataAccessMapper.cloneQtypeShortanswerQuestionEntity(qtypeShortanswerQuestion, newQuestion);

                                qtypeShortanswerQuestionJpaRepository.save(qtypeShortanswerQuestionSave);
                            });
                    break;
                case "TRUE_FALSE":
                    qtypeMultichoiceQuestionJpaRepository.findByQuestionId(createQuestionClone.questionId())
                            .ifPresent(qtypeMultichoiceQuestion -> {
                                QuestionEntity newQuestion = questionMap.get(createQuestionClone.questionId());
                                QtypeMultichoiceQuestionEntity qtypeMultichoiceQuestionSave =
                                        questionDataAccessMapper.cloneQtypeMultichoiceQuestionEntity(qtypeMultichoiceQuestion, newQuestion);
                                qtypeMultichoiceQuestionJpaRepository.save(qtypeMultichoiceQuestionSave);
                            });
                    break;
                default:
                    throw new IllegalArgumentException("Invalid question type");
            }
        });

        return questionEntities
                .stream()
                .map(questionDataAccessMapper::questionEntityToQuestion)
                .toList();
    }
}
