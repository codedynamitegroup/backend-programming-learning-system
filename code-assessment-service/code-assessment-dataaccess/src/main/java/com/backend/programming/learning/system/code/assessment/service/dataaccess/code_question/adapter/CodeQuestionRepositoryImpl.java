package com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.adapter;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.entity.CodeQuestionEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.mapper.CodeQuestionDataAccessMapper;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.repository.CodeQuestionJpaRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeQuestion;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.CodeQuestionRepository;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@Slf4j
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
        CodeQuestionEntity codeQuestionEntity = codeQuestionDataAccessMapper.codeQuestionToCodeQuestionEntity(codeQuestion);
        CodeQuestionEntity codeQuestionEntityRes = codeQuestionJpaRepository
                .save(codeQuestionEntity);
        return
        codeQuestionDataAccessMapper.codeQuestionEntityToCodeQuestion(codeQuestionEntityRes);
    }

    @Override
    public Optional<CodeQuestion> findById(CodeQuestionId codeQuestionId) {
        return codeQuestionJpaRepository
                .findById(codeQuestionId.getValue())
                .map(codeQuestionDataAccessMapper::codeQuestionEntityToCodeQuestion);
    }

    @Override
    public void deleteCodeQuestionById(UUID id){
        codeQuestionJpaRepository.deleteById(id);
    }
}
