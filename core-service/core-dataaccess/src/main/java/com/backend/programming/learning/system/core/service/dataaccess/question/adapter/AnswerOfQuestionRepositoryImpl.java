package com.backend.programming.learning.system.core.service.dataaccess.question.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.question.mapper.AnswerOfQuestionDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.question.repository.AnswerOfQuestionJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.AnswerOfQuestion;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.AnswerOfQuestionRepository;
import org.springframework.stereotype.Component;

import java.util.List;

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
}
