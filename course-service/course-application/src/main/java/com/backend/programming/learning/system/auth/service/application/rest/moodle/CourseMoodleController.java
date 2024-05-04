package com.backend.programming.learning.system.auth.service.application.rest.moodle;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.CreateExamSubmissionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.course.CourseMoodleResponseEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
public class CourseMoodleController {
    // tạm để ở controller này
    String GET_ALL_COURSES = "core_course_get_courses";
    String GET_COURSE_BY_USER = "core_enrol_get_users_courses";
    String MOODLE_URL = "http://62.171.185.208/webservice/rest/server.php";
    String TOKEN = "cdf90b5bf53bcae577c60419702dbee7";

    @GetMapping
    @Operation(summary = "Get all courses.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = String.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<String> getCourse() {
        String apiURL = String.format("%s?wstoken=%s&moodlewsrestformat=json&wsfunction=%s",
                MOODLE_URL, TOKEN, GET_ALL_COURSES);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity(apiURL, String.class);
    }

    @GetMapping("/user")
    @Operation(summary = "Get course by user.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = String.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<String> getCourseByUser(
            @RequestParam(value = "userId", required = false) String userId
    ) {
        String apiURL = String.format("%s?wstoken=%s&moodlewsrestformat=json&wsfunction=%s&userid=%s",
                MOODLE_URL, TOKEN, GET_COURSE_BY_USER, userId);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity(apiURL, String.class);
    }
}
