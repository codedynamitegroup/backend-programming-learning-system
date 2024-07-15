package com.backend.programming.learning.system.course.service.dataaccess.question.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.question.entity.QuestionEntity;
import com.backend.programming.learning.system.course.service.dataaccess.question.entity.QuestionExamDataAccessDTO;
import com.backend.programming.learning.system.course.service.dataaccess.question.mapper.QuestionDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.question.repository.QuestionJpaRepository;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.question.QuestionExamDTO;
import com.backend.programming.learning.system.course.service.domain.entity.Question;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class QuestionRepositoryImpl implements QuestionRepository {
    private final QuestionJpaRepository questionJpaRepository;
    private final QuestionDataAccessMapper questionDataAccessMapper;

    @Override
    public Question saveQuestion(Question question) {
        QuestionEntity entity = questionDataAccessMapper.questionToQuestionEntity(question);
        return questionDataAccessMapper.questionEntityToQuestion(questionJpaRepository.save(entity));
    }

    @Override
    public Page<Question> findAll(UUID questionBankCategoryId, String search, Integer page, Integer size) {
        if (Objects.isNull(questionBankCategoryId)) {
            return questionJpaRepository.findAll(search, PageRequest.of(page, size))
                    .map(questionDataAccessMapper::questionEntityToQuestion);
        }
        return questionJpaRepository.findAll(questionBankCategoryId, search, PageRequest.of(page, size))
                .map(questionDataAccessMapper::questionEntityToQuestion);
    }

    @Override
    public Optional<Question> findById(UUID questionId) {
        return questionJpaRepository
                .findById(questionId)
                .map(questionDataAccessMapper::questionEntityToQuestion);
    }

    @Override
    public void deleteById(UUID questionId) {
        questionJpaRepository.deleteById(questionId);
    }

    @Override
    public Page<Question> findAllByExamId(UUID examId, String search, int pageNo, int pageSize) {
        return questionJpaRepository.findAllByExamId(examId, search, PageRequest.of(pageNo, pageSize))
                .map(questionDataAccessMapper::questionEntityToQuestion);
    }

    @Override
    public List<QuestionExamDTO> findAllByExamId(
            UUID examId,
            String search,
            Integer pageCurrent) {
        List<QuestionExamDataAccessDTO> questionEntities = questionJpaRepository.findAllByExamId(
                examId, search, pageCurrent);
        return questionDataAccessMapper.questionEntitiesToQuestions(questionEntities);
    }
}
