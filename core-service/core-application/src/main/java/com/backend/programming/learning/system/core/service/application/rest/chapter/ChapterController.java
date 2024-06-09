package com.backend.programming.learning.system.core.service.application.rest.chapter;

import com.backend.programming.learning.system.core.service.application.utils.JwtUtils;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.certificatecourse.CreateCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.chapter.CreateChapterCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.chapter.CreateChapterResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.chapter.DeleteChapterCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.chapter.DeleteChapterResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.certificatecourse.QueryAllCertificateCourseUsersCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.certificatecourse.QueryAllCertificateCourseUsersResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.chapter.QueryAllChaptersCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.chapter.QueryAllChaptersResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.chapter.QueryChapterCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.chapter.UpdateChapterCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.chapter.UpdateChapterResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.topic.UpdateTopicCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.topic.UpdateTopicResponse;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.chapter.ChapterResponseEntity;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.chapter.ChapterApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(value = "/core/chapters", produces = "application/vnd.api.v1+json")
public class ChapterController {
    private final ChapterApplicationService chapterApplicationService;

    public ChapterController(ChapterApplicationService chapterApplicationService) {
        this.chapterApplicationService = chapterApplicationService;
    }

    @PostMapping("/create")
    @Operation(summary = "Create chapter.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = CreateChapterResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<CreateChapterResponse> createChapter(
            @RequestBody CreateChapterCommand createChapterCommand) {
        log.info("Creating chapter: {}", createChapterCommand);
        CreateChapterResponse createChapterResponse =
                chapterApplicationService.createChapter(createChapterCommand);
        log.info("Chapter created: {}", createChapterResponse);

        return ResponseEntity.status(HttpStatus.CREATED).body(createChapterResponse);
    }

    @PostMapping("/chapter-resources/create")
    @Operation(summary = "Create chapter resource by chapter id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = CreateChapterResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<CreateChapterResponse> createChapterResource() {
        return null;
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update chapter.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = UpdateChapterResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<UpdateChapterResponse> updateChapter(
            @PathVariable UUID id,
            @RequestBody UpdateChapterCommand updateChapterCommand) {
        log.info("Updating chapter: {}", id);
        UpdateChapterResponse updateChapterResponse =
                chapterApplicationService.updateChapter(UpdateChapterCommand
                        .builder()
                        .no(updateChapterCommand.getNo())
                        .chapterId(id)
                        .title(updateChapterCommand.getTitle())
                        .description(updateChapterCommand.getDescription())
                        .build());
        log.info("Chapter updated: {}", updateChapterResponse.getChapterId());
        return ResponseEntity.ok(updateChapterResponse);
    }

    @GetMapping
    @Operation(summary = "Get all chapters by certificate course id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryAllChaptersResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<QueryAllChaptersResponse> getAllChapters(
            @RequestHeader(value = "Access-Token", required = false) String accessToken,
            @RequestParam UUID certificateCourseId) {
        String email = JwtUtils.getEmailFromJwtString(accessToken);

        QueryAllChaptersResponse queryAllChaptersResponse =
                chapterApplicationService.queryAllChapters(QueryAllChaptersCommand
                        .builder()
                        .certificateCourseId(certificateCourseId)
                        .email(email)
                        .build());
        log.info("Returning all chapters: {}", queryAllChaptersResponse);
        return ResponseEntity.ok(queryAllChaptersResponse);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get chapter by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = ChapterResponseEntity.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<ChapterResponseEntity> getChapter(
            @RequestHeader(value = "Access-Token", required = false) String accessToken,
            @PathVariable UUID id) {
        String email = JwtUtils.getEmailFromJwtString(accessToken);

        ChapterResponseEntity chapterResponseEntity =
                chapterApplicationService.queryChapter(QueryChapterCommand
                        .builder()
                        .chapterId(id)
                        .email(email)
                        .build());
        log.info("Returning chapter: {}", chapterResponseEntity);
        return ResponseEntity.ok(chapterResponseEntity);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete chapter by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = DeleteChapterResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<DeleteChapterResponse> deleteChapter(@PathVariable UUID id) {
        DeleteChapterResponse deleteChapterResponse =
                chapterApplicationService.deleteChapter(DeleteChapterCommand
                        .builder()
                        .chapterId(id)
                        .build());
        log.info("Chapter deleted: {}", id);
        return ResponseEntity.ok(deleteChapterResponse);
    }
}
