package com.backend.programming.learning.system.core.service.dataaccess.question.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QtypeCodeQuestionEntity;
import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QtypeEssayQuestionEntity;
import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QtypeMultichoiceQuestionEntity;
import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QtypeShortanswerQuestionEntity;
import com.backend.programming.learning.system.domain.entity.QtypeCodeQuestion;
import com.backend.programming.learning.system.domain.entity.QtypeEssayQuestion;
import com.backend.programming.learning.system.domain.entity.QtypeMultiChoiceQuestion;
import com.backend.programming.learning.system.domain.entity.QtypeShortAnswerQuestion;
import com.backend.programming.learning.system.domain.valueobject.QuestionId;
import org.springframework.stereotype.Component;

@Component
public class QtypeQuestionDataAccessMapper {
    // code
    public QtypeCodeQuestionEntity qtypeCodeQuestionToQtypeCodeQuestionEntity(QtypeCodeQuestion qtypeCodeQuestion) {
        return QtypeCodeQuestionEntity.builder()
                .questionId(qtypeCodeQuestion.getQuestionId().getValue())
                .dslTemplate(qtypeCodeQuestion.getDslTemplate())
                .build();
    }
    public QtypeCodeQuestion qtypeCodeQuestionEntityToQtypeCodeQuestion(QtypeCodeQuestionEntity qtypeCodeQuestionEntity) {
        return QtypeCodeQuestion.builder()
                .questionId(new QuestionId(qtypeCodeQuestionEntity.getQuestionId()))
                .dslTemplate(qtypeCodeQuestionEntity.getDslTemplate())
                .build();
    }

    // short answer
    public QtypeShortanswerQuestionEntity qtypeShortanswerQuestionToQtypeShortanswerQuestionEntity(QtypeShortAnswerQuestion qtypeShortanswerQuestion) {
        return QtypeShortanswerQuestionEntity.builder()
                .questionId(qtypeShortanswerQuestion.getQuestionId().getValue())
                .caseSensitive(qtypeShortanswerQuestion.getCaseSensitive())
                .build();
    }

    public QtypeShortAnswerQuestion qtypeShortanswerQuestionEntityToQtypeShortanswerQuestion(QtypeShortanswerQuestionEntity qtypeShortanswerQuestionEntity) {
        return QtypeShortAnswerQuestion.builder()
                .questionId(new QuestionId(qtypeShortanswerQuestionEntity.getQuestionId()))
                .caseSensitive(qtypeShortanswerQuestionEntity.getCaseSensitive())
                .build();
    }

    // multiple choice
    public QtypeMultichoiceQuestionEntity qtypeMultichoiceQuestionToQtypeMultichoiceQuestionEntity(QtypeMultiChoiceQuestion qtypeMultichoiceQuestion) {
        return QtypeMultichoiceQuestionEntity.builder()
                .questionId(qtypeMultichoiceQuestion.getQuestionId().getValue())
                .single(qtypeMultichoiceQuestion.getSingle())
                .shuffleAnswers(qtypeMultichoiceQuestion.getShuffleAnswers())
                .correctFeedback(qtypeMultichoiceQuestion.getCorrectFeedback())
                .partiallyCorrectFeedback(qtypeMultichoiceQuestion.getPartiallyCorrectFeedback())
                .incorrectFeedback(qtypeMultichoiceQuestion.getIncorrectFeedback())
                .answerNumbering(qtypeMultichoiceQuestion.getAnswerNumbering())
                .showNumCorrect(qtypeMultichoiceQuestion.getShowNumCorrect())
                .showStandardInstruction(qtypeMultichoiceQuestion.getShowStandardInstructions())
                .build();
    }

    public QtypeMultiChoiceQuestion qtypeMultichoiceQuestionEntityToQtypeMultichoiceQuestion(QtypeMultichoiceQuestionEntity qtypeMultichoiceQuestionEntity) {
        return QtypeMultiChoiceQuestion.builder()
                .questionId(new QuestionId(qtypeMultichoiceQuestionEntity.getQuestionId()))
                .single(qtypeMultichoiceQuestionEntity.getSingle())
                .shuffleAnswers(qtypeMultichoiceQuestionEntity.getShuffleAnswers())
                .correctFeedback(qtypeMultichoiceQuestionEntity.getCorrectFeedback())
                .partiallyCorrectFeedback(qtypeMultichoiceQuestionEntity.getPartiallyCorrectFeedback())
                .incorrectFeedback(qtypeMultichoiceQuestionEntity.getIncorrectFeedback())
                .answerNumbering(qtypeMultichoiceQuestionEntity.getAnswerNumbering())
                .showNumCorrect(qtypeMultichoiceQuestionEntity.getShowNumCorrect())
                .showStandardInstructions(qtypeMultichoiceQuestionEntity.getShowStandardInstruction())
                .build();
    }

    // essay
    public QtypeEssayQuestionEntity qtypeEssayQuestionToQtypeEssayQuestionEntity(QtypeEssayQuestion qtypeEssayQuestion) {
        return QtypeEssayQuestionEntity.builder()
                .questionId(qtypeEssayQuestion.getQuestionId().getValue())
                .responseFormat(qtypeEssayQuestion.getResponseFormat())
                .responseRequired(qtypeEssayQuestion.getResponseRequired())
                .responseFieldLines(qtypeEssayQuestion.getResponseFieldLines())
                .minWordLimit(qtypeEssayQuestion.getMinWordLimit())
                .maxWordLimit(qtypeEssayQuestion.getMaxWordLimit())
                .attachments(qtypeEssayQuestion.getAttachments())
                .attachmentsRequired(qtypeEssayQuestion.getAttachmentsRequired())
                .graderInfo(qtypeEssayQuestion.getGraderInfo())
                .graderInfoFormat(qtypeEssayQuestion.getGraderInfoFormat())
                .responseTemplate(qtypeEssayQuestion.getResponseTemplate())
                .maxBytes(qtypeEssayQuestion.getMaxBytes())
                .fileTypesList(qtypeEssayQuestion.getFileTypesList())
                .build();
    }

    public QtypeEssayQuestion qtypeEssayQuestionEntityToQtypeEssayQuestion(QtypeEssayQuestionEntity qtypeEssayQuestionEntity) {
        return QtypeEssayQuestion.builder()
                .questionId(new QuestionId(qtypeEssayQuestionEntity.getQuestionId()))
                .responseFormat(qtypeEssayQuestionEntity.getResponseFormat())
                .responseRequired(qtypeEssayQuestionEntity.getResponseRequired())
                .responseFieldLines(qtypeEssayQuestionEntity.getResponseFieldLines())
                .minWordLimit(qtypeEssayQuestionEntity.getMinWordLimit())
                .maxWordLimit(qtypeEssayQuestionEntity.getMaxWordLimit())
                .attachments(qtypeEssayQuestionEntity.getAttachments())
                .attachmentsRequired(qtypeEssayQuestionEntity.getAttachmentsRequired())
                .graderInfo(qtypeEssayQuestionEntity.getGraderInfo())
                .graderInfoFormat(qtypeEssayQuestionEntity.getGraderInfoFormat())
                .responseTemplate(qtypeEssayQuestionEntity.getResponseTemplate())
                .maxBytes(qtypeEssayQuestionEntity.getMaxBytes())
                .fileTypesList(qtypeEssayQuestionEntity.getFileTypesList())
                .build();
    }
}
