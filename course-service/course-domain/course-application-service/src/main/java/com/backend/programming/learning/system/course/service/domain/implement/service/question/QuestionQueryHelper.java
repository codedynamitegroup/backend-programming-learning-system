package com.backend.programming.learning.system.course.service.domain.implement.service.question;

import com.backend.programming.learning.system.course.service.domain.dto.method.query.question.QueryAllQuestionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.question.QueryAllQuestionExamCommand;
import com.backend.programming.learning.system.course.service.domain.entity.Question;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.QuestionRepository;
import com.backend.programming.learning.system.domain.exception.question.QuestionNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.implement.question
 * Create by Dang Ngoc Tien
 * Date 4/18/2024 - 2:36 AM
 * Description: ...
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class QuestionQueryHelper {
    private final QuestionRepository questionRepository;
    @Transactional(readOnly = true)
    public Page<Question> findAllQuestions(QueryAllQuestionCommand queryAllQuestionCommand) {
        return questionRepository.findAll(
                queryAllQuestionCommand.getQuestionBankCategoryId(),
                queryAllQuestionCommand.getSearch(),
                queryAllQuestionCommand.getPageNo(),
                queryAllQuestionCommand.getPageSize());
    }

    @Transactional(readOnly = true)
    public Question findById(UUID questionId) {
        Optional<Question> question = questionRepository.findById(questionId);

        if (question.isEmpty()) {
            log.error("Question not found with id: {}", questionId);
            throw new QuestionNotFoundException("Question not found with id: " + questionId);
        }

        return question.get();
    }

    public Page<Question> findAllQuestionsByExamId(QueryAllQuestionExamCommand queryAllQuestionCommand) {
        return questionRepository.findAllByExamId(
                queryAllQuestionCommand.examId(),
                queryAllQuestionCommand.search(),
                queryAllQuestionCommand.pageNo(),
                queryAllQuestionCommand.pageSize());
    }
}
