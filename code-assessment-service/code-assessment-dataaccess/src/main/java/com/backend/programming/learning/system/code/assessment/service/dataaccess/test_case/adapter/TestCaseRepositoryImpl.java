package com.backend.programming.learning.system.code.assessment.service.dataaccess.test_case.adapter;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.test_case.entity.TestCaseEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.test_case.mapper.TestCaseDataAccessMapper;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.test_case.repository.TestCaseJpaRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.TestCase;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.TestCaseRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.TestCaseId;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@Slf4j
public class TestCaseRepositoryImpl  implements TestCaseRepository {

    private final TestCaseJpaRepository jpaRepository;
    private final TestCaseDataAccessMapper dataAccessMapper;

    public TestCaseRepositoryImpl(TestCaseJpaRepository jpaRepository, TestCaseDataAccessMapper dataAccessMapper) {
        this.jpaRepository = jpaRepository;
        this.dataAccessMapper = dataAccessMapper;
    }

    @Override
    public Page<TestCase> getTestCaseByCodeQuestionId(CodeQuestionId id, Integer pageNo, Integer pageSize, Boolean fetchAll) {
        Pageable pageable = fetchAll ? Pageable.unpaged() : PageRequest.of(pageNo, pageSize);

        Page<TestCaseEntity> listTcResponse = jpaRepository.findByCodeQuestionId(id.getValue(), pageable);

        return listTcResponse.map(dataAccessMapper::testCaseEntityToTestCase);
    }

    @Override
    public List<TestCase> getTestCaseByCodeQuestionId(CodeQuestionId id) {
        List<TestCaseEntity> listTcResponse = jpaRepository.findByCodeQuestionId(id.getValue());

        return listTcResponse.stream().map(dataAccessMapper::testCaseEntityToTestCase).collect(Collectors.toList());
    }

    @Override
    public List<TestCase> save(List<TestCase> listTestCase) {
        List<TestCaseEntity> entities = dataAccessMapper.testCaseListToTestCaseEntityList(listTestCase);
        List<TestCaseEntity> entitiesRes = jpaRepository.saveAll(entities);
        return dataAccessMapper.testCaseEntityListToTestCaseList(entitiesRes);
    }

    @Override
    public TestCase save(TestCase testCase) {
        TestCaseEntity entity = dataAccessMapper.testCaseToTestCaseEntity(testCase);
        TestCaseEntity entityRes = jpaRepository.save(entity);
        return dataAccessMapper.testCaseEntityToTestCase(entityRes);
    }

    @Override
    public Optional<TestCase> findById(TestCaseId id) {
        return jpaRepository.findById(id.getValue()).map(dataAccessMapper::testCaseEntityToTestCase)
;
    }

    @Override
    public void delete(TestCaseId id) {
        jpaRepository.deleteById(id.getValue());
    }
}
