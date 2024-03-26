package com.backend.programming.learning.system.course.service.dataaccess.adapter.question;

import com.backend.programming.learning.system.course.service.dataaccess.mapper.question.QuestionDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.repository.question.QuestionJpaRepository;
import com.backend.programming.learning.system.course.service.domain.entity.question.Question;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.question.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * com.backend.programming.learning.system.course.service.dataaccess.adapter.question
 * Create by Dang Ngoc Tien
 * Date 3/26/2024 - 10:36 PM
 * Description: ...
 */
@Component
@RequiredArgsConstructor
public class QuestionRepositoryImpl implements QuestionRepository {
    private final QuestionJpaRepository questionJpaRepository;
    private final QuestionDataAccessMapper questionDataAccessMapper;
    @Override
    public Question createQuestion(Question question) {
        return questionDataAccessMapper.questionEntityToQuestion(
                questionJpaRepository.save(questionDataAccessMapper.questionToQuestionEntity(question)));
    }
}
