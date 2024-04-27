package com.backend.programming.learning.system.code.assessment.service.domain.implement.service.testcase;

import com.backend.programming.learning.system.code.assessment.service.domain.CodeAssessmentDomainService;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.test_case.CreateTestCasesCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.test_case.CreateTestCasesResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeQuestion;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.TestCase;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.CodeAssessmentDomainException;
import com.backend.programming.learning.system.code.assessment.service.domain.mapper.test_case.TestCaseDataMapper;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.CodeQuestionRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.TestCaseRepository;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;
import lombok.extern.slf4j.Slf4j;
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

    public TestCaseHelper(CodeAssessmentDomainService codeAssessmentDomainService, TestCaseRepository testCaseRepository, TestCaseDataMapper testCaseDataMapper, CodeQuestionRepository codeQuestionRepository) {
        this.codeAssessmentDomainService = codeAssessmentDomainService;
        this.testCaseRepository = testCaseRepository;
        this.testCaseDataMapper = testCaseDataMapper;
        this.codeQuestionRepository = codeQuestionRepository;
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
}
