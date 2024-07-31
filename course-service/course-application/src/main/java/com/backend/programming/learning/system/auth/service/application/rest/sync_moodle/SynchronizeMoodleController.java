package com.backend.programming.learning.system.auth.service.application.rest.sync_moodle;

import com.backend.programming.learning.system.course.service.domain.dto.method.query.synchronize_state.QuerySynchronizeStateCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.synchronize_state.QuerySynchronizeStateResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.organization.UpdateOrganizationResponse;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.synchronize_state.SynchronizeStateApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value ="/course/synchronize-moodle", produces = "application/vnd.api.v1+json")
public class SynchronizeMoodleController {

    private final SynchronizeStateApplicationService synchronizeStateApplicationService;

    @GetMapping("/{organizationId}")
    @Operation(summary = "Sync organization.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = UpdateOrganizationResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<String> syncDataMoodle(
            @PathVariable UUID organizationId,
            @RequestParam UUID userId
    ) {
        String response = synchronizeStateApplicationService.
                syncDataMoodle(organizationId,userId);
        return  ResponseEntity.ok(response);
    }

    @GetMapping("/state")
    @Operation(summary = "Query synchronize state.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QuerySynchronizeStateResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<QuerySynchronizeStateResponse> querySynchronizeByOrganizationIdAndStep(
            @RequestParam UUID organizationId,
            @RequestParam String step
    ) {
        QuerySynchronizeStateCommand querySynchronizeStateCommand = QuerySynchronizeStateCommand.builder()
                .organizationId(organizationId)
                .step(step)
                .build();
        QuerySynchronizeStateResponse response = synchronizeStateApplicationService.
                querySynchronizeByOrganizationIdAndStep(querySynchronizeStateCommand);
        return  ResponseEntity.ok(response);
    }

    @GetMapping("/all/{organizationId}")
    @Operation(summary = "Query all synchronize state.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QuerySynchronizeStateResponse[].class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<List<QuerySynchronizeStateResponse>> querySynchronizeByOrganizationId(
            @PathVariable UUID organizationId
    ) {
        List<QuerySynchronizeStateResponse> response = synchronizeStateApplicationService.
                querySynchronizeByOrganizationId(organizationId);
        return  ResponseEntity.ok(response);
    }


}
