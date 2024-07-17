package com.backend.programming.learning.system.core.service.application.rest.topic;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.topic.CreateTopicCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.topic.CreateTopicResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.topic.DeleteTopicCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.topic.DeleteTopicResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.topic.*;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.topic.UpdateTopicCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.topic.UpdateTopicResponse;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.topic.TopicResponseEntity;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.topic.TopicApplicationService;
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
@RequestMapping(value = "/core/topics", produces = "application/vnd.api.v1+json")
public class TopicController {
    private final TopicApplicationService topicApplicationService;

    public TopicController(TopicApplicationService topicApplicationService) {
        this.topicApplicationService = topicApplicationService;
    }

    @PostMapping("/create")
    @Operation(summary = "Create topic.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = CreateTopicResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<CreateTopicResponse> createTopic(
            @RequestBody CreateTopicCommand createTopicCommand) {
        log.info("Creating topic: {}", createTopicCommand);
        CreateTopicResponse createTopicResponse =
                topicApplicationService.createTopic(createTopicCommand);
        log.info("Topic created: {}", createTopicResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(createTopicResponse);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update topic.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = UpdateTopicResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<UpdateTopicResponse> updateTopic(
            @PathVariable UUID id,
            @RequestBody UpdateTopicCommand updateTopicCommand) {
        log.info("Updating topic: {}", id);
        UpdateTopicResponse updateTopicResponse =
                topicApplicationService.updateTopic(UpdateTopicCommand
                        .builder()
                        .topicId(id)
                        .thumbnailUrl(updateTopicCommand.getThumbnailUrl())
                        .isSingleProgrammingLanguage(updateTopicCommand.getIsSingleProgrammingLanguage())
                        .name(updateTopicCommand.getName())
                        .description(updateTopicCommand.getDescription())
                        .programmingLanguageIds(updateTopicCommand.getProgrammingLanguageIds())
                        .updatedBy(updateTopicCommand.getUpdatedBy())
                        .build());
        log.info("Topic updated: {}", updateTopicResponse.getTopicId());
        return ResponseEntity.ok(updateTopicResponse);
    }

    @GetMapping
    @Operation(summary = "Get all topics.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryAllTopicsResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<QueryAllTopicsResponse> getAllTopics(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "false") Boolean fetchAll
    ) {
        QueryAllTopicsResponse queryAllTopicsResponse =
                topicApplicationService.queryAllTopics(QueryAllTopicsCommand
                        .builder()
                        .pageNo(pageNo)
                        .pageSize(pageSize)
                        .fetchAll(fetchAll)
                        .build());
        log.info("Returning all topics: {}", queryAllTopicsResponse.getTopics());
        return ResponseEntity.ok(queryAllTopicsResponse);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get topic by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = TopicResponseEntity.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<TopicResponseEntity> getTopic(@PathVariable UUID id) {
        TopicResponseEntity topicResponseEntity =
                topicApplicationService.queryTopic(QueryTopicCommand
                        .builder()
                        .topicId(id)
                        .build());
        log.info("Returning topic: {}", topicResponseEntity.getTopicId());
        return  ResponseEntity.ok(topicResponseEntity);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete topic.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = DeleteTopicResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<DeleteTopicResponse> deleteTopic(@PathVariable UUID id) {
        DeleteTopicResponse deleteTopicResponse =
                topicApplicationService.deleteTopic(DeleteTopicCommand
                        .builder()
                        .topicId(id)
                        .build());
        log.info("Topic deleted: {}", id);
        return ResponseEntity.ok(deleteTopicResponse);
    }

    @PostMapping("/language")
    @Operation(summary = "Get programming languages.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryAllProgrammingLanguageResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<QueryAllProgrammingLanguageResponse> getProgrammingLanguages(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "") String search,
            @RequestBody QueryAllProgrammingLanguageCommand selectedProgrammingLanguageIds
    ) {
        log.info("Getting all programming languages with search: {}, page: {}, page size: {} except for languages with these ids: {}", search, pageNo, pageSize, selectedProgrammingLanguageIds);

        QueryAllProgrammingLanguageResponse queryAllProgrammingLanguageResponse =
                topicApplicationService.queryAllProgrammingLanguages(
                        search, pageNo, pageSize, selectedProgrammingLanguageIds.selectedProgrammingLanguageIds()
                );

        log.info("Returning all programming languages: {}", queryAllProgrammingLanguageResponse.programmingLanguages());
        return ResponseEntity.ok(queryAllProgrammingLanguageResponse);
    }

    @PostMapping("/language/get-by-id")
    @Operation(summary = "Get programming languages.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryAllProgrammingLanguageResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<QueryAllProgrammingLanguageResponse> getProgrammingLanguagesById(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "") String search,
            @RequestBody QueryAllProgrammingLanguageCommand selectedProgrammingLanguageIds
    ) {
        log.info("Getting all programming languages with search: {}, page: {}, page size: {} except for languages with these ids: {}", search, pageNo, pageSize, selectedProgrammingLanguageIds);

        QueryAllProgrammingLanguageResponse queryAllProgrammingLanguageResponse =
                topicApplicationService.queryAllProgrammingLanguagesById(
                        search, pageNo, pageSize, selectedProgrammingLanguageIds.selectedProgrammingLanguageIds()
                );

        log.info("Returning all programming languages: {}", queryAllProgrammingLanguageResponse.programmingLanguages());
        return ResponseEntity.ok(queryAllProgrammingLanguageResponse);
    }
}
