package com.backend.programming.learning.system.core.service.dataaccess.question.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QtypeCodeQuestionEntity;
import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QtypeEssayQuestionEntity;
import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QtypeMultichoiceQuestionEntity;
import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QtypeShortanswerQuestionEntity;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeCodeQuestion;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeEssayQuestion;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeMultiChoiceQuestion;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeShortAnswerQuestion;
import com.backend.programming.learning.system.domain.valueobject.QtypeCodeQuestionId;
import com.backend.programming.learning.system.domain.valueobject.QtypeEssayQuestionId;
import com.backend.programming.learning.system.domain.valueobject.QtypeMultiChoiceQuestionId;
import com.backend.programming.learning.system.domain.valueobject.QtypeShortAnswerQuestionId;
import org.springframework.stereotype.Component;

@Component
public class QtypeQuestionDataAccessMapper {
    private final QuestionDataAccessMapper questionDataAccessMapper;

    public QtypeQuestionDataAccessMapper(QuestionDataAccessMapper questionDataAccessMapper) {
        this.questionDataAccessMapper = questionDataAccessMapper;
    }

    // code
    public QtypeCodeQuestionEntity qtypeCodeQuestionToQtypeCodeQuestionEntity(QtypeCodeQuestion qtypeCodeQuestion) {
        QtypeCodeQuestionEntity.QtypeCodeQuestionEntityBuilder builder = QtypeCodeQuestionEntity.builder();

        if (qtypeCodeQuestion.getId() != null)
            builder.id(qtypeCodeQuestion.getId().getValue());
        if (qtypeCodeQuestion.getQuestion() != null)
            builder.question(questionDataAccessMapper.questionToQuestionEntity(qtypeCodeQuestion.getQuestion()));
        if (qtypeCodeQuestion.getDslTemplate() != null)
            builder.dslTemplate(qtypeCodeQuestion.getDslTemplate());

        return builder.build();
    }

    public QtypeCodeQuestionEntity setQtypeCodeQuestionEntity(QtypeCodeQuestionEntity qtypeCodeQuestionEntity,
                                                              QtypeCodeQuestion qtypeCodeQuestion) {
        if (qtypeCodeQuestion.getId() != null)
            qtypeCodeQuestionEntity.setId(qtypeCodeQuestion.getId().getValue());
        if (qtypeCodeQuestion.getQuestion() != null)
            qtypeCodeQuestionEntity.setQuestion(questionDataAccessMapper.setQuestionEntity(qtypeCodeQuestionEntity.getQuestion(), qtypeCodeQuestion.getQuestion()));
        if (qtypeCodeQuestion.getDslTemplate() != null)
            qtypeCodeQuestionEntity.setDslTemplate(qtypeCodeQuestion.getDslTemplate());

        return qtypeCodeQuestionEntity;
    }

    public QtypeCodeQuestion qtypeCodeQuestionEntityToQtypeCodeQuestion(QtypeCodeQuestionEntity qtypeCodeQuestionEntity) {
        return QtypeCodeQuestion.builder()
                .id(new QtypeCodeQuestionId(qtypeCodeQuestionEntity.getId()))
                .question(questionDataAccessMapper.questionEntityToQuestion(qtypeCodeQuestionEntity.getQuestion()))
                .dslTemplate(qtypeCodeQuestionEntity.getDslTemplate())
                .build();
    }

    // short answer
    public QtypeShortanswerQuestionEntity qtypeShortanswerQuestionToQtypeShortanswerQuestionEntity(QtypeShortAnswerQuestion qtypeShortanswerQuestion) {
        return QtypeShortanswerQuestionEntity.builder()
                .id(qtypeShortanswerQuestion.getId().getValue())
                .question(questionDataAccessMapper.questionToQuestionEntity(qtypeShortanswerQuestion.getQuestion()))
                .caseSensitive(qtypeShortanswerQuestion.getCaseSensitive())
                .build();
    }

    public QtypeShortAnswerQuestion qtypeShortanswerQuestionEntityToQtypeShortanswerQuestion(QtypeShortanswerQuestionEntity qtypeShortanswerQuestionEntity) {
        return QtypeShortAnswerQuestion.builder()
                .id(new QtypeShortAnswerQuestionId(qtypeShortanswerQuestionEntity.getId()))
                .question(questionDataAccessMapper.questionEntityToQuestion(qtypeShortanswerQuestionEntity.getQuestion()))
                .caseSensitive(qtypeShortanswerQuestionEntity.getCaseSensitive())
                .build();
    }

    // multiple choice
    public QtypeMultichoiceQuestionEntity qtypeMultichoiceQuestionToQtypeMultichoiceQuestionEntity(QtypeMultiChoiceQuestion qtypeMultichoiceQuestion) {
        return QtypeMultichoiceQuestionEntity.builder()
                .id(qtypeMultichoiceQuestion.getId().getValue())
                .question(questionDataAccessMapper.questionToQuestionEntity(qtypeMultichoiceQuestion.getQuestion()))
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
                .id(new QtypeMultiChoiceQuestionId(qtypeMultichoiceQuestionEntity.getId()))
                .question(questionDataAccessMapper.questionEntityToQuestion(qtypeMultichoiceQuestionEntity.getQuestion()))
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
                .id(qtypeEssayQuestion.getId().getValue())
                .question(questionDataAccessMapper.questionToQuestionEntity(qtypeEssayQuestion.getQuestion()))
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
                .id(new QtypeEssayQuestionId(qtypeEssayQuestionEntity.getId()))
                .question(questionDataAccessMapper.questionEntityToQuestion(qtypeEssayQuestionEntity.getQuestion()))
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
