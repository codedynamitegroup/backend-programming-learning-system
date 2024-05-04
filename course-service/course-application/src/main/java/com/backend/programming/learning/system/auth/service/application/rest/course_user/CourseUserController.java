package com.backend.programming.learning.system.auth.service.application.rest.course_user;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.course.CreateCourseResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.course_user.CreateCourseUserCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.course_user.CreateCourseUserResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.course_user.DeleteCourseUserCommand;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.course_user.CourseUserApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * com.backend.programming.learning.system.auth.service.application.rest.course_user
 * Create by Dang Ngoc Tien
 * Date 4/20/2024 - 10:04 AM
 * Description: ...
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/course/course-user", produces = "application/vnd.api.v1+json")
public class CourseUserController {
    private final CourseUserApplicationService courseUserApplicationService;
    @PostMapping("/assign")
    @Operation(summary = "Create course user.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = CreateCourseUserResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<CreateCourseUserResponse> assignCourseToUser(
            @RequestBody CreateCourseUserCommand createCourseUserCommand) {
        log.info("Assign course to user");
        CreateCourseUserResponse response = courseUserApplicationService.assignCourseToUser(createCourseUserCommand);
        log.info("Course assigned to user: {}", response);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @DeleteMapping("/un-assign")
    @Operation(summary = "Delete course user.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = CreateCourseUserResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<CreateCourseUserResponse> unAssignCourseToUser(
            @RequestBody DeleteCourseUserCommand deleteCourseUserCommand) {
        log.info("Un-assign course to user");
        CreateCourseUserResponse response = courseUserApplicationService.unAssignCourseToUser(deleteCourseUserCommand);
        log.info("Course un-assigned to user: {}", response);
        return ResponseEntity.ok(response);
    }

}
