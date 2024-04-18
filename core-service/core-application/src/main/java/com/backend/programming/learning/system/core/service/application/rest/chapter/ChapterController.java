package com.backend.programming.learning.system.core.service.application.rest.chapter;

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
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<CreateChapterResponse> createChapter(
            @RequestBody CreateChapterCommand createChapterCommand) {
        log.info("Creating chapter: {}", createChapterCommand);
        CreateChapterResponse createChapterResponse =
                chapterApplicationService.createChapter(createChapterCommand);
        log.info("Chapter created: {}", createChapterResponse);

        return ResponseEntity.status(HttpStatus.CREATED).body(createChapterResponse);
    }

    @PutMapping("/{id}")
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
    public ResponseEntity<QueryAllChaptersResponse> getAllChapters(
            @RequestParam UUID certificateCourseId) {
        QueryAllChaptersResponse queryAllChaptersResponse =
                chapterApplicationService.queryAllChapters(QueryAllChaptersCommand
                        .builder()
                        .certificateCourseId(certificateCourseId)
                        .build());
        log.info("Returning all chapters: {}", queryAllChaptersResponse);
        return ResponseEntity.ok(queryAllChaptersResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChapterResponseEntity> getChapter(@PathVariable UUID id) {
        ChapterResponseEntity chapterResponseEntity =
                chapterApplicationService.queryChapter(QueryChapterCommand
                        .builder()
                        .chapterId(id)
                        .build());
        log.info("Returning chapter: {}", chapterResponseEntity);
        return ResponseEntity.ok(chapterResponseEntity);
    }

    @DeleteMapping("/{id}")
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
