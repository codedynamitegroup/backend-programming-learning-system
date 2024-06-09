package com.backend.programming.learning.system.core.service.application.rest.chapter;

import com.backend.programming.learning.system.core.service.application.utils.JwtUtils;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.chapter.CreateChapterCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.chapter.CreateChapterResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.chapter.DeleteChapterCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.chapter.DeleteChapterResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.chapter.QueryAllChaptersCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.chapter.QueryAllChaptersResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.chapter.QueryChapterCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.chapter.UpdateChapterCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.chapter.CreateChapterResourceUserCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.chapter.CreateChapterResourceUserResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.chapter.UpdateChapterResponse;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.chapter.ChapterResponseEntity;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.chapter.ChapterApplicationService;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.chapter_resource_user.ChapterResourceUserApplicationService;
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
    private final ChapterResourceUserApplicationService chapterResourceUserApplicationService;

    public ChapterController(ChapterApplicationService chapterApplicationService,
                             ChapterResourceUserApplicationService chapterResourceUserApplicationService) {
        this.chapterApplicationService = chapterApplicationService;
        this.chapterResourceUserApplicationService = chapterResourceUserApplicationService;
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
        String email = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof JwtAuthenticationToken jwtAuthenticationToken) {
            Jwt token = jwtAuthenticationToken.getToken();
            email = token.getClaim("preferred_username");
        }

        log.info("Creating chapter: {}", createChapterCommand);
        CreateChapterResponse createChapterResponse =
                chapterApplicationService.createChapter(
                        CreateChapterCommand
                                .builder()
                                .certificateCourseId(createChapterCommand.getCertificateCourseId())
                                .title(createChapterCommand.getTitle())
                                .description(createChapterCommand.getDescription())
                                .email(email)
                                .build()
                );
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
        String email = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof JwtAuthenticationToken jwtAuthenticationToken) {
            Jwt token = jwtAuthenticationToken.getToken();
            email = token.getClaim("preferred_username");
        }

        return null;
    }

    @PostMapping("/chapter-resource-users/{id}")
    @Operation(summary = "Mark view for chapter resource of user.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = CreateChapterResourceUserResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<CreateChapterResourceUserResponse> createChapterResourceUser(
            @PathVariable UUID id) {
        String email = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof JwtAuthenticationToken jwtAuthenticationToken) {
            Jwt token = jwtAuthenticationToken.getToken();
            email = token.getClaim("preferred_username");
        }

        CreateChapterResourceUserResponse createChapterResourceUserResponse =
                chapterResourceUserApplicationService.createChapterResourceUser(
                        CreateChapterResourceUserCommand
                                .builder()
                                .chapterResourceId(id)
                                .email(email)
                                .build());
        log.info("ChapterResourceUser created: {}", createChapterResourceUserResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(createChapterResourceUserResponse);
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
        String email = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof JwtAuthenticationToken jwtAuthenticationToken) {
            Jwt token = jwtAuthenticationToken.getToken();
            email = token.getClaim("preferred_username");
        }

        log.info("Updating chapter: {}", id);
        UpdateChapterResponse updateChapterResponse =
                chapterApplicationService.updateChapter(UpdateChapterCommand
                        .builder()
                        .no(updateChapterCommand.getNo())
                        .chapterId(id)
                        .title(updateChapterCommand.getTitle())
                        .description(updateChapterCommand.getDescription())
                        .email(email)
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
