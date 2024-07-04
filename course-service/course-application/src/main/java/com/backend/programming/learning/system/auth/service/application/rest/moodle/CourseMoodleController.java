package com.backend.programming.learning.system.auth.service.application.rest.moodle;

import com.backend.programming.learning.system.course.service.domain.dto.responseentity.course.CourseMoodleResponseEntity;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.moodle.MoodleApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

/**
 * com.backend.programming.learning.system.auth.service.application.rest.course
 * Create by Dang Ngoc Tien
 * Date 4/30/2024 - 11:36 PM
 * Description: ...
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/course/course/moodle", produces = "application/vnd.api.v1+json")
public class CourseMoodleController {
    private final MoodleApplicationService moodleApplicationService;

    @PostMapping("{organizationId}")
    public ResponseEntity<String> syncCourse(@PathVariable UUID organizationId) {
        return ResponseEntity.ok(moodleApplicationService.syncCourse(organizationId));
    }

    @PostMapping("resource/{organizationId}")
    public ResponseEntity<String> syncResource(@PathVariable UUID organizationId) {
        return ResponseEntity.ok(moodleApplicationService.syncResource(organizationId));
    }
    @PostMapping("exam/sync")
    public ResponseEntity<String> syncCourseExam() {
        return ResponseEntity.ok(moodleApplicationService.syncCourseExam());
    }
}
