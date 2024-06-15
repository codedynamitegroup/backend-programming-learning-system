package com.backend.programming.learning.system.course.service.dataaccess.answer_of_question.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.answer_of_question.mapper.AnswerOfQuestionDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.answer_of_question.repository.AnswerOfQuestionJpaRepository;
import com.backend.programming.learning.system.course.service.domain.entity.AnswerOfQuestion;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.AnswerOfQuestionRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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

    @Transactional
    @Override
    public List<AnswerOfQuestion> saveAnswerOfQuestion(List<AnswerOfQuestion> answerList) {
        return answerOfQuestionDataAccessMapper
                .answerOfQuestionEntityListToAnswerOfQuestionList(answerOfQuestionJpaRepository
                        .saveAll(answerOfQuestionDataAccessMapper
                                .answerOfQuestionListToAnswerOfQuestionEntityList(answerList)));
    }

    @Transactional
    @Override
    public void deleteAnswerOfQuestionByQuestionId(List<UUID> answerOfQuestionIdList) {
        answerOfQuestionJpaRepository.deleteAllByIdInQuery(answerOfQuestionIdList);
    }

    @Override
    public List<AnswerOfQuestion> findAllByQuestionId(UUID questionId) {
        return answerOfQuestionDataAccessMapper.answerOfQuestionEntityListToAnswerOfQuestionList(
                answerOfQuestionJpaRepository.findAllByQuestionId(questionId));
    }

    @Transactional
    @Override
    public void deleteAllByQuestionId(UUID questionId) {
        answerOfQuestionJpaRepository.deleteAllByQuestionId(questionId);
    }
}
