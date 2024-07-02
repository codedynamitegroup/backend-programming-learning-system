package com.backend.programming.learning.system.code.assessment.service.dataaccess.code_submission.mapper;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.entity.CodeQuestionEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.mapper.CodeQuestionDataAccessMapper;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_submission.entity.CodeSubmissionEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.programming_language.entity.ProgrammingLanguageEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeSubmission;
import com.backend.programming.learning.system.domain.valueobject.CodeSubmissionId;
import com.backend.programming.learning.system.domain.valueobject.ProgrammingLanguageId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class CodeSubmissionDataAccessMapper {
    private final CodeQuestionDataAccessMapper codeQuestionDataAccessMapper;
    private final UserDataAccessMapper userDataAccessMapper;

    public CodeSubmissionDataAccessMapper(CodeQuestionDataAccessMapper codeQuestionDataAccessMapper, UserDataAccessMapper userDataAccessMapper) {
        this.codeQuestionDataAccessMapper = codeQuestionDataAccessMapper;
        this.userDataAccessMapper = userDataAccessMapper;
    }

    public CodeSubmissionEntity codeSubmissionToEntity(CodeSubmission codeSubmission) {
        return CodeSubmissionEntity.builder()
                .id(codeSubmission.getId().getValue())
                .codeQuestion(CodeQuestionEntity.builder()
                        .id(codeSubmission.getCodeQuestion().getId().getValue())
                        .build())
                .user(UserEntity.builder()
                        .id(codeSubmission.getUser().getId().getValue())
                        .build())
                .programmingLanguage(ProgrammingLanguageEntity.builder()
                        .id(codeSubmission.getLanguageId().getValue())
                        .build())
                .grade(codeSubmission.getGrade())
                .avgRuntime(codeSubmission.getRunTime())
                .avgMemory(codeSubmission.getMemory())
                .aiAssessment(codeSubmission.getAiAssessment())
                .sonaqueAssessment(codeSubmission.getSonaqueAssessment())
//                .headCode(codeSubmission.getHeadCode())
//                .bodyCode(codeSubmission.getBodyCode())
//                .tailCode(codeSubmission.getTailCode())
                .bodyCode(codeSubmission.getSourceCode())
                .numOfTestCaseSent(codeSubmission.getNumOfTestCase())
                .numOfTestCaseGraded(codeSubmission.getNumOfTestCaseGraded())
                .gradingStatus(codeSubmission.getGradingStatus())
                .copyState(codeSubmission.getCopyState())
                .createdAt(codeSubmission.getCreatedAt())
//                .version(codeSubmission.getVersion())
                .build();
    }

    public CodeSubmission entityToCodeSubmission(CodeSubmissionEntity entity) {
        return CodeSubmission.builder()
                .id(new CodeSubmissionId(entity.getId()))
                .codeQuestion(codeQuestionDataAccessMapper.codeQuestionEntityToCodeQuestion(entity.getCodeQuestion()))
                .user(userDataAccessMapper.userEntityToUser(entity.getUser()))
                .languageId(new ProgrammingLanguageId(entity.getProgrammingLanguage().getId()))
                .programmingLanguageName(entity.getProgrammingLanguage().getName())
                .grade(entity.getGrade())
                .runTime(entity.getAvgRuntime())
                .memory(entity.getAvgMemory())
                .aiAssessment(entity.getAiAssessment())
                .sonaqueAssessment(entity.getSonaqueAssessment())
//                .headCode(entity.getHeadCode())
//                .bodyCode(entity.getBodyCode())
//                .tailCode(entity.getTailCode())
                .sourceCode(entity.getBodyCode())
                .numOfTestCase(entity.getNumOfTestCaseSent())
                .numOfTestCaseGraded(entity.getNumOfTestCaseGraded())
                .gradingStatus(entity.getGradingStatus())
                .copyState(entity.getCopyState())
                .createdAt(entity.getCreatedAt())
//                .version(entity.getVersion())
                .build();
    }
}
