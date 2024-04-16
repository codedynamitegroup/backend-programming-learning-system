package com.backend.programming.learning.system.core.service.application.rest.chapter;

import com.backend.programming.learning.system.core.service.domain.dto.create.certificatecourse.CreateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.certificatecourse.CreateCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.create.certificatecourse_user.CreateCertificateCourseUserCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.certificatecourse_user.CreateCertificateCourseUserResponse;
import com.backend.programming.learning.system.core.service.domain.dto.create.chapter.CreateChapterCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.chapter.CreateChapterResponse;
import com.backend.programming.learning.system.core.service.domain.dto.delete.certificatecourse.DeleteCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.delete.certificatecourse.DeleteCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.delete.chapter.DeleteChapterCommand;
import com.backend.programming.learning.system.core.service.domain.dto.delete.chapter.DeleteChapterResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.certificatecourse.QueryAllCertificateCoursesCommand;
import com.backend.programming.learning.system.core.service.domain.dto.query.certificatecourse.QueryAllCertificateCoursesResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.certificatecourse.QueryCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.query.certificatecourse.QueryCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.chapter.QueryAllChaptersCommand;
import com.backend.programming.learning.system.core.service.domain.dto.query.chapter.QueryAllChaptersResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.chapter.QueryChapterCommand;
import com.backend.programming.learning.system.core.service.domain.dto.query.chapter.QueryChapterResponse;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.certificatecourse.CertificateCourseApplicationService;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.certificatecourse_user.CertificateCourseUserApplicationService;
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
    public ResponseEntity<QueryChapterResponse> getChapter(@PathVariable UUID id) {
        QueryChapterResponse queryChapterResponse =
                chapterApplicationService.queryChapter(QueryChapterCommand
                        .builder()
                        .chapterId(id)
                        .build());
        log.info("Returning chapter: {}", queryChapterResponse);
        return ResponseEntity.ok(queryChapterResponse);
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
