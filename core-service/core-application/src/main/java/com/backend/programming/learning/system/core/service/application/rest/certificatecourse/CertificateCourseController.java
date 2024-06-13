package com.backend.programming.learning.system.core.service.application.rest.certificatecourse;

import com.backend.programming.learning.system.core.service.application.utils.JwtUtils;
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
import com.backend.programming.learning.system.core.service.domain.ports.input.service.certificatecourse.CertificateCourseRedisService;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.certificatecourse_user.CertificateCourseUserApplicationService;
import com.backend.programming.learning.system.core.service.domain.valueobject.IsRegisteredFilter;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.security.core.Authentication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(value = "/core/certificate-courses", produces = "application/vnd.api.v1+json")
public class CertificateCourseController {
    private final CertificateCourseApplicationService certificateCourseApplicationService;
    private final CertificateCourseUserApplicationService certificateCourseUserApplicationService;
    private final CertificateCourseRedisService certificateCourseRedisService;

    public CertificateCourseController(CertificateCourseApplicationService certificateCourseApplicationService,
                                       CertificateCourseUserApplicationService certificateCourseUserApplicationService,
                                       CertificateCourseRedisService certificateCourseRedisService) {
        this.certificateCourseApplicationService = certificateCourseApplicationService;
        this.certificateCourseUserApplicationService = certificateCourseUserApplicationService;
        this.certificateCourseRedisService = certificateCourseRedisService;
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

        String email = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof JwtAuthenticationToken jwtAuthenticationToken) {
            Jwt token = jwtAuthenticationToken.getToken();
            email = token.getClaim("preferred_username");
        }

        CreateCertificateCourseResponse createCertificateCourseResponse =
                certificateCourseApplicationService.createCertificateCourse(
                        CreateCertificateCourseCommand.builder()
                                .name(createCertificateCourseCommand.getName())
                                .description(createCertificateCourseCommand.getDescription())
                                .skillLevel(createCertificateCourseCommand.getSkillLevel())
                                .topicId(createCertificateCourseCommand.getTopicId())
                                .startTime(createCertificateCourseCommand.getStartTime())
                                .endTime(createCertificateCourseCommand.getEndTime())
                                .email(email)
                                .build()
                );
        log.info("Certificate course created: {}", createCertificateCourseResponse);

