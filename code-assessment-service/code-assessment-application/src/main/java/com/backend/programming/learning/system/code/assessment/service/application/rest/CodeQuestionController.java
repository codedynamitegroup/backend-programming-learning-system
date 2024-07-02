package com.backend.programming.learning.system.code.assessment.service.application.rest;

import com.backend.programming.learning.system.application.handler.utils.JwtUtils;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.entity.CodeQuestionAdminDto;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.entity.CodeQuestionDto;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.entity.ProgrammingLanguageDto;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_question.CreateCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_question.CreateCodeQuestionResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_question.langauge.AddLanguageToCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_question.tag.AddTagToCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.code_question.language.DeleteLanguageToCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.code_question.tag.DeleteCodeQuestionTagCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_question.AdminDetailCodeQuestionQuery;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_question.GetCodeQuestionsQuery;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_question.GetCodeQuestionsResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_question.GetDetailCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.update.code_question.UpdateCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeQuestion;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.input.service.CodeQuestionApplicationService;
import com.backend.programming.learning.system.domain.valueobject.QueryOrderBy;
import com.backend.programming.learning.system.domain.valueobject.QuestionDifficulty;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/code-assessment/code-question",
        produces = "application/vnd.api.v1+json")
@Slf4j
@Validated
public class CodeQuestionController {
    private final CodeQuestionApplicationService codeQuestionApplicationService;

    public CodeQuestionController(CodeQuestionApplicationService codeQuestionApplicationService) {
        this.codeQuestionApplicationService = codeQuestionApplicationService;
    }

