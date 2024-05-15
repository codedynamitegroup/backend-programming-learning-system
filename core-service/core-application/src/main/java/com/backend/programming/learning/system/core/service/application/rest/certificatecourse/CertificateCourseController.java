package com.backend.programming.learning.system.core.service.application.rest.certificatecourse;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.certificatecourse.CreateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.certificatecourse.CreateCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.certificatecourse_user.CreateCertificateCourseUserCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.certificatecourse_user.CreateCertificateCourseUserResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.certificatecourse.DeleteCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.certificatecourse.DeleteCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.certificatecourse.*;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.certificatecourse.UpdateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.certificatecourse.UpdateCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.certificatecourse.CertificateCourseResponseEntity;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.certificatecourse.CertificateCourseApplicationService;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.certificatecourse_user.CertificateCourseUserApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(value = "/core/certificate-courses", produces = "application/vnd.api.v1+json")
public class CertificateCourseController {
    private final CertificateCourseApplicationService certificateCourseApplicationService;
    private final CertificateCourseUserApplicationService certificateCourseUserApplicationService;

    public CertificateCourseController(CertificateCourseApplicationService certificateCourseApplicationService,
                                       CertificateCourseUserApplicationService certificateCourseUserApplicationService) {
        this.certificateCourseApplicationService = certificateCourseApplicationService;
        this.certificateCourseUserApplicationService = certificateCourseUserApplicationService;
    }

    @PostMapping("/create")
    @Operation(summary = "Create Certificate course.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = CreateCertificateCourseResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<CreateCertificateCourseResponse> createCertificateCourse(
            @RequestBody CreateCertificateCourseCommand createCertificateCourseCommand) {
        log.info("Creating certificate course: {}", createCertificateCourseCommand);
        CreateCertificateCourseResponse createCertificateCourseResponse =
                certificateCourseApplicationService.createCertificateCourse(createCertificateCourseCommand);
        log.info("Certificate course created: {}", createCertificateCourseResponse);

        return ResponseEntity.status(HttpStatus.CREATED).body(createCertificateCourseResponse);
    }

