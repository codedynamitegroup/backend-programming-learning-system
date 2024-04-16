package com.backend.programming.learning.system.core.service.application.rest;

import com.backend.programming.learning.system.core.service.domain.dto.create.certificatecourse.CreateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.certificatecourse.CreateCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.create.certificatecourse_user.CreateCertificateCourseUserCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.certificatecourse_user.CreateCertificateCourseUserResponse;
import com.backend.programming.learning.system.core.service.domain.dto.create.chapter.CreateChapterCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.chapter.CreateChapterResponse;
import com.backend.programming.learning.system.core.service.domain.dto.create.review.CreateReviewCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.review.CreateReviewResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.certificatecourse.QueryCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.query.certificatecourse.QueryCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.certificatecourse.CertificateCourseApplicationService;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.certificatecourse_user.CertificateCourseUserApplicationService;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.chapter.ChapterApplicationService;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.review.ReviewApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(value = "/core/certificate-courses", produces = "application/vnd.api.v1+json")
public class CertificateCourseController {
    private final CertificateCourseApplicationService certificateCourseApplicationService;
    private final CertificateCourseUserApplicationService certificateCourseUserApplicationService;
    private final ChapterApplicationService chapterApplicationService;

    public CertificateCourseController(CertificateCourseApplicationService certificateCourseApplicationService,
                                       CertificateCourseUserApplicationService certificateCourseUserApplicationService,
                                       ChapterApplicationService chapterApplicationService) {
        this.certificateCourseApplicationService = certificateCourseApplicationService;
        this.certificateCourseUserApplicationService = certificateCourseUserApplicationService;
        this.chapterApplicationService = chapterApplicationService;
    }

    @PostMapping("/create")
    public ResponseEntity<CreateCertificateCourseResponse> createCertificateCourse(
            @RequestBody CreateCertificateCourseCommand createCertificateCourseCommand) {
        log.info("Creating certificate course: {}", createCertificateCourseCommand);
        CreateCertificateCourseResponse createCertificateCourseResponse =
                certificateCourseApplicationService.createCertificateCourse(createCertificateCourseCommand);
        log.info("Certificate course created: {}", createCertificateCourseResponse);

        return ResponseEntity.status(HttpStatus.CREATED).body(createCertificateCourseResponse);
    }

    @PostMapping("/register")
    public ResponseEntity<CreateCertificateCourseUserResponse> registerCertificateCourse(
            @RequestBody CreateCertificateCourseUserCommand createCertificateCourseUserCommand) {
        log.info("Creating Certificate course User course: {}", createCertificateCourseUserCommand);
        CreateCertificateCourseUserResponse createCertificateCourseUserResponse =
                certificateCourseUserApplicationService.createCertificateCourseUser(createCertificateCourseUserCommand);
        log.info("Certificate course User created: {}", createCertificateCourseUserResponse);

        return ResponseEntity.status(HttpStatus.CREATED).body(createCertificateCourseUserResponse);
    }

    @PostMapping("/chapters/create")
    public ResponseEntity<CreateChapterResponse> createChapter(
            @RequestBody CreateChapterCommand createChapterCommand) {
        log.info("Creating chapter of certificate course: {}", createChapterCommand);
        CreateChapterResponse createChapterResponse =
                chapterApplicationService.createChapter(createChapterCommand);
        log.info("Chapter of certificate course created: {}", createChapterResponse);

        return ResponseEntity.status(HttpStatus.CREATED).body(createChapterResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QueryCertificateCourseResponse> getCertificateCourseById(@PathVariable UUID id) {
        QueryCertificateCourseResponse queryCertificateCourseResponse =
                certificateCourseApplicationService.findCertificateCourseById(
                        QueryCertificateCourseCommand.builder().certificateCourseId(id).build());
        log.info("Returning certificate course: {}", queryCertificateCourseResponse.getCertificateCourse());
        return  ResponseEntity.ok(queryCertificateCourseResponse);
    }

}
