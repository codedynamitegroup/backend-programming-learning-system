package com.backend.programming.learning.system.auth.service.application.rest.course_user;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.course.CreateCourseResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.course_user.CreateCourseUserCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.course_user.CreateCourseUserResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.course_user.DeleteCourseUserCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.course_user.*;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.course.UserCourseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.course_user.CourseUserResponseEntity;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.course_user.CourseUserApplicationService;
import com.backend.programming.learning.system.course.service.domain.valueobject.CourseUserId;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

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

    @GetMapping("/{courseId}")
    @Operation(summary = "Query course user.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = CourseUserResponseEntity.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<CourseUserResponseEntity> queryAllByCourseId(
            @PathVariable UUID courseId) {
        log.info("Query course user by course id: {}", courseId);
        CourseUserResponseEntity response = courseUserApplicationService.queryAllByCourseId(new QueryCourseUserCommand(courseId));
        log.info("Course user by course id: {}", response);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{courseId}/user")
    @Operation(summary = "Query course user.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = UserCourseEntity.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<QueryAllCourseUserResponse> queryAllUserByCourseId(
            @PathVariable UUID courseId,
            @RequestParam(defaultValue = "") String search,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        log.info("Query user by course id: {}", courseId);
        QueryAllCourseUserCommand queryAllCourseUserCommand = QueryAllCourseUserCommand.builder()
                .search(search)
                .pageNo(pageNo)
                .pageSize(pageSize)
                .build();
        QueryAllCourseUserResponse response = courseUserApplicationService.queryAllUserByCourseId(
                new CourseUserId(courseId),
                queryAllCourseUserCommand);
        log.info("User by course id: {}", response);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{courseId}/count")
    @Operation(summary = "Count student by course id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = Integer.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<Integer> countStudentByCourseId(
            @PathVariable UUID courseId) {
        log.info("Count student by course id: {}", courseId);
        Integer response = courseUserApplicationService.countStudentByCourseId(courseId);
        log.info("Student by course id: {}", response);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/user/{userId}")
    @Operation(summary = "Query all course by user id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryAllCourseByUserResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<QueryAllCourseByUserResponse> queryAllCourseByUser(
            @PathVariable UUID userId,
            @RequestParam(defaultValue = "") String search,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(required = false) Optional<String[]> courseType) {
        log.info("Query all course by user id: {}", userId);
        QueryAllCourseByUserCommand queryAllCourseByUserCommand = QueryAllCourseByUserCommand.builder()
                .userId(userId)
                .search(search)
                .pageNo(pageNo)
                .pageSize(pageSize)
                .courseType(courseType.orElse(null))
                .build();
        QueryAllCourseByUserResponse response = courseUserApplicationService.queryAllCourseByUser(queryAllCourseByUserCommand);
        log.info("Course by user id: {}", response);
        return ResponseEntity.ok(response);
    }


}
