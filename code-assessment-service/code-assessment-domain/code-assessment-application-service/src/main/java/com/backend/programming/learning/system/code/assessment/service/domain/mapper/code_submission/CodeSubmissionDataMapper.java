package com.backend.programming.learning.system.code.assessment.service.domain.mapper.code_submission;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_submission.CreateCodeSubmissionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_submission.CreateCodeSubmissionResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_submission.GetCodeSubmissionResponseItem;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.update.code_submission.UpdateCodeSubmissionTestCaseCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeQuestion;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeSubmission;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeSubmissionTestCase;
import com.backend.programming.learning.system.domain.valueobject.ProgrammingLanguageId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Component
@Slf4j
public class CodeSubmissionDataMapper {
    public CreateCodeSubmissionResponse codeSubmissionToCreateCodeSubmissionResponse(CodeSubmission codeSubmission) {
        return CreateCodeSubmissionResponse.builder()
                .message("Submit successfully")
                .status(codeSubmission.getGradingStatus().name())
                .codeSubmissionId(codeSubmission.getId().getValue())
                .build();
    }

    public CodeSubmission createCodeSubmissionCommandToCodeSubmission(CreateCodeSubmissionCommand createCodeSubmissionCommand, CodeQuestion codeQuestion) {
        return CodeSubmission.builder()
                .languageId(new ProgrammingLanguageId(createCodeSubmissionCommand.getLanguageId()))
                .userId(new UserId(createCodeSubmissionCommand.getUserId()))
                .codeQuestion(codeQuestion)
                .headCode(createCodeSubmissionCommand.getHeadCode())
                .bodyCode(createCodeSubmissionCommand.getBodyCode())
                .tailCode(createCodeSubmissionCommand.getTailCode())
                .build();
    }

    public CodeSubmissionTestCase updateCodeSubmissionTestCaseCommandToCodeSubmissionTestCase(UpdateCodeSubmissionTestCaseCommand command) {
        return CodeSubmissionTestCase.builder()
                .judgeToken(command.getToken())
                .stderr(command.getStderr())
                .actualOutput(command.getStdout())
                .runTime(command.getTime())
                .memory(command.getMemory())
                .compileOutput(command.getCompile_output())
                .message(command.getMessage())
                .statusDescription(command.getStatus().getDescription())
                .build();
    }

    public GetCodeSubmissionResponseItem codeSubmissionToGetCodeSubmissionResponseItem(CodeSubmission codeSubmission) {
        return GetCodeSubmissionResponseItem.builder()
                .programmingLanguageId(codeSubmission.getLanguageId().getValue())
                .id(codeSubmission.getId().getValue())
                .avgRuntime(codeSubmission.getRunTime())
                .avgMemory(codeSubmission.getMemory())
                .gradingStatus(codeSubmission.getGradingStatus())
                .maxGrade(codeSubmission.getCodeQuestion().getMaxGrade())
                .achievedGrade(codeSubmission.getGrade())
                .description(codeSubmission.getStatusDescription())
                .headCode(decodeBase64ToString(codeSubmission.getHeadCode()))
                .bodyCode(decodeBase64ToString(codeSubmission.getBodyCode()))
                .tailCode(decodeBase64ToString(codeSubmission.getTailCode()))
                .createdAt(codeSubmission.getCreatedAt())
                .build();
    }

    public GetCodeSubmissionResponseItem.FirstFailTestCase codeSubmissionTestCaseToFirstFailTestCase(CodeSubmissionTestCase cstc) {
        if(cstc == null) return null;
        return GetCodeSubmissionResponseItem.FirstFailTestCase.builder()
                .compileOutput(decodeBase64ToString(cstc.getCompileOutput()))
                .actualOutput(decodeBase64ToString(cstc.getActualOutput()))
                .input(cstc.getTestCase().getInputData())
                .output(cstc.getTestCase().getOutputData())
                .stderr(decodeBase64ToString(cstc.getStderr()))
                .runtime(cstc.getRunTime())
                .memory(cstc.getMemory())
                .message(decodeBase64ToString(cstc.getMessage()))
                .description(cstc.getStatusDescription())
                .build();
    }
    private String decodeBase64ToString(String str){
        if(str == null) return null;
        String nonEnterstr = str.replace("\n","");
        try {
            return new String(Base64.getDecoder().decode(nonEnterstr.getBytes()), StandardCharsets.UTF_8);
        } catch (Exception e) {
            log.error("not base64 {}", str);
            return str;
        }

    }
}
