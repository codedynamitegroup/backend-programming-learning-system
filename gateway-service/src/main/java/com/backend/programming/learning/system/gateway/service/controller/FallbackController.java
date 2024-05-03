package com.backend.programming.learning.system.gateway.service.controller;

import com.backend.programming.learning.system.gateway.service.model.AuthServiceFallbackModel;
import com.backend.programming.learning.system.gateway.service.model.CodeAssessmentServiceFallbackModel;
import com.backend.programming.learning.system.gateway.service.model.CoreServiceFallbackModel;
import com.backend.programming.learning.system.gateway.service.model.CourseServiceFallbackModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @PostMapping("/core-fallback")
    public ResponseEntity<CoreServiceFallbackModel> coreServiceFallback() {
        log.info("Returning fallback result for core-service!");
        return ResponseEntity.ok(CoreServiceFallbackModel.builder()
                .fallbackMessage("Fallback result for core-service!")
                .build());
    }

    @PostMapping("/course-fallback")
    public ResponseEntity<CourseServiceFallbackModel> courseServiceFallback() {
        log.info("Returning fallback result for course-service!");
        return ResponseEntity.ok(CourseServiceFallbackModel.builder()
                .fallbackMessage("Fallback result for course-service!")
                .build());
    }


    @PostMapping("/auth-fallback")
    public ResponseEntity<AuthServiceFallbackModel> authServiceFallback() {
        log.info("Returning fallback result for auth-service!");
        return ResponseEntity.ok(AuthServiceFallbackModel.builder()
                .fallbackMessage("Fallback result for auth-service!")
                .build());
    }

    @PostMapping("/code-assessment-fallback")
    public ResponseEntity<CodeAssessmentServiceFallbackModel> codeAssessmentServiceFallback() {
        log.info("Returning fallback result for code-assessment-service!");
        return ResponseEntity.ok(CodeAssessmentServiceFallbackModel.builder()
                .fallbackMessage("Fallback result for code-assessment-service!")
                .build());
    }

}
