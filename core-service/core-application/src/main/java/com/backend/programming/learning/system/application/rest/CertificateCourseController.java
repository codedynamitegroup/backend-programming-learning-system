package com.backend.programming.learning.system.application.rest;

import com.backend.programming.learning.system.domain.dto.create.CreateCertificateCourseCommand;
import com.backend.programming.learning.system.domain.dto.create.CreateCertificateCourseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/certificate-courses", produces = "application/vnd.api.v1+json")
public class CertificateCourseController {
//    private final CertificateCourseApplicationService certificateCourseApplicationService;
//
//    public CertificateCourseController(CertificateCourseApplicationService certificateCourseApplicationService) {
//        this.certificateCourseApplicationService = certificateCourseApplicationService;
//    }
//
//    @PostMapping
//    public ResponseEntity<CreateCertificateCourseResponse> createCertificateCourse(
//            @RequestBody CreateCertificateCourseCommand createCertificateCourseCommand) {
//        log.info("Creating order for customer: {} at restaurant: {}", createOrderCommand.getCustomerId(),
//                createOrderCommand.getRestaurantId());
//        CreateCertificateCourseResponse createCertificateCourseResponse = orderApplicationService.createOrder(createOrderCommand);
//        log.info("Order created with tracking id: {}", createOrderResponse.getOrderTrackingId());
//        return ResponseEntity.ok(createOrderResponse);
//    }

}
