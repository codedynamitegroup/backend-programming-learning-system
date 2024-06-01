package com.backend.programming.learning.system.auth.service.application.rest.course_type;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.course.CreateCourseResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.course_type.QueryAllCourseTypeResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.course_type.QueryCourseTypeCommand;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.course_type.CourseTypeApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


    @GetMapping("/{organizationId}")
    @Operation(summary = "Get all course types by organization id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryAllCourseTypeResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public QueryAllCourseTypeResponse getAllCourseTypesByOrganizationId(@PathVariable UUID organizationId) {
        return courseTypeApplicationService.findAllByOrganizationId(new QueryCourseTypeCommand(organizationId));
    }

}
