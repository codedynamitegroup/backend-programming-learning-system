package com.backend.programming.learning.system.code.assessment.service.dataaccess.code_submission_test_case.adapter;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_submission_test_case.mapper.CodeSubmissionTestCaseDataAccessMapper;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_submission_test_case.repository.CodeSubmissionTestCaseJpaRepository;
import com.backend.programming.learning.system.code.assessment.service.config.CodeAssessmentServiceConfigData;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeSubmissionTestCase;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.CodeSubmissionTestCaseRepository;
import com.backend.programming.learning.system.domain.valueobject.CodeSubmissionId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@Slf4j
public class CodeSubmissionTestCaseRepositoryImpl implements CodeSubmissionTestCaseRepository {
    private final CodeSubmissionTestCaseDataAccessMapper dataAccessMapper;
    private final CodeSubmissionTestCaseJpaRepository jpaRepository;
    private final CodeAssessmentServiceConfigData codeAssessmentServiceConfigData;

    public CodeSubmissionTestCaseRepositoryImpl(CodeSubmissionTestCaseDataAccessMapper dataAccessMapper, CodeSubmissionTestCaseJpaRepository jpaRepository, CodeAssessmentServiceConfigData codeAssessmentServiceConfigData) {
        this.dataAccessMapper = dataAccessMapper;
        this.jpaRepository = jpaRepository;
        this.codeAssessmentServiceConfigData = codeAssessmentServiceConfigData;
    }

    @Override
    public List<CodeSubmissionTestCase> save(List<CodeSubmissionTestCase> cstcList) {
        return jpaRepository.saveAll(
                cstcList.stream()
                        .map(dataAccessMapper::codeSubmissionTestCaseToEntity)
                        .collect(Collectors.toList()))
                .stream()
                .map(dataAccessMapper::entityToCodeSubmissionTestCase)
                .collect(Collectors.toList());
    }

    @Override
    public CodeSubmissionTestCase save(CodeSubmissionTestCase codeSubmissionTestCase) {
        return dataAccessMapper
                .entityToCodeSubmissionTestCase(
                    jpaRepository
                        .save(dataAccessMapper
                                .codeSubmissionTestCaseToEntity(codeSubmissionTestCase)));
    }

    @Override
    public Optional<CodeSubmissionTestCase> findByToken(String token) {

        return jpaRepository
                .findFirstByJudgeToken(token)
                .map(dataAccessMapper::entityToCodeSubmissionTestCase);
    }

    @Override
    public List<CodeSubmissionTestCase> findByCodeSubmissionId(CodeSubmissionId id) {

        return jpaRepository.findByCodeSubmissionId(id.getValue()).stream().map(dataAccessMapper::entityToCodeSubmissionTestCase).collect(Collectors.toList());
    }

    @Override
    public Optional<CodeSubmissionTestCase> findFirstNotAcceptedByCodeSubmissionId(CodeSubmissionId id) {

        return jpaRepository
                .findFirstByCodeSubmissionIdAndStatusDescriptionNot
                        (id.getValue(),
                                codeAssessmentServiceConfigData
                                        .getAcceptedStatusDescription())
                .map(dataAccessMapper::entityToCodeSubmissionTestCase);
    }
}
