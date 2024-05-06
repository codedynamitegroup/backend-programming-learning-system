package com.backend.programming.learning.system.auth.service.application.rest.moodle;

import com.backend.programming.learning.system.course.service.domain.dto.responseentity.course.CourseMoodleResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.course.CourseResponseEntity;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.moodle.MoodleApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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

    // tạm để ở controller này
    String GET_ALL_COURSES = "core_course_get_courses";
    String GET_COURSE_BY_USER = "core_enrol_get_users_courses";
    String MOODLE_URL = "http://62.171.185.208/webservice/rest/server.php";
    String TOKEN = "cdf90b5bf53bcae577c60419702dbee7";

    @GetMapping
    public ResponseEntity<String> getCourse() {
        String apiURL = String.format("%s?wstoken=%s&moodlewsrestformat=json&wsfunction=%s",
                MOODLE_URL, TOKEN, GET_ALL_COURSES);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity(apiURL, String.class);
    }

    @GetMapping("/user")
    public ResponseEntity<String> getCourseByUser(
            @RequestParam(value = "userId", required = false) String userId
    ) {
        String apiURL = String.format("%s?wstoken=%s&moodlewsrestformat=json&wsfunction=%s&userid=%s",
                MOODLE_URL, TOKEN, GET_COURSE_BY_USER, userId);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity(apiURL, String.class);
    }

    @PostMapping
    public ResponseEntity<List<CourseResponseEntity>> syncCourse() {
        List<CourseResponseEntity>courses = moodleApplicationService.syncCourse();
        return ResponseEntity.ok(courses);
    }
}
