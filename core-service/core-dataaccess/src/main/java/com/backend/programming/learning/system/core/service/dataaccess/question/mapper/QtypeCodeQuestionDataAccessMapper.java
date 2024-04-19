package com.backend.programming.learning.system.core.service.dataaccess.question.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QtypeCodeQuestionEntity;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeCodeQuestion;
import com.backend.programming.learning.system.domain.valueobject.QtypeCodeQuestionId;
import org.springframework.stereotype.Component;

@Component
public class QtypeCodeQuestionDataAccessMapper {
    private final QuestionDataAccessMapper questionDataAccessMapper;

    public QtypeCodeQuestionDataAccessMapper(QuestionDataAccessMapper questionDataAccessMapper) {
        this.questionDataAccessMapper = questionDataAccessMapper;
    }

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
//        if (qtypeCodeQuestion.getId() != null)
//            qtypeCodeQuestionEntity.setId(qtypeCodeQuestion.getId().getValue());
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
}
