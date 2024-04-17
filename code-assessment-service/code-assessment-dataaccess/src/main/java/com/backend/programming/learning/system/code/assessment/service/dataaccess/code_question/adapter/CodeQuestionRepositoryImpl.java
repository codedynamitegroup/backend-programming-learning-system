package com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.adapter;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.mapper.CodeQuestionDataAccessMapper;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.repository.CodeQuestionJpaRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeQuestion;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.CodeQuestionRepository;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;

import java.util.Optional;

public class CodeQuestionRepositoryImpl implements CodeQuestionRepository {
    private final CodeQuestionJpaRepository codeQuestionJpaRepository;
    private final CodeQuestionDataAccessMapper codeQuestionDataAccessMapper;

    public CodeQuestionRepositoryImpl
            (CodeQuestionJpaRepository codeQuestionJpaRepository
                    , CodeQuestionDataAccessMapper codeQuestionDataAccessMapper) {
        this.codeQuestionJpaRepository = codeQuestionJpaRepository;
        this.codeQuestionDataAccessMapper = codeQuestionDataAccessMapper;
    }

    @Override
    public CodeQuestion save(CodeQuestion codeQuestion) {
        return
        codeQuestionDataAccessMapper.codeQuestionEntityToCodeQuestion(
                codeQuestionJpaRepository
                        .save(codeQuestionDataAccessMapper.codeQuestionToCodeQuestionEntity(codeQuestion)));
    }

    @Override
    public Optional<CodeQuestion> findById(CodeQuestionId codeQuestionId) {
        return codeQuestionJpaRepository
                .findById(codeQuestionId.getValue())
                .map(codeQuestionDataAccessMapper::codeQuestionEntityToCodeQuestion);
    }
}
