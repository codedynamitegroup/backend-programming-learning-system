package com.backend.programming.learning.system.core.service.application.rest.certificatecourse;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.certificatecourse.CreateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.certificatecourse.CreateCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.certificatecourse_user.CreateCertificateCourseUserCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.certificatecourse_user.CreateCertificateCourseUserResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.certificatecourse.DeleteCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.certificatecourse.DeleteCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.certificatecourse.*;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.certificatecourse.CertificateCourseResponseEntity;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.certificatecourse.CertificateCourseApplicationService;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.certificatecourse_user.CertificateCourseUserApplicationService;
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
    public ResponseEntity<CertificateCourseResponseEntity> getCertificateCourseById(@PathVariable UUID id) {
        CertificateCourseResponseEntity certificateCourseResponseEntity =
                certificateCourseApplicationService.queryCertificateCourse(QueryCertificateCourseCommand
                        .builder()
                        .certificateCourseId(id)
                        .build());
        log.info("Returning certificate course: {}", certificateCourseResponseEntity.getCertificateCourseId());
        return  ResponseEntity.ok(certificateCourseResponseEntity);
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

    @GetMapping("/users")
    public ResponseEntity<QueryAllCertificateCourseUsersResponse> getAllUsersOfCertificateCourse(
            @RequestParam UUID certificateCourseId,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "false") Boolean fetchAll) {
        QueryAllCertificateCourseUsersResponse queryAllCertificateCourseUsersResponse =
                certificateCourseApplicationService.queryAllCertificateCourseUsers(
                        QueryAllCertificateCourseUsersCommand
                        .builder()
                        .certificateCourseId(certificateCourseId)
                        .pageNo(pageNo)
                        .pageSize(pageSize)
                        .fetchAll(fetchAll)
                        .build());
        log.info("Returning all users of certificate course: {}", certificateCourseId);
        return ResponseEntity.ok(queryAllCertificateCourseUsersResponse);
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
