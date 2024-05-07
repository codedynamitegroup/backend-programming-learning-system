package com.backend.programming.learning.system.auth.service.application.rest.moodle;

import com.backend.programming.learning.system.course.service.domain.dto.responseentity.course.CourseMoodleResponseEntity;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.moodle.MoodleApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
public class CourseMoodleController {
    // tạm để ở controller này
    private final MoodleApplicationService moodleApplicationService;
    String GET_ALL_COURSES = "core_course_get_courses";
    String GET_COURSE_BY_USER = "core_enrol_get_users_courses";
    String MOODLE_URL = "http://62.171.185.208/webservice/rest/server.php";
    String TOKEN = "cdf90b5bf53bcae577c60419702dbee7";

    @PostMapping
    public ResponseEntity<String> syncCourse() {
        return ResponseEntity.ok(moodleApplicationService.syncCourse());
    }
}
