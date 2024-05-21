package com.backend.programming.learning.system.code.assessment.service.domain.dto.entity;

import com.backend.programming.learning.system.code.assessment.service.domain.entity.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Component
@Slf4j
public class DtoMapper {
    public CommentDto commentToCommentDto(Comment comment) {
        return CommentDto.builder()
                .id(comment.getId().getValue())
                .content(comment.getContent())
                .numOfReply(comment.getNumOfReply())
                .totalVote(comment.getTotalVote())
                .replyId(comment.getReplyId() != null? comment.getReplyId().getValue(): null)
                .createdAt(comment.getCreatedAt())
                .user(this.userToUserDto(comment.getUser()))
                .youVote(comment.getYouVote())
                .build();
    }

    public UserDto userToUserDto(User user) {
        return UserDto.builder()
                .lastName(user.getLastName())
                .firstName(user.getFirstName())
                .avatarUrl(user.getAvatarUrl())
                .id(user.getId().getValue())
                .build();
    }

    public CodeQuestionDto codeQuestionToDto(CodeQuestion codeQuestion) {
        return CodeQuestionDto.builder()
                .name(codeQuestion.getName())
                .done(codeQuestion.getSolved())
                .id(codeQuestion.getId().getValue())
                .difficulty(codeQuestion.getDifficulty())
                .problemStatement(codeQuestion.getProblemStatement())
                .inputFormat(codeQuestion.getInputFormat())
                .outputFormat(codeQuestion.getOutputFormat())
                .constraints(codeQuestion.getConstraints())
                .codeSubmissions(codeQuestion.getCodeSubmissions() != null? codeQuestion.getCodeSubmissions().stream().map(this::codeSubmissionToDto).toList(): null)
                .languages(codeQuestion.getProgrammingLanguages() != null? codeQuestion.getProgrammingLanguages().stream().map(this::programmingLanguageCodeQuestionToDto).toList(): null)
                .sampleTestCases(codeQuestion.getTcs() != null? codeQuestion.getTcs().stream().map(this::testCaseToDto).toList(): null)
                .build();
    }

    private ProgrammingLanguageDto programmingLanguageCodeQuestionToDto(ProgrammingLanguageCodeQuestion programmingLanguageCodeQuestion) {
        return ProgrammingLanguageDto.builder()
                .id(programmingLanguageCodeQuestion.getLanguage().getId().getValue())
                .name(programmingLanguageCodeQuestion.getLanguage().getName())
                .judge0Id(programmingLanguageCodeQuestion.getLanguage().getJudge0_compilerApiId())
                .isActived(programmingLanguageCodeQuestion.getActive())
                .timeLimit(programmingLanguageCodeQuestion.getTimeLimit())
                .memoryLimit(programmingLanguageCodeQuestion.getMemoryLimit())
                .tailCode(programmingLanguageCodeQuestion.getTailCode())
                .headCode(programmingLanguageCodeQuestion.getHeadCode())
                .bodyCode(programmingLanguageCodeQuestion.getBodyCode())
                .build();
    }

    private CodeSubmissionDto codeSubmissionToDto(CodeSubmission codeSubmission) {
        return CodeSubmissionDto.builder()
                .id(codeSubmission.getId().getValue())
                .languageId(codeSubmission.getLanguageId().getValue())
                .bodyCode(decodeBase64ToString(codeSubmission.getBodyCode()))
                .headCode(decodeBase64ToString(codeSubmission.getHeadCode()))
                .tailCode(decodeBase64ToString(codeSubmission.getTailCode()))
                .build();
    }

    private TestCaseDto testCaseToDto(TestCase testCase) {
        return TestCaseDto.builder()
                .id(testCase.getId().getValue())
                .inputData(testCase.getInputData())
                .outputData(testCase.getOutputData())
                .score(testCase.getScore())
                .isSample(testCase.getIsSample())
                .build();
    }

    public CodeQuestionDto codeQuestionToDtoIgnoreProblemStatement(CodeQuestion codeQuestion) {
        return CodeQuestionDto.builder()
                .name(codeQuestion.getName())
                .done(codeQuestion.getSolved())
                .id(codeQuestion.getId().getValue())
                .difficulty(codeQuestion.getDifficulty())
                .build();
    }

    public ProgrammingLanguageDto programmingLanguageToDto(ProgrammingLanguage programmingLanguage) {
        return ProgrammingLanguageDto.builder()
                .isActived(programmingLanguage.getIsActive())
                .memoryLimit(programmingLanguage.getMemoryLimit())
                .judge0Id(programmingLanguage.getJudge0_compilerApiId())
                .timeLimit(programmingLanguage.getTimeLimit())
                .id(programmingLanguage.getId().getValue())
                .name(programmingLanguage.getName())
                .bodyCode(programmingLanguage.getBodyCode() != null? decodeBase64ToString(programmingLanguage.getBodyCode()): "")
                .headCode(programmingLanguage.getHeadCode() != null? decodeBase64ToString(programmingLanguage.getHeadCode()): "")
                .tailCode(programmingLanguage.getTailCode() != null? decodeBase64ToString(programmingLanguage.getTailCode()): "")
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
