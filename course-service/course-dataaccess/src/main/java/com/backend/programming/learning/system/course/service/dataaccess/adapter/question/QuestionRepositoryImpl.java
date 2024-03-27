package com.backend.programming.learning.system.course.service.dataaccess.adapter.question;

import com.backend.programming.learning.system.course.service.dataaccess.entity.exam.question.ExamQuestionEntity;
import com.backend.programming.learning.system.course.service.dataaccess.entity.question.QuestionEntity;
import com.backend.programming.learning.system.course.service.dataaccess.mapper.question.QuestionDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.repository.exam.question.ExamQuestionJpaRepository;
import com.backend.programming.learning.system.course.service.dataaccess.repository.question.QuestionJpaRepository;
import com.backend.programming.learning.system.course.service.domain.entity.question.Question;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.question.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

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
    private final ExamQuestionJpaRepository examQuestionJpaRepository;
    private final QuestionDataAccessMapper questionDataAccessMapper;
    @Override
    public Question createQuestion(Long examId, Question question) {
        Question savedQuestion = questionDataAccessMapper.questionEntityToQuestion(
                questionJpaRepository.save(questionDataAccessMapper.questionToQuestionEntity(question)));
        examQuestionJpaRepository.save(ExamQuestionEntity.builder()
                .examId(examId)
                .questionId(savedQuestion.getId())
                .build());
        return savedQuestion;
    }

    @Override
    public List<Question> getQuestionsByExamId(Long examId) {
        return questionJpaRepository.getQuestionsByExamId(examId)
                .stream().map(questionDataAccessMapper::questionEntityToQuestion)
                .toList();
    }

    @Override
    public void deleteQuestion(Long examId, Long questionId) {
        examQuestionJpaRepository.deleteByExamIdAndQuestionId(examId, questionId);
        questionJpaRepository.deleteById(questionId);
    }

    @Override
    public Question getQuestionById(Long questionId) {
        return questionDataAccessMapper.questionEntityToQuestion(
                questionJpaRepository.findById(questionId)
                        .orElseThrow(() -> new RuntimeException("Question not found")));
    }

    @Override
    public Question updateQuestion(Long examId, Long questionId, Question question) {
        QuestionEntity questionEntity = questionJpaRepository.findById(questionId)
                .orElseThrow(() -> new RuntimeException("Question not found"));
        QuestionEntity updatedQuestionEntity = questionDataAccessMapper.updateQuestionEntity(questionEntity, question);
        return questionDataAccessMapper.questionEntityToQuestion(
                questionJpaRepository.save(updatedQuestionEntity));
    }
}
