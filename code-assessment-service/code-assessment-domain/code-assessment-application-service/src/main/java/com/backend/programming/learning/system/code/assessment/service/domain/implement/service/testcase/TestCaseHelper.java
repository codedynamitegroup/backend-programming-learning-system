package com.backend.programming.learning.system.code.assessment.service.domain.implement.service.testcase;

import com.backend.programming.learning.system.code.assessment.service.domain.CodeAssessmentDomainService;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.test_case.CreateTestCasesCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.test_case.CreateTestCasesResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.test_case.PatchDeleteTestCasesCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.test_case.PatchDeleteTestCasesResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.testcase.GetTestCasesByQuestionIdCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.testcase.GetTestCasesByQuestionIdResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.update.testcase.UpdateTestCaseCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.update.testcase.UpdateTestCaseResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeQuestion;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.TestCase;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.CodeAssessmentDomainException;
import com.backend.programming.learning.system.code.assessment.service.domain.implement.service.GenericHelper;
import com.backend.programming.learning.system.code.assessment.service.domain.mapper.test_case.TestCaseDataMapper;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.CodeQuestionRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.TestCaseRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.TestCaseId;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class TestCaseHelper {
    private final CodeAssessmentDomainService codeAssessmentDomainService;
    private final TestCaseRepository testCaseRepository;
    private final TestCaseDataMapper testCaseDataMapper;
    private final CodeQuestionRepository codeQuestionRepository;
    private final GenericHelper genericHelper;

    public TestCaseHelper(CodeAssessmentDomainService codeAssessmentDomainService, TestCaseRepository testCaseRepository, TestCaseDataMapper testCaseDataMapper, CodeQuestionRepository codeQuestionRepository, GenericHelper genericHelper) {
        this.codeAssessmentDomainService = codeAssessmentDomainService;
        this.testCaseRepository = testCaseRepository;
        this.testCaseDataMapper = testCaseDataMapper;
        this.codeQuestionRepository = codeQuestionRepository;
        this.genericHelper = genericHelper;
    }

    @Transactional
    public CreateTestCasesResponse persistTestCases(CreateTestCasesCommand command){
        List<TestCase> tcList = testCaseDataMapper.createTestCasesCommandToTestCaseList(command);
        //validate code question id
        validateCodeQuestion(command.getCodeQuestionId());
        tcList = codeAssessmentDomainService.initiateTestCases(tcList);
        saveTestCases(tcList);
        return CreateTestCasesResponse.builder().message("Create successfully").build();
    }

    private void saveTestCases(List<TestCase> tcList) {
        testCaseRepository.save(tcList);
    }

    private void validateCodeQuestion(UUID codeQuestionId) {
        Optional<CodeQuestion> codeQuestion = codeQuestionRepository.findById(new CodeQuestionId(codeQuestionId));

        if (codeQuestion.isEmpty()) {
            log.warn("Could not find code question with id: {}", codeQuestionId);
            throw new CodeAssessmentDomainException("Could not find code question with id: " + codeQuestionId);
        }
    }

    //no transactional annotation needed
    public PatchDeleteTestCasesResponse patchDeleteTestCases(PatchDeleteTestCasesCommand command) {
        for (UUID id: command.getTestCaseIds())
            try {
                testCaseRepository.delete(new TestCaseId(id));
            } catch (Exception e) {
//                throw new RuntimeException(e);
                log.error("Can not delete testcase with id {}, message {}", id, e.getMessage());
            }
        return PatchDeleteTestCasesResponse.builder().message("Delete successfully").build();

    }

    @Transactional
    public UpdateTestCaseResponse updateTestCase(UpdateTestCaseCommand command) {
        TestCase testCase = testCaseDataMapper.updateTestCaseCommandToTestCase(command);
        TestCase testCaseExist = checkIfTestCaseExist(command.getId());

        genericHelper.mapNullAttributeToRepositoryAttribute(testCase, testCaseExist, TestCase.class);

        testCaseRepository.save(testCase);
        return UpdateTestCaseResponse.builder().message("update successfully").build();
    }

    private TestCase checkIfTestCaseExist(UUID id) {
        Optional<TestCase> testCase = testCaseRepository.findById(new TestCaseId(id));

        if (testCase.isEmpty()) {
            log.warn("Could not find test case with id: {}", id);
            throw new CodeAssessmentDomainException("Could not find test case with id: " + id);
        }
        return testCase.get();
    }

    public Page<TestCase> getTestCasesByCodeQuestionId(GetTestCasesByQuestionIdCommand command) {
        return testCaseRepository.getTestCaseByCodeQuestionId(
                new CodeQuestionId(command.getCodeQuestionId()),
                command.getPageNum(),
                command.getPageSize(),
                command.getFetchAll()
        );

    }
}
