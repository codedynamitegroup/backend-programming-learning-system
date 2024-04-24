package com.backend.programming.learning.system.core.service.dataaccess.question.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QtypeShortanswerQuestionEntity;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeShortAnswerQuestion;
import com.backend.programming.learning.system.domain.valueobject.QtypeShortAnswerQuestionId;
import org.springframework.stereotype.Component;

@Component
public class QtypeShortanswerQuestionDataAccessMapper {
    private final QuestionDataAccessMapper questionDataAccessMapper;

    public QtypeShortanswerQuestionDataAccessMapper(QuestionDataAccessMapper questionDataAccessMapper) {
        this.questionDataAccessMapper = questionDataAccessMapper;
    }

    public QtypeShortanswerQuestionEntity qtypeShortanswerQuestionToQtypeShortanswerQuestionEntity(
            QtypeShortAnswerQuestion qtypeShortanswerQuestion) {
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

    public QtypeShortanswerQuestionEntity setQtypeShortAnswerQuestionEntity(QtypeShortanswerQuestionEntity qtypeShortanswerQuestionEntity, QtypeShortAnswerQuestion qtypeShortAnswerQuestion) {
//        qtypeShortanswerQuestionEntity.setId(qtypeShortAnswerQuestion.getId().getValue());
        if (qtypeShortAnswerQuestion.getQuestion() != null)
            qtypeShortanswerQuestionEntity.setQuestion(questionDataAccessMapper.setQuestionEntity(qtypeShortanswerQuestionEntity.getQuestion(), qtypeShortAnswerQuestion.getQuestion()));
        if (qtypeShortAnswerQuestion.getCaseSensitive() != null)
            qtypeShortanswerQuestionEntity.setCaseSensitive(qtypeShortAnswerQuestion.getCaseSensitive());
        return qtypeShortanswerQuestionEntity;
    }
}
