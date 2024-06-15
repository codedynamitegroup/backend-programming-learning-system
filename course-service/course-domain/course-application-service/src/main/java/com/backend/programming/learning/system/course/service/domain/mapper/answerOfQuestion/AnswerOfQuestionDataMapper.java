package com.backend.programming.learning.system.course.service.domain.mapper.answerOfQuestion;

import com.backend.programming.learning.system.course.service.domain.dto.method.message.AnswerOfQuestionMessage;
import com.backend.programming.learning.system.course.service.domain.entity.AnswerOfQuestion;
import com.backend.programming.learning.system.course.service.domain.valueobject.AnswerOfQuestionId;
import com.backend.programming.learning.system.domain.valueobject.QuestionId;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class AnswerOfQuestionDataMapper {
    private AnswerOfQuestion answerOfQuestionMessageToAnswerOfQuestion(AnswerOfQuestionMessage answerOfQuestionMessage) {
        return AnswerOfQuestion.builder()
                .id(new AnswerOfQuestionId(UUID.fromString(answerOfQuestionMessage.getId())))
                .questionId(new QuestionId(UUID.fromString(answerOfQuestionMessage.getQuestionId())))
                .answer(answerOfQuestionMessage.getAnswer())
                .feedback(answerOfQuestionMessage.getFeedback())
                .fraction(answerOfQuestionMessage.getFraction())
                .build();
    }

    private AnswerOfQuestionMessage answerOfQuestionToAnswerOfQuestionMessage(AnswerOfQuestion answerOfQuestion) {
        return AnswerOfQuestionMessage.builder()
                .id(answerOfQuestion.getId().getValue().toString())
                .questionId(answerOfQuestion.getQuestionId().getValue().toString())
                .answer(answerOfQuestion.getAnswer())
                .feedback(answerOfQuestion.getFeedback())
                .fraction(answerOfQuestion.getFraction())
                .build();
    }

    public List<AnswerOfQuestion> answerOfQuestionMessageListToAnswerOfQuestionList(List<AnswerOfQuestionMessage> answerOfQuestionMessageList) {
        return answerOfQuestionMessageList.stream()
                .map(this::answerOfQuestionMessageToAnswerOfQuestion)
                .toList();
    }

    public List<AnswerOfQuestionMessage> answerOfQuestionListToAnswerOfQuestionMessageList(List<AnswerOfQuestion> answerOfQuestionList) {
        return answerOfQuestionList.stream()
                .map(this::answerOfQuestionToAnswerOfQuestionMessage)
                .toList();
    }
}