    @PostMapping("/register")
    @Operation(summary = "Register Certificate course User.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = CreateCertificateCourseUserResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<CreateCertificateCourseUserResponse> registerCertificateCourse(
            @RequestBody CreateCertificateCourseUserCommand createCertificateCourseUserCommand) {
        log.info("Creating Certificate course User course: {}", createCertificateCourseUserCommand);
        CreateCertificateCourseUserResponse createCertificateCourseUserResponse =
                certificateCourseUserApplicationService.createCertificateCourseUser(createCertificateCourseUserCommand);
        log.info("Certificate course User created: {}", createCertificateCourseUserResponse);

        return ResponseEntity.status(HttpStatus.CREATED).body(createCertificateCourseUserResponse);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Certificate course.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = UpdateCertificateCourseResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<UpdateCertificateCourseResponse> updateCertificateCourse(
            @PathVariable UUID id,
            @RequestBody UpdateCertificateCourseCommand updateCertificateCourseCommand) {
        log.info("Updating certificate course: {}", id);
        UpdateCertificateCourseResponse updateCertificateCourseResponse =
                certificateCourseApplicationService.updateCertificateCourse(UpdateCertificateCourseCommand
                        .builder()
                        .certificateCourseId(id)
                        .name(updateCertificateCourseCommand.getName())
                        .description(updateCertificateCourseCommand.getDescription())
                        .skillLevel(updateCertificateCourseCommand.getSkillLevel())
                        .topicId(updateCertificateCourseCommand.getTopicId())
                        .startTime(updateCertificateCourseCommand.getStartTime())
                        .endTime(updateCertificateCourseCommand.getEndTime())
                        .updatedBy(updateCertificateCourseCommand.getUpdatedBy())
                        .build());
        log.info("Certificate course updated: {}", updateCertificateCourseResponse.getCertificateCourseId());
        return ResponseEntity.ok(updateCertificateCourseResponse);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Certificate course by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = CertificateCourseResponseEntity.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<CertificateCourseResponseEntity> getCertificateCourseById(@PathVariable UUID id) {
        CertificateCourseResponseEntity certificateCourseResponseEntity =
                certificateCourseApplicationService.queryCertificateCourse(QueryCertificateCourseCommand
                        .builder()
                        .certificateCourseId(id)
                        .build());
        log.info("Returning certificate course: {}", certificateCourseResponseEntity.getCertificateCourseId());
        return  ResponseEntity.ok(certificateCourseResponseEntity);
    }

    @PostMapping
    @Operation(summary = "Get all Certificate courses.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryAllCertificateCoursesResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<QueryAllCertificateCoursesResponse> getAllCertificateCourses(
            @RequestBody QueryAllCertificateCoursesCommand queryAllCertificateCoursesCommand) {
        QueryAllCertificateCoursesResponse queryAllCertificateCoursesResponse =
                certificateCourseApplicationService.queryAllCertificateCourses(queryAllCertificateCoursesCommand);
        log.info("Returning all certificate courses");
        return ResponseEntity.ok(queryAllCertificateCoursesResponse);
    }

    @PostMapping("/filter-by-is-registered")
    @Operation(summary = "Get all certificate courses filtered by is registered.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryAllCertificateCoursesResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<QueryAllCertificateCoursesResponse> getAllCertificateCoursesFilteredByIsRegistered(
            @RequestHeader("X-username") String username,
            @RequestBody QueryAllCertificateCoursesFilterByIsRegisteredCommand
                    queryAllCertificateCoursesFilterByIsRegisteredCommand) {
        QueryAllCertificateCoursesResponse queryAllCertificateCoursesResponse =
                certificateCourseApplicationService.
                        queryAllCertificateCoursesFilterByIsRegistered(
                                QueryAllCertificateCoursesFilterByIsRegisteredCommand.builder()
                                        .courseName(queryAllCertificateCoursesFilterByIsRegisteredCommand
                                                .getCourseName())
                                        .filterTopicIds(queryAllCertificateCoursesFilterByIsRegisteredCommand
                                                .getFilterTopicIds())
                                        .isRegistered(queryAllCertificateCoursesFilterByIsRegisteredCommand
                                                .isRegistered())
                                        .username(username)
                                        .build());
        log.info("Returning all certificate courses filtered by is registered");
        return ResponseEntity.ok(queryAllCertificateCoursesResponse);
    }

//    @GetMapping("/{id}/users")
//    @Operation(summary = "Get all users of Certificate course.")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Success.", content = {
//                    @Content(mediaType = "application/vnd.api.v1+json",
//                            schema = @Schema(implementation = QueryAllCertificateCourseUsersResponse.class))
//            }),
//            @ApiResponse(responseCode = "400", description = "Not found."),
//            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
//    public ResponseEntity<QueryAllCertificateCourseUsersResponse> getAllUsersOfCertificateCourse(
//            @PathVariable UUID id,
//            @RequestParam(defaultValue = "0") Integer pageNo,
//            @RequestParam(defaultValue = "10") Integer pageSize,
//            @RequestParam(defaultValue = "false") Boolean fetchAll) {
//        QueryAllCertificateCourseUsersResponse queryAllCertificateCourseUsersResponse =
//                certificateCourseUserApplicationService.queryAllCertificateCourseUsers(
//                        QueryAllCertificateCourseUsersCommand
//                        .builder()
//                        .certificateCourseId(id)
//                        .pageNo(pageNo)
//                        .pageSize(pageSize)
//                        .fetchAll(fetchAll)
//                        .build());
//        log.info("Returning all users of certificate course: {}", id);
//        return ResponseEntity.ok(queryAllCertificateCourseUsersResponse);
//    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Certificate course.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = DeleteCertificateCourseResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<DeleteCertificateCourseResponse> deleteCertificateCourse(@PathVariable UUID id) {
        DeleteCertificateCourseResponse deleteCertificateCourseResponse =
                certificateCourseApplicationService.deleteCertificateCourse(DeleteCertificateCourseCommand
                .builder()
                .certificateCourseId(id)
                .build());
        log.info("Certificate course deleted: {}", id);
        return ResponseEntity.ok(deleteCertificateCourseResponse);
    }
}
