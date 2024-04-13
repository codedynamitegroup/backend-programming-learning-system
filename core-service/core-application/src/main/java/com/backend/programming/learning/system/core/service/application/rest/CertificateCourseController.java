package com.backend.programming.learning.system.core.service.application.rest;

import com.backend.programming.learning.system.core.service.domain.dto.create.CreateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.CreateCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.QueryCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.query.QueryCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.CertificateCourseApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(value = "/core/certificate-courses", produces = "application/vnd.api.v1+json")
public class CertificateCourseController {
    private final CertificateCourseApplicationService certificateCourseApplicationService;

    public CertificateCourseController(CertificateCourseApplicationService certificateCourseApplicationService) {
        this.certificateCourseApplicationService = certificateCourseApplicationService;
    }

    @PostMapping("/create")
    public ResponseEntity<CreateCertificateCourseResponse> createCertificateCourse(
            @RequestBody CreateCertificateCourseCommand createCertificateCourseCommand) {
        log.info("Creating certificate course: {}", createCertificateCourseCommand);
        CreateCertificateCourseResponse createCertificateCourseResponse =
                certificateCourseApplicationService.createCertificateCourse(createCertificateCourseCommand);
        log.info("Certificate course created: {}", createCertificateCourseResponse);

        return ResponseEntity.ok(createCertificateCourseResponse);
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
