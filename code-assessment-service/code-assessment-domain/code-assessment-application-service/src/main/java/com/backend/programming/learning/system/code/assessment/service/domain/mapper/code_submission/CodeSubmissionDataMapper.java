package com.backend.programming.learning.system.code.assessment.service.domain.mapper.code_submission;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.entity.DtoMapper;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_submission.CreateCodeSubmissionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_submission.CreateCodeSubmissionResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_submission.GetCodeSubmissionReponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_submission.GetCodeSubmissionResponseItem;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.update.code_submission.UpdateCodeSubmissionTestCaseCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeQuestion;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeSubmission;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeSubmissionTestCase;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.User;
import com.backend.programming.learning.system.code.assessment.service.domain.event.code_submission.CodeSubmissionUpdatedEvent;
import com.backend.programming.learning.system.code.assessment.service.domain.outbox.model.code_submission_update_outbox.CodeSubmissionUpdatePayload;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.domain.valueobject.ProgrammingLanguageId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.UUID;

@Component
@Slf4j
public class CodeSubmissionDataMapper {
    final DtoMapper dtoMapper;

    public CodeSubmissionDataMapper(DtoMapper dtoMapper) {
        this.dtoMapper = dtoMapper;
    }

    public CreateCodeSubmissionResponse codeSubmissionToCreateCodeSubmissionResponse(CodeSubmission codeSubmission) {
        return CreateCodeSubmissionResponse.builder()
                .message("Submit successfully")
                .status(codeSubmission.getGradingStatus().name())
                .codeSubmissionId(codeSubmission.getId().getValue())
                .build();
    }

    public CodeSubmission createCodeSubmissionCommandToCodeSubmission(CreateCodeSubmissionCommand createCodeSubmissionCommand, CodeQuestion codeQuestion, User user) {
        return CodeSubmission.builder()
                .languageId(new ProgrammingLanguageId(createCodeSubmissionCommand.getLanguageId()))
                .user(user)
                .codeQuestion(codeQuestion)
                .sourceCode(createCodeSubmissionCommand.getSourceCode())
//                .headCode(createCodeSubmissionCommand.getHeadCode())
//                .bodyCode(createCodeSubmissionCommand.getBodyCode())
//                .tailCode(createCodeSubmissionCommand.getTailCode())
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
                .programmingLanguageName(codeSubmission.getProgrammingLanguageName())
                .id(codeSubmission.getId().getValue())
                .user(dtoMapper.userToUserDto(codeSubmission.getUser()))
                .avgRuntime(codeSubmission.getRunTime())
                .avgMemory(codeSubmission.getMemory())
                .gradingStatus(codeSubmission.getGradingStatus())
                .maxGrade(codeSubmission.getCodeQuestion().getMaxGrade())
                .achievedGrade(codeSubmission.getGrade())
                .description(codeSubmission.getStatusDescription())
                .sourceCode(decodeBase64ToString(codeSubmission.getSourceCode()))
                .codeQuestion(GetCodeSubmissionResponseItem.CodeQuestion.builder()
                        .id(codeSubmission.getCodeQuestion().getId().getValue())
                        .name(codeSubmission.getCodeQuestion().getName())
                        .build())
//                .headCode(decodeBase64ToString(codeSubmission.getHeadCode()))
//                .bodyCode(decodeBase64ToString(codeSubmission.getBodyCode()))
//                .tailCode(decodeBase64ToString(codeSubmission.getTailCode()))
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

    public CodeSubmissionUpdatePayload codeSubmissionUpdatedEventToCodeSubmissionUpdatePayload(CodeSubmissionUpdatedEvent event, UUID certificateCourseId, UUID contestId, CopyState copyState) {
        CodeSubmission codeSubmission = event.getCodeSubmission();
        return CodeSubmissionUpdatePayload.builder()
                .id(codeSubmission.getId().getValue().toString())
                .codeQuestionId(codeSubmission.getCodeQuestion().getId().getValue().toString())
                .userId(codeSubmission.getUser().getId().getValue().toString())
                .programmingLanguageId(codeSubmission.getLanguageId().getValue().toString())
//                .bodyCode(codeSubmission.getBodyCode())
                .bodyCode(codeSubmission.getSourceCode())
                .grade(codeSubmission.getGrade() == null? null: codeSubmission.getGrade().floatValue())
                .pass(codeSubmission.getGrade() == null? null: codeSubmission.getGrade().floatValue() == codeSubmission.getCodeQuestion().getMaxGrade())
                .createdAt(codeSubmission.getCreatedAt())
                .copyState(codeSubmission.getCopyState().name())
                .cerCourseId(certificateCourseId)
                .contestId(contestId)
                .build();
    }

    public GetCodeSubmissionReponse pagableToGetCodeSubmissionReponse(Page<GetCodeSubmissionResponseItem> list) {
        return GetCodeSubmissionReponse.builder()
                .codeSubmissions(list.toList())
                .currentPage(list.getNumber())
                .totalItems(list.getTotalElements())
                .totalPages(list.getTotalPages())
                .build();
    }
}