        return ResponseEntity.status(HttpStatus.CREATED).body(createCertificateCourseResponse);
    }

    @PostMapping("/{id}/register")
    @Operation(summary = "Register Certificate course User.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = CreateCertificateCourseUserResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<CreateCertificateCourseUserResponse> registerCertificateCourse(
            @PathVariable UUID id) {
        log.info("Creating Certificate course User for course: {}", id);

        String email = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof JwtAuthenticationToken jwtAuthenticationToken) {
            Jwt token = jwtAuthenticationToken.getToken();
            email = token.getClaim("preferred_username");
        }

        CreateCertificateCourseUserResponse createCertificateCourseUserResponse =
                certificateCourseUserApplicationService.createCertificateCourseUser(
                        CreateCertificateCourseUserCommand
                        .builder()
                        .certificateCourseId(id)
                        .email(email)
                        .build()
                );
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
    public ResponseEntity<CertificateCourseResponseEntity> getCertificateCourseById(
            @RequestHeader(value = "Access-Token", required = false) String accessToken,
            @PathVariable UUID id) {
        String email = JwtUtils.getEmailFromJwtString(accessToken);

        CertificateCourseResponseEntity certificateCourseResponseEntity =
                certificateCourseApplicationService.queryCertificateCourse(QueryCertificateCourseCommand
                        .builder()
                        .certificateCourseId(id)
                        .email(email)
                        .build());
        log.info("Returning certificate course: {}", certificateCourseResponseEntity.getCertificateCourseId());
        return  ResponseEntity.ok(certificateCourseResponseEntity);
    }

    @PostMapping
    @Operation(summary = "Get all certificate courses.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryAllCertificateCoursesResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<QueryAllCertificateCoursesResponse> getAllCertificateCourses(
            @RequestBody QueryAllCertificateCoursesCommand queryAllCertificateCoursesCommand
    ) {
        log.info("Getting all certificate courses by searchName: {} and filterTopicId: {}",
                queryAllCertificateCoursesCommand.getCourseName(),
                queryAllCertificateCoursesCommand.getFilterTopicId());
        if (queryAllCertificateCoursesCommand.getCourseName() == null ||
                        queryAllCertificateCoursesCommand.getCourseName().isEmpty()
                            || queryAllCertificateCoursesCommand.getCourseName().isBlank()) {
            QueryAllCertificateCoursesResponse redisResponse = certificateCourseRedisService.getAllCertificateCourses(
                    queryAllCertificateCoursesCommand.getCourseName(),
                    queryAllCertificateCoursesCommand.getFilterTopicId()
            );
            if (redisResponse != null) {
                log.info("Returning all certificate courses from cache");
                return ResponseEntity.ok(redisResponse);
            }
        }
        QueryAllCertificateCoursesResponse queryAllCertificateCoursesResponse =
                certificateCourseApplicationService.queryAllCertificateCourses(QueryAllCertificateCoursesCommand
                        .builder()
                        .courseName(queryAllCertificateCoursesCommand.getCourseName())
                        .filterTopicId(queryAllCertificateCoursesCommand.getFilterTopicId())
                        .isRegisteredFilter(IsRegisteredFilter.ALL.toString())
                        .email(null)
                        .build());
        if (queryAllCertificateCoursesCommand.getCourseName() == null ||
                queryAllCertificateCoursesCommand.getCourseName().isEmpty()) {
            certificateCourseRedisService.saveAllCertificateCourses(
                    queryAllCertificateCoursesResponse,
                    queryAllCertificateCoursesCommand.getCourseName(),
                    queryAllCertificateCoursesCommand.getFilterTopicId()
            );
        }
        log.info("Returning all certificate courses");
        return ResponseEntity.ok(queryAllCertificateCoursesResponse);
    }

    @PostMapping("/me")
    @Operation(summary = "Get all my registered Certificate courses.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryAllCertificateCoursesResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<QueryAllCertificateCoursesResponse> getAllMyCertificateCourses(
            @RequestBody QueryAllCertificateCoursesCommand queryAllCertificateCoursesCommand
    ) {
        String email = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof JwtAuthenticationToken jwtAuthenticationToken) {
            Jwt token = jwtAuthenticationToken.getToken();
            email = token.getClaim("preferred_username");
        }

        QueryAllCertificateCoursesResponse queryAllCertificateCoursesResponse =
                certificateCourseApplicationService.queryAllMyCertificateCourses(QueryAllCertificateCoursesCommand
                        .builder()
                        .courseName(queryAllCertificateCoursesCommand.getCourseName())
                        .filterTopicId(queryAllCertificateCoursesCommand.getFilterTopicId())
                        .isRegisteredFilter(IsRegisteredFilter.REGISTERED.toString())
                        .email(email)
                        .build());
        log.info("Returning all my registered certificate courses");
        return ResponseEntity.ok(queryAllCertificateCoursesResponse);
    }

    @PostMapping("/most-enrolled")
    @Operation(summary = "Get All Most Enrolled Certificate courses.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryAllMostEnrolledCertificateCoursesResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<QueryAllMostEnrolledCertificateCoursesResponse> getAllMostEnrolledCertificateCourses(
            @RequestHeader(value = "Access-Token", required = false) String accessToken) {
        String email = JwtUtils.getEmailFromJwtString(accessToken);

        QueryAllMostEnrolledCertificateCoursesResponse queryAllMostEnrolledCertificateCoursesResponse =
                certificateCourseApplicationService.queryAllMostEnrolledCertificateCourses(
                        QueryAllMostEnrolledCertificateCoursesCommand
                        .builder()
                        .email(email)
                        .build()
                );
        log.info("Returning all Most Enrolled certificate courses");
        return ResponseEntity.ok(queryAllMostEnrolledCertificateCoursesResponse);
    }

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

    @GetMapping("/certificate/dashboard-statistics")
    @Operation(summary = "Get statistics of contests for certificate dashboard.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryGeneralCertificateCourseStatisticsResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<QueryGeneralCertificateCourseStatisticsResponse> getCertificateDashboardStatistics() {
        QueryGeneralCertificateCourseStatisticsResponse queryGeneralCertificateCourseStatisticsResponse =
                certificateCourseApplicationService.queryGeneralCertificateCourseStatistics();

        log.info("Returning certificate dashboard statistics");
        return ResponseEntity.ok(queryGeneralCertificateCourseStatisticsResponse);
    }
}
