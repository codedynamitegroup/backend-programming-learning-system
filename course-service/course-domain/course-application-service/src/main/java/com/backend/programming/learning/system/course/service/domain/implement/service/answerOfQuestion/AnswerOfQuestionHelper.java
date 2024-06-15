package com.backend.programming.learning.system.course.service.domain.implement.service.answerOfQuestion;

import com.backend.programming.learning.system.course.service.domain.dto.method.message.AnswerOfQuestionMessage;
import com.backend.programming.learning.system.course.service.domain.entity.AnswerOfQuestion;
import com.backend.programming.learning.system.course.service.domain.mapper.answerOfQuestion.AnswerOfQuestionDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.AnswerOfQuestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Component
@Slf4j
public class AnswerOfQuestionHelper {
    private final AnswerOfQuestionRepository answerOfQuestionRepository;
    private final AnswerOfQuestionDataMapper  answerOfQuestionDataMapper;

    public AnswerOfQuestionHelper(
            AnswerOfQuestionRepository answerOfQuestionRepository,
            AnswerOfQuestionDataMapper answerOfQuestionDataMapper) {
        this.answerOfQuestionRepository = answerOfQuestionRepository;
        this.answerOfQuestionDataMapper = answerOfQuestionDataMapper;
    }

    @Transactional
    public void saveAnswerOfQuestion(List<AnswerOfQuestionMessage> answerOfQuestionMessageList) {
        List<AnswerOfQuestion> answerOfQuestionResult =  answerOfQuestionRepository
                .saveAnswerOfQuestion(answerOfQuestionDataMapper
                        .answerOfQuestionMessageListToAnswerOfQuestionList(answerOfQuestionMessageList));

        log.info("Answer of question list are created / updated with the following data: {}", answerOfQuestionResult);
    }

    @Transactional
    public void deleteAllByQuestionId(UUID questionId) {
        answerOfQuestionRepository.deleteAllByQuestionId(questionId);
    }

    @Transactional
    public void deleteAllById(List<UUID> answerOfQuestionIdList) {
        answerOfQuestionRepository.deleteAnswerOfQuestionByQuestionId(answerOfQuestionIdList);
    }

    public List<AnswerOfQuestion> findAllByQuestionId(UUID questionId) {
        return answerOfQuestionRepository.findAllByQuestionId(questionId);
    }
}
