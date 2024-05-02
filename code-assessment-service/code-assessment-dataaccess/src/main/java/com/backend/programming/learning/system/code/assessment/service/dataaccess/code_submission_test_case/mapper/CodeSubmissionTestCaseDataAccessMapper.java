package com.backend.programming.learning.system.code.assessment.service.dataaccess.code_submission_test_case.mapper;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_submission.entity.CodeSubmissionEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_submission.mapper.CodeSubmissionDataAccessMapper;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_submission_test_case.entity.CodeSubmissionTestCaseEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.test_case.entity.TestCaseEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.test_case.mapper.TestCaseDataAccessMapper;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeSubmissionTestCase;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.CodeSubmissionTestCaseId;
import org.springframework.stereotype.Component;

@Component
public class CodeSubmissionTestCaseDataAccessMapper {
    private final CodeSubmissionDataAccessMapper codeSubmissionDataAccessMapper;
    private final TestCaseDataAccessMapper testCaseDataAccessMapper;

    public CodeSubmissionTestCaseDataAccessMapper(CodeSubmissionDataAccessMapper codeSubmissionDataAccessMapper, TestCaseDataAccessMapper testCaseDataAccessMapper) {
        this.codeSubmissionDataAccessMapper = codeSubmissionDataAccessMapper;
        this.testCaseDataAccessMapper = testCaseDataAccessMapper;
    }

    public CodeSubmissionTestCaseEntity codeSubmissionTestCaseToEntity(CodeSubmissionTestCase cstc) {
        return CodeSubmissionTestCaseEntity.builder()
                .id(cstc.getId().getValue())
                .testCase(TestCaseEntity.builder().id(cstc.getTestCase().getId().getValue()).build())
                .codeSubmission(CodeSubmissionEntity.builder().id(cstc.getCodeSubmission().getId().getValue()).build())
                .actualOutput(cstc.getActualOutput())
                .compileOutput(cstc.getCompileOutput())
                .runtime(cstc.getRunTime())
                .memory(cstc.getMemory())
                .passed(cstc.getPassed())
                .message(cstc.getMessage())
                .stderr(cstc.getStderr())
                .statusDescription(cstc.getStatusDescription())
                .judgeToken(cstc.getJudgeToken())
                .build();
    }

    public CodeSubmissionTestCase entityToCodeSubmission(CodeSubmissionTestCaseEntity entity) {
        return CodeSubmissionTestCase.builder()
                .id(new CodeSubmissionTestCaseId(entity.getId()))
                .testCase(testCaseDataAccessMapper.testCaseEntityToTestCase(entity.getTestCase()))
                .codeSubmission(codeSubmissionDataAccessMapper.entityToCodeSubmission(entity.getCodeSubmission()))
                .actualOutput(entity.getActualOutput())
                .compileOutput(entity.getCompileOutput())
                .runTime(entity.getRuntime())
                .memory(entity.getMemory())
                .passed(entity.getPassed())
                .message(entity.getMessage())
                .statusDescription(entity.getStatusDescription())
                .stderr(entity.getStderr())
                .judgeToken(entity.getJudgeToken())
                .build();
    }
}
