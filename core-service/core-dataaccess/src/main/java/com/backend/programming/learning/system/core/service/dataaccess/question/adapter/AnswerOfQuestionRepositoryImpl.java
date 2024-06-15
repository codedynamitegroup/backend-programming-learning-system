package com.backend.programming.learning.system.core.service.dataaccess.question.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.question.entity.AnswerOfQuestionEntity;
import com.backend.programming.learning.system.core.service.dataaccess.question.mapper.AnswerOfQuestionDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.question.repository.AnswerOfQuestionJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.AnswerOfQuestion;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.AnswerOfQuestionRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class AnswerOfQuestionRepositoryImpl implements AnswerOfQuestionRepository {
    private final AnswerOfQuestionJpaRepository answerOfQuestionJpaRepository;
    private final AnswerOfQuestionDataAccessMapper answerOfQuestionDataAccessMapper;

    public AnswerOfQuestionRepositoryImpl(AnswerOfQuestionJpaRepository answerOfQuestionJpaRepository,
                                          AnswerOfQuestionDataAccessMapper answerOfQuestionDataAccessMapper) {
        this.answerOfQuestionJpaRepository = answerOfQuestionJpaRepository;
        this.answerOfQuestionDataAccessMapper = answerOfQuestionDataAccessMapper;
    }

    @Override
    public AnswerOfQuestion saveAnswerOfQuestion(AnswerOfQuestion answerOfQuestion) {
        return answerOfQuestionDataAccessMapper.answerOfQuestionEntityToAnswerOfQuestion(answerOfQuestionJpaRepository
                .save(answerOfQuestionDataAccessMapper
                        .answerOfQuestionToAnswerOfQuestionEntity(answerOfQuestion)));
    }

    @Override
    public List<AnswerOfQuestion> saveAllAnswerOfQuestion(List<AnswerOfQuestion> answerOfQuestionList) {
        return answerOfQuestionJpaRepository
                .saveAll(answerOfQuestionDataAccessMapper
                        .answerOfQuestionListToAnswerOfQuestionEntityList(answerOfQuestionList))
                .stream()
                .map(answerOfQuestionDataAccessMapper::answerOfQuestionEntityToAnswerOfQuestion)
                .toList();
    }

    @Override
    public void deleteAnswerOfQuestion(UUID answerId) {
        answerOfQuestionJpaRepository.deleteById(answerId);
    }

    @Override
    public void deleteAllAnswerOfQuestionByQuestionId(UUID questionId) {
        answerOfQuestionJpaRepository.deleteByQuestionId(questionId);
    }

    @Override
    public Optional<AnswerOfQuestion> getAnswerOfQuestionById(UUID answerId) {
        return answerOfQuestionJpaRepository.findById(answerId)
                .map(answerOfQuestionDataAccessMapper::answerOfQuestionEntityToAnswerOfQuestion);
    }

    @Override
    public List<AnswerOfQuestion> updateAllAnswerOfQuestion(List<AnswerOfQuestion> answerOfQuestionList) {
        List<AnswerOfQuestionEntity> answerOfQuestionEntityList = answerOfQuestionJpaRepository.findAllById(
                answerOfQuestionList.stream()
                        .map(answerOfQuestion -> answerOfQuestion.getId().getValue())
                        .toList());

        answerOfQuestionEntityList = answerOfQuestionDataAccessMapper.setAnswerOfQuestionEntityList(answerOfQuestionEntityList, answerOfQuestionList);

        return answerOfQuestionJpaRepository.saveAll(answerOfQuestionEntityList)
                .stream()
                .map(answerOfQuestionDataAccessMapper::answerOfQuestionEntityToAnswerOfQuestion)
                .toList();
    }

    @Override
    public List<AnswerOfQuestion> getAllAnswerOfQuestionByQuestionId(UUID questionId) {
        return answerOfQuestionJpaRepository.findAllByQuestionId(questionId)
                .stream()
                .map(answerOfQuestionDataAccessMapper::answerOfQuestionEntityToAnswerOfQuestion)
                .toList();
    }

    @Transactional
    @Override
    public void deleteAllById(List<UUID> answerIds) {
        answerOfQuestionJpaRepository.deleteAllByIdInQuery(answerIds);
    }
}
