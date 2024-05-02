package com.backend.programming.learning.system.code.assessment.service.dataaccess.code_submission.mapper;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.entity.CodeQuestionEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_submission.entity.CodeSubmissionEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.language.entity.ProgrammingLanguageEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeSubmission;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.ProgrammingLanguageId;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;
import com.backend.programming.learning.system.domain.valueobject.CodeSubmissionId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

@Component
public class CodeSubmissionDataAccessMapper {
    public CodeSubmissionEntity codeSubmissionToEntity(CodeSubmission codeSubmission) {
        return CodeSubmissionEntity.builder()
                .id(codeSubmission.getId().getValue())
                .codeQuestion(CodeQuestionEntity.builder()
                        .id(codeSubmission.getCodeQuestionId().getValue())
                        .build())
                .user(UserEntity.builder()
                        .id(codeSubmission.getUserId().getValue())
                        .build())
                .programmingLanguage(ProgrammingLanguageEntity.builder()
                        .id(codeSubmission.getLanguageId().getValue())
                        .build())
                .grade(codeSubmission.getGrade())
                .avgRuntime(codeSubmission.getRunTime())
                .avgMemory(codeSubmission.getMemory())
                .aiAssessment(codeSubmission.getAiAssessment())
                .sonaqueAssessment(codeSubmission.getSonaqueAssessment())
                .sourceCode(codeSubmission.getSourceCode())
                .numOfTestCaseSent(codeSubmission.getNumOfTestCase())
                .numOfTestCaseGraded(codeSubmission.getNumOfTestCaseGraded())
                .gradingStatus(codeSubmission.getGradingStatus())
                .copyState(codeSubmission.getCopyState())
//                .version(codeSubmission.getVersion())
                .build();
    }

    public CodeSubmission entityToCodeSubmission(CodeSubmissionEntity entity) {
        return CodeSubmission.builder()
                .id(new CodeSubmissionId(entity.getId()))
                .codeQuestionId(new CodeQuestionId(entity.getCodeQuestion().getId()))
                .userId(new UserId(entity.getUser().getId()))
                .languageId(new ProgrammingLanguageId(entity.getProgrammingLanguage().getId()))
                .grade(entity.getGrade())
                .runTime(entity.getAvgRuntime())
                .memory(entity.getAvgMemory())
                .aiAssessment(entity.getAiAssessment())
                .sonaqueAssessment(entity.getSonaqueAssessment())
                .sourceCode(entity.getSourceCode())
                .numOfTestCase(entity.getNumOfTestCaseSent())
                .numOfTestCaseGraded(entity.getNumOfTestCaseGraded())
                .gradingStatus(entity.getGradingStatus())
                .copyState(entity.getCopyState())
//                .version(entity.getVersion())
                .build();
    }
}
