package com.backend.programming.learning.system.course.service.application.rest.exam;

import com.backend.programming.learning.system.course.service.domain.ports.input.service.ExamApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * com.backend.programming.learning.system.course.application.rest.exam
 * Create by Dang Ngoc Tien
 * Date 3/21/2024 - 12:07 AM
 * Description: ...
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/exam", produces = "application/vnd.api.v1+json")
public class ExamController {
    private final ExamApplicationService examApplicationService;

    @GetMapping
    String getExam() {
        log.info("Getting exam");
        return examApplicationService.getExam();
    }
}