    //add language to the body
    //fix outbox
    @PostMapping
    @Operation(summary = "Create code question.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Accepted.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = CreateCodeQuestionResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<CreateCodeQuestionResponse> createCodeQuestion
            (@RequestBody CreateCodeQuestionCommand createCodeQuestionCommand){
        log.info("Create code question for question id {}", createCodeQuestionCommand.getQuestionId());

        if(createCodeQuestionCommand.getIsPublic() == null)
            createCodeQuestionCommand.setIsPublic(true);
        if(createCodeQuestionCommand.getAllowImport() == null)
            createCodeQuestionCommand.setAllowImport(false);

        CreateCodeQuestionResponse createCodeQuestionResponse =
            codeQuestionApplicationService.createCodeQuestion(createCodeQuestionCommand);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(createCodeQuestionResponse);
    }

    @GetMapping
    public ResponseEntity<GetCodeQuestionsResponse> getPublicCodeQuestion(
            @RequestParam Integer pageNo,
            @RequestParam Integer pageSize,
            @RequestParam(required = false) List<UUID> tagIds,
            @RequestParam(defaultValue = "ASC") QueryOrderBy orderBy,
            @RequestParam(required = false) String search,
            @RequestParam(required = false) QuestionDifficulty difficulty,
            @RequestParam(required = false) Boolean solved,
            @RequestHeader(value = "Access-Token", required = false) String accessToken){
//        log.info("getPublicCodeQuestion");
//        tagIds.forEach(i-> log.info("{}",i));
        String email = JwtUtils.getEmailFromJwtStringWithoutCheckExp(accessToken);
        CodeQuestion.Fields sortBy = CodeQuestion.Fields.createdAt;
        GetCodeQuestionsQuery query = GetCodeQuestionsQuery.builder()
                .orderBy(orderBy)
                .sortBy(sortBy)
                .pageNum(pageNo)
                .pageSize(pageSize)
                .tagIds(tagIds)
                .email(email)
                .search(search)
                .difficulty(difficulty)
                .solved(solved)
                .build();
        GetCodeQuestionsResponse response = codeQuestionApplicationService.getPublicCodeQuestions(query);
        return ResponseEntity.ok(response);
    }

    //get detail public code question, khong phan biet public private
    @GetMapping("/detail")
    public ResponseEntity<List<CodeQuestionDto>> getDetailCodeQuestion(
            @RequestParam(value = "codeQuestionIds") List<UUID> codeQuestionIds,
            @RequestHeader(value = "Access-Token", required = false) String accessToken){
        String email = accessToken != null? JwtUtils.getEmailFromJwtStringWithoutCheckExp(accessToken): null;

        GetDetailCodeQuestionCommand command =  GetDetailCodeQuestionCommand.builder()
                .codeQuestionIds(codeQuestionIds)
                .email(email)
                .build();
        List<CodeQuestionDto> codeQuestionDtos = codeQuestionApplicationService.getDetailCodeQuestion(command);
        return ResponseEntity.ok(codeQuestionDtos);
    }
    @GetMapping("/admin-detail/{code-question-id}")
    public ResponseEntity<CodeQuestionAdminDto> getAdminDetailCodeQuestion(
            @PathVariable(value = "code-question-id") UUID codeQuestionId,
            @RequestHeader(value = "Access-Token", required = false) String accessToken){
        String email = accessToken != null? JwtUtils.getEmailFromJwtStringWithoutCheckExp(accessToken): null;

        AdminDetailCodeQuestionQuery query =  AdminDetailCodeQuestionQuery.builder()
                .codeQuestionId(codeQuestionId)
                .email(email)
                .build();
        CodeQuestionAdminDto result = codeQuestionApplicationService.getAdminDetailCodeQuestion(query);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/admin-code-question")
    public ResponseEntity<GetCodeQuestionsResponse> getAdminCodeQuestion(
            @RequestParam Integer pageNo,
            @RequestParam Integer pageSize,
            @RequestParam(required = false) List<UUID> tagIds,
//            @RequestParam(defaultValue = "ASC") QueryOrderBy orderBy,
            @RequestParam(required = false) String search,
            @RequestParam(required = false) QuestionDifficulty difficulty,
            @RequestParam(required = false) Boolean isPublic,
            @RequestHeader(value = "Access-Token") String accessToken){
//        log.info("getPublicCodeQuestion");
//        tagIds.forEach(i-> log.info("{}",i));
        String email = JwtUtils.getEmailFromJwtStringWithoutCheckExp(accessToken);
        CodeQuestion.Fields sortBy = CodeQuestion.Fields.createdAt;
        GetCodeQuestionsQuery query = GetCodeQuestionsQuery.builder()
                .orderBy(QueryOrderBy.ASC)
                .sortBy(sortBy)
                .pageNum(pageNo)
                .pageSize(pageSize)
                .tagIds(tagIds)
                .email(email)
                .search(search)
                .difficulty(difficulty)
                .isPublic(isPublic)
                .build();
        GetCodeQuestionsResponse response = codeQuestionApplicationService.getAdminCodeQuestions(query);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/most-practicing-recently")
    public ResponseEntity<List<CodeQuestionDto>> getRecommendedCodeQuestion(
            @RequestHeader(value="Access-Token", required = false) String accessToken
    ){
        String email = JwtUtils.getEmailFromJwtStringWithoutCheckExp(accessToken);

        List<CodeQuestionDto> response = codeQuestionApplicationService.getRecommendedCodeQuestion(email);
        return ResponseEntity.ok(response);
    }

    //no neeed to delete

    //update
    @PutMapping("/{code-question-id}")
    public ResponseEntity updateCodeQuestion(
            @PathVariable(value = "code-question-id") UUID codeQuestionId,
            @RequestBody UpdateCodeQuestionCommand command)
    {
        command.setCodeQuestionId(codeQuestionId);
        codeQuestionApplicationService.updateCodeQuestion(command);
        return  ResponseEntity.noContent().build();
    }



    //edit code question tag
    @PostMapping("/{code-question-id}/tag")
    public ResponseEntity addTagToCodeQuestion(
            @PathVariable("code-question-id") UUID codeQuestionId,
            @RequestParam UUID userId,
            @RequestBody List<UUID> tagIds){
        AddTagToCodeQuestionCommand command = AddTagToCodeQuestionCommand.builder()
                .userId(userId)
                .codeQuestionId(codeQuestionId)
                .tagIds(tagIds)
                .build();
        codeQuestionApplicationService.addTagToCodeQuestion(command);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{code-question-id}/tag")
    public ResponseEntity deleteCodeQuestionTag(
            @PathVariable("code-question-id") UUID codeQuestionId,
            @RequestParam UUID userId,
            @RequestBody List<UUID> tagIds){
        DeleteCodeQuestionTagCommand command = DeleteCodeQuestionTagCommand.builder()
                .userId(userId)
                .codeQuestionId(codeQuestionId)
                .tagIds(tagIds)
                .build();
        codeQuestionApplicationService.deleteCodeQuestionTag(command);
        return ResponseEntity.noContent().build();
    }


    //edit code question language
    @PostMapping("{code-question-id}/language")
    public ResponseEntity addLanguageToCodeQuestion(
            @PathVariable("code-question-id") UUID codeQuestionId,
            @RequestParam UUID userId,
            @RequestBody List<@Valid ProgrammingLanguageDto> languages){
        AddLanguageToCodeQuestionCommand command = AddLanguageToCodeQuestionCommand.builder()
                .codeQuestionId(codeQuestionId)
                .languages(languages)
                .userId(userId)
                .build();
        codeQuestionApplicationService.addLanguageToCodeQuestion(command);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{code-question-id}/language")
    public ResponseEntity deleteProgrammingLanguageCodeQuestion(
            @PathVariable("code-question-id") UUID codeQuestionId,
            @RequestParam UUID userId,
            @RequestBody List<UUID> languages){
        DeleteLanguageToCodeQuestionCommand command = DeleteLanguageToCodeQuestionCommand.builder()
                .codeQuestionId(codeQuestionId)
                .userId(userId)
                .languageIds(languages)
                .build();
        codeQuestionApplicationService.deleteProgrammingLanguageCodeQuestion(command);
        return ResponseEntity.noContent().build();
    }

}
