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
        if (qtypeCodeQuestion.getProblemStatement() != null)
            builder.problemStatement(qtypeCodeQuestion.getProblemStatement());
        if (qtypeCodeQuestion.getCodeQuestionName() != null)
            builder.name(qtypeCodeQuestion.getCodeQuestionName());
        if (qtypeCodeQuestion.getMaxGrade() != null)
            builder.maxGrade(qtypeCodeQuestion.getMaxGrade());
        if (qtypeCodeQuestion.getPublic() != null)
            builder.isPublic(qtypeCodeQuestion.getPublic());
        if (qtypeCodeQuestion.getAllowedToImport() != null)
            builder.isAllowedToImport(qtypeCodeQuestion.getAllowedToImport());

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
        if (qtypeCodeQuestion.getProblemStatement() != null)
            qtypeCodeQuestionEntity.setProblemStatement(qtypeCodeQuestion.getProblemStatement());
        if (qtypeCodeQuestion.getCodeQuestionName() != null)
            qtypeCodeQuestionEntity.setName(qtypeCodeQuestion.getCodeQuestionName());

        return qtypeCodeQuestionEntity;
    }

    public QtypeCodeQuestion qtypeCodeQuestionEntityToQtypeCodeQuestion(QtypeCodeQuestionEntity qtypeCodeQuestionEntity) {
        return QtypeCodeQuestion.builder()
                .id(new QtypeCodeQuestionId(qtypeCodeQuestionEntity.getId()))
                .question(questionDataAccessMapper.questionEntityToQuestion(qtypeCodeQuestionEntity.getQuestion()))
                .dslTemplate(qtypeCodeQuestionEntity.getDslTemplate())
                .problemStatement(qtypeCodeQuestionEntity.getProblemStatement())
                .codeQuestionName(qtypeCodeQuestionEntity.getName())
                .isPublic(qtypeCodeQuestionEntity.getIsPublic())
                .isAllowedToImport(qtypeCodeQuestionEntity.getIsAllowedToImport())
                .maxGrade(qtypeCodeQuestionEntity.getMaxGrade())
                .build();
    }
}
