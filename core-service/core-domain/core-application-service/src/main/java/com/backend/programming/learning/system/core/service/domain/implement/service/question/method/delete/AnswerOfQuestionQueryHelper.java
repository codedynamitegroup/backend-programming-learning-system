package com.backend.programming.learning.system.core.service.domain.implement.service.question.method.delete;

import com.backend.programming.learning.system.core.service.domain.dto.method.query.question.QueryAnswerOfQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.entity.AnswerOfQuestion;
import com.backend.programming.learning.system.core.service.domain.mapper.question.QuestionDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.AnswerOfQuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.core.service.domain.implement.service.question.method.delete
 * Create by Dang Ngoc Tien
 * Date 6/27/2024 - 10:49 AM
 * Description: ...
 */
@Component
@RequiredArgsConstructor
public class AnswerOfQuestionQueryHelper {
    private final AnswerOfQuestionRepository answerOfQuestionRepository;
    private final QuestionDataMapper questionDataMapper;

    public List<QueryAnswerOfQuestionResponse> getAnswerOfQuestionByQuestionId(UUID questionId) {
        List<AnswerOfQuestion> answerOfQuestions = answerOfQuestionRepository.getAllAnswerOfQuestionByQuestionId(questionId);
        return questionDataMapper.answerOfQuestionToQueryAnswerOfQuestionResponse(answerOfQuestions);
    }
}
