package com.backend.programming.learning.system.code.assessment.service.domain.ports.output.assessment;

import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeSubmission;

public interface AssessmentSourceCodeByTestCases {
    void judge(CodeSubmission codeSubmission, String callbackUrl);
}
