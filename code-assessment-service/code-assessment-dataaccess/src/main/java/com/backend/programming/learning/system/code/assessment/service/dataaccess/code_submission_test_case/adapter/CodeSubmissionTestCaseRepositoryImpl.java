package com.backend.programming.learning.system.code.assessment.service.dataaccess.code_submission_test_case.adapter;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_submission_test_case.mapper.CodeSubmissionTestCaseDataAccessMapper;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_submission_test_case.repository.CodeSubmissionTestCaseJpaRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeSubmissionTestCase;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.CodeSubmissionTestCaseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class CodeSubmissionTestCaseRepositoryImpl implements CodeSubmissionTestCaseRepository {
    private final CodeSubmissionTestCaseDataAccessMapper dataAccessMapper;
    private final CodeSubmissionTestCaseJpaRepository jpaRepository;

    public CodeSubmissionTestCaseRepositoryImpl(CodeSubmissionTestCaseDataAccessMapper dataAccessMapper, CodeSubmissionTestCaseJpaRepository jpaRepository) {
        this.dataAccessMapper = dataAccessMapper;
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<CodeSubmissionTestCase> save(List<CodeSubmissionTestCase> cstcList) {
        return jpaRepository.saveAll(
                cstcList.stream()
                        .map(dataAccessMapper::codeSubmissionTestCaseToEntity)
                        .collect(Collectors.toList()))
                .stream()
                .map(dataAccessMapper::entityToCodeSubmission)
                .collect(Collectors.toList());
    }
}
