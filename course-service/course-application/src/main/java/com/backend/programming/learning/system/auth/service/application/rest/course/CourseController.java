package com.backend.programming.learning.system.auth.service.application.rest.course;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.call_moodle_api_function.CreateCallMoodleApiFunctionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.course.CreateCourseCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.course.CreateCourseResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.course.DeleteCourseCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.course.DeleteCourseResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.course.QueryAllCourseCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.course.QueryAllCourseResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.course.QueryCourseCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.course.UpdateCourseCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.course.UpdateCourseResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.course.CourseResponseEntity;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.course.CourseApplicationService;
import com.backend.programming.learning.system.course.service.domain.valueobject.CourseId;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.auth.service.application.rest
 * Create by Dang Ngoc Tien
 * Date 4/17/2024 - 1:50 AM
 * Description: ...
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/course/course", produces = "application/vnd.api.v1+json")
public class CourseController {
    private final CourseApplicationService courseApplicationService;

    @PostMapping("/create")
    @Operation(summary = "Create course.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = CreateCourseResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<CreateCourseResponse> createCourse(
            @RequestBody CreateCourseCommand createCourseCommand) {
        log.info("Creating course: {}", createCourseCommand);
        CreateCourseResponse response = courseApplicationService.createCourse(createCourseCommand);
        log.info("Course created: {}", response);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    @Operation(summary = "Get all courses.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryAllCourseResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<QueryAllCourseResponse> findAll(
            @RequestParam(defaultValue = "") String search,
            @RequestParam(required = false) Optional<String[]> courseType,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        log.info("Getting list course");


        QueryAllCourseCommand queryAllCourseCommand = QueryAllCourseCommand.builder()
                .search(search)
                .pageNo(pageNo)
                .pageSize(pageSize)
                .courseType(courseType.orElse(null))
                .build();

        QueryAllCourseResponse response = courseApplicationService.findAll(queryAllCourseCommand);
        log.info("Returning all courses: {}", response);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{courseId}")
    @Operation(summary = "Get course by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = CourseResponseEntity.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<CourseResponseEntity> findBy(@PathVariable UUID courseId) {
        log.info("Getting course with id: {}", courseId);
        QueryCourseCommand queryCourseCommand = QueryCourseCommand.builder().courseId(courseId).build();
        CourseResponseEntity response = courseApplicationService.findBy(queryCourseCommand);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{courseId}")
    @Operation(summary = "Delete course by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = DeleteCourseResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<DeleteCourseResponse> deleteCourse(@PathVariable UUID courseId) {
        log.info("Deleting course with id: {}", courseId);
        DeleteCourseCommand deleteCourseCommand = DeleteCourseCommand.builder().courseId(courseId).build();
        DeleteCourseResponse response = courseApplicationService.deleteCourse(deleteCourseCommand);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{courseId}")
    @Operation(summary = "Update course by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = UpdateCourseResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<UpdateCourseResponse> updateCourse(
            @PathVariable UUID courseId,
            @RequestBody UpdateCourseCommand updateCourseCommand
    ) {
        log.info("Updating course with id: {}", courseId);
        UpdateCourseResponse response = courseApplicationService.updateCourse(
                new CourseId(courseId),
                updateCourseCommand);
        return ResponseEntity.ok(response);
    }
}
