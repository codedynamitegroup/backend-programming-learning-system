package com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository;

import com.backend.programming.learning.system.code.assessment.service.domain.entity.TestCase;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.TestCaseId;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;

public interface TestCaseRepository {
    Page<TestCase>  getTestCaseByCodeQuestionId(CodeQuestionId id, Integer pageNo, Integer pageSize, Boolean fetchAll);
    List<TestCase> save(List<TestCase> listTestCase);
    TestCase save(TestCase testCase);
    Optional<TestCase> findById(TestCaseId id);
    void delete(TestCaseId id);

}
