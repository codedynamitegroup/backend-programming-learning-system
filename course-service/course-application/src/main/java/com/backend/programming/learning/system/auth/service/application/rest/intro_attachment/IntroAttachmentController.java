package com.backend.programming.learning.system.auth.service.application.rest.intro_attachment;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.assignment.CreateAssignmentCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.assignment.CreateAssignmentResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.intro_attachment.CreateIntroAttachmentCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.intro_attachment.CreateIntroAttachmentResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.intro_attachment.UpdateIntroAttachmentCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.intro_attachment.UpdateIntroAttachmentResponse;
import com.backend.programming.learning.system.course.service.domain.entity.IntroAttachment;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.intro_attachment.IntroAttachmentApplicationService;
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
@RequestMapping(value = "/course/assignment/intro-attachment", produces = "application/vnd.api.v1+json")
public class IntroAttachmentController {
    private final IntroAttachmentApplicationService introAttachmentApplicationService;

    @PostMapping
    @Operation(summary = "Create intro-attachment.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = CreateIntroAttachmentResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<CreateIntroAttachmentResponse> createAssignment(
            @RequestBody CreateIntroAttachmentCommand createIntroAttachmentCommand
    ) {
        log.info("Creating assignment");
        CreateIntroAttachmentResponse response = introAttachmentApplicationService.createIntroAttachment(createIntroAttachmentCommand);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update intro-attachment.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = UpdateIntroAttachmentResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<UpdateIntroAttachmentResponse> updateAssignment(
            @RequestBody UpdateIntroAttachmentCommand createIntroAttachmentCommand,
            @PathVariable("id") UUID id
    ) {
        log.info("Updating assignment");
        UpdateIntroAttachmentResponse response = introAttachmentApplicationService.updateIntroAttachment(createIntroAttachmentCommand, id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
