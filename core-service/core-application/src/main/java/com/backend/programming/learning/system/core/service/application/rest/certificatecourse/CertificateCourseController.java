package com.backend.programming.learning.system.core.service.application.rest.certificatecourse;

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
@RequestMapping(value = "/core/certificate-courses", produces = "application/vnd.api.v1+json")
public class CertificateCourseController {
    private final CertificateCourseApplicationService certificateCourseApplicationService;
    private final CertificateCourseUserApplicationService certificateCourseUserApplicationService;

    public CertificateCourseController(CertificateCourseApplicationService certificateCourseApplicationService,
                                       CertificateCourseUserApplicationService certificateCourseUserApplicationService) {
        this.certificateCourseApplicationService = certificateCourseApplicationService;
        this.certificateCourseUserApplicationService = certificateCourseUserApplicationService;
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

    @GetMapping("/{id}")
    public ResponseEntity<QueryCertificateCourseResponse> getCertificateCourseById(@PathVariable UUID id) {
        QueryCertificateCourseResponse queryCertificateCourseResponse =
                certificateCourseApplicationService.queryCertificateCourse(QueryCertificateCourseCommand
                        .builder()
                        .certificateCourseId(id)
                        .build());
        log.info("Returning certificate course: {}", queryCertificateCourseResponse.getCertificateCourseId());
        return  ResponseEntity.ok(queryCertificateCourseResponse);
    }

    @GetMapping
    public ResponseEntity<QueryAllCertificateCoursesResponse> getAllCertificateCourses(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        QueryAllCertificateCoursesResponse queryAllCertificateCoursesResponse =
                certificateCourseApplicationService.queryAllCertificateCourses(QueryAllCertificateCoursesCommand
                        .builder()
                        .pageNo(pageNo)
                        .pageSize(pageSize)
                        .build());
        log.info("Returning all certificate courses");
        return ResponseEntity.ok(queryAllCertificateCoursesResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteCertificateCourseResponse> deleteCertificateCourse(@PathVariable UUID id) {
        DeleteCertificateCourseResponse deleteCertificateCourseResponse =
                certificateCourseApplicationService.deleteCertificateCourse(DeleteCertificateCourseCommand
                .builder()
                .certificateCourseId(id)
                .build());
        log.info("Certificate course deleted: {}", id);
        return ResponseEntity.ok(deleteCertificateCourseResponse);
    }
}
