package com.backend.programming.learning.system.auth.service.application.rest.course_type;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.course.CreateCourseCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.course.CreateCourseResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.course_type.CreateCourseTypeCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.course_type.CreateCourseTypeResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.course.DeleteCourseCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.course.DeleteCourseResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.course_type.DeleteCourseTypeResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.course_type.QueryAllCourseTypeResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.course_type.QueryCourseTypeCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.course.UpdateCourseCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.course.UpdateCourseResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.course_type.UpdateCourseTypeCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.course_type.UpdateCourseTypeResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.course_type.CourseTypeResponseEntity;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.course_type.CourseTypeApplicationService;
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
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/course/course-type", produces = "application/vnd.api.v1+json")
public class CourseTypeController {
    private final CourseTypeApplicationService courseTypeApplicationService;

    @GetMapping
    @Operation(summary = "Get all course types.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryAllCourseTypeResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public QueryAllCourseTypeResponse getAllCourseTypes() {
        return courseTypeApplicationService.findAll();
    }


    @GetMapping("organization/{organizationId}")
    @Operation(summary = "Get all course types by organization id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryAllCourseTypeResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public QueryAllCourseTypeResponse getAllCourseTypesByOrganizationId(
            @PathVariable UUID organizationId,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "") String searchName) {
        return courseTypeApplicationService.findAllByOrganizationId(QueryCourseTypeCommand.builder()
                .organizationId(organizationId)
                .pageNo(pageNo)
                .pageSize(pageSize)
                .searchName(searchName)
                .build());
    }

    @PostMapping
    @Operation(summary = "Create course type.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = CreateCourseTypeResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<CreateCourseTypeResponse> createCourseType(
            @RequestBody CreateCourseTypeCommand createCourseTypeCommand) {
        log.info("Creating course type: {}", createCourseTypeCommand);
        CreateCourseTypeResponse response = courseTypeApplicationService.createCourseType(createCourseTypeCommand);
        log.info("Course created: {}", response);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{courseTypeId}")
    @Operation(summary = "Delete course type by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = DeleteCourseResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<DeleteCourseTypeResponse> deleteCourseType(@PathVariable UUID courseTypeId) {
        DeleteCourseTypeResponse response = courseTypeApplicationService.deleteCourseType(courseTypeId);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{courseTypeId}")
    @Operation(summary = "Update course type by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = UpdateCourseResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<UpdateCourseTypeResponse> updateCourseType(
            @PathVariable UUID courseTypeId,
            @RequestBody UpdateCourseTypeCommand updateCourseTypeCommand
    ) {
        UpdateCourseTypeResponse response = courseTypeApplicationService.updateCourseType(
                UpdateCourseTypeCommand.builder()
                        .id(courseTypeId)
                        .name(updateCourseTypeCommand.name())
                        .build());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{courseTypeId}")
    @Operation(summary = "Get course type by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = UpdateCourseResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<CourseTypeResponseEntity> getCourseTypeDetails(
            @PathVariable UUID courseTypeId
    ) {
        CourseTypeResponseEntity response = courseTypeApplicationService.findById(courseTypeId);
        return ResponseEntity.ok(response);
    }
}
