package com.backend.programming.learning.system.auth.service.application.rest.moodle;

import com.backend.programming.learning.system.course.service.domain.ports.input.service.moodle_course.MoodleCourseApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
public class MoodleCourseController {
 private final MoodleCourseApplicationService moodleCourseApplicationService;

    @PostMapping("/sync")
    public ResponseEntity<String> syncCourse() {
        moodleCourseApplicationService.syncCourse();
        return ResponseEntity.ok("Sync course successfully!");
    }

}
