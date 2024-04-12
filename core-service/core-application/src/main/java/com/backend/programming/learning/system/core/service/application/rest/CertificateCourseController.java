package com.backend.programming.learning.system.core.service.application.rest;

import com.backend.programming.learning.system.core.service.domain.dto.create.CreateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.CreateCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.create.CreateQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.CreateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.CoreApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/core/certificate-courses", produces = "application/vnd.api.v1+json")
public class CertificateCourseController {
    private final CoreApplicationService coreApplicationService;

    public CertificateCourseController(CoreApplicationService coreApplicationService) {
        this.coreApplicationService = coreApplicationService;
    }

    @PostMapping("/create")
    public ResponseEntity<CreateCertificateCourseResponse> createCertificateCourse(
            @RequestBody CreateCertificateCourseCommand createCertificateCourseCommand) {
        log.info("Creating certificate course: {}", createCertificateCourseCommand);
        CreateCertificateCourseResponse createCertificateCourseResponse =
                coreApplicationService.createCertificateCourse(createCertificateCourseCommand);
        log.info("Certificate course created: {}", createCertificateCourseResponse);

        return ResponseEntity.ok(createCertificateCourseResponse);
    }

}
