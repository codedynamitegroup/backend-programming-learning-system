package com.backend.programming.learning.system.auth.service.application.rest.rubric_user;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.rubric_user.CreateRubricUserCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.rubric_user.QueryAllRubricsByUserIdCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.rubric_user.QueryAllRubricsByUserIdResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.rubric_user.UpdateRubricUserCommand;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.rubric_user.RubricUserApplicationService;
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
@RequestMapping(value = "/course/rubric-user", produces = "application/vnd.api.v1+json")
public class RubricUserController {
    private final RubricUserApplicationService rubricUserApplicationService;

    @GetMapping("/users/{userId}")
    @Operation(summary = "Get all rubric users by userId.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = String.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<QueryAllRubricsByUserIdResponse> queryAllRubricsByUserId(
            @PathVariable UUID userId,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "") String searchName

    ) {
        QueryAllRubricsByUserIdResponse rubricsByUserIdResponse = rubricUserApplicationService.queryAllRubricsByUserId(
                QueryAllRubricsByUserIdCommand.builder()
                .userId(userId)
                .pageNo(pageNo)
                .pageSize(pageSize)
                .search(searchName)
                .build());
        return ResponseEntity.ok(rubricsByUserIdResponse);
    }

    @PostMapping
    @Operation(summary = "Create rubric user.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = String.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<String> createRubricUser(
            @RequestBody CreateRubricUserCommand createRubricUserCommand

    ) {
        rubricUserApplicationService.createRubricUser(createRubricUserCommand);
        return ResponseEntity.status(HttpStatus.CREATED).body("Create rubric user successfully.");
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update rubric user.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryAllRubricsByUserIdResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<String> updateRubricUser(
            @PathVariable String id,
            @RequestBody UpdateRubricUserCommand updateRubricUserCommand

    ) {
        rubricUserApplicationService.updateRubricUser(
                UpdateRubricUserCommand.builder()
                        .rubricUserId(id)
                        .rubricContent(updateRubricUserCommand.getRubricContent())
                        .rubricDescription(updateRubricUserCommand.getRubricDescription())
                        .rubricName(updateRubricUserCommand.getRubricName())
                        .build()
        );
        return ResponseEntity.status(HttpStatus.OK).body("Update rubric user successfully.");
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete rubric user.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryAllRubricsByUserIdResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<String> deleteRubricUser(
            @PathVariable UUID id
    ) {
        rubricUserApplicationService.deleteRubricUser(id);
        return ResponseEntity.status(HttpStatus.OK).body("Delete rubric user successfully.");
    }
}
