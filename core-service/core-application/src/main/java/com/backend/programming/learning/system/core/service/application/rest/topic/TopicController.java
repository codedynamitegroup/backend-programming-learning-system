package com.backend.programming.learning.system.core.service.application.rest.topic;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.topic.CreateTopicCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.topic.CreateTopicResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.topic.DeleteTopicCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.topic.DeleteTopicResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.topic.QueryAllTopicsCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.topic.QueryAllTopicsResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.topic.QueryTopicCommand;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.topic.TopicResponseEntity;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.topic.TopicApplicationService;
import lombok.extern.slf4j.Slf4j;
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
    public ResponseEntity<CreateTopicResponse> createTopic(
            @RequestBody CreateTopicCommand createTopicCommand) {
        log.info("Creating topic: {}", createTopicCommand);
        CreateTopicResponse createTopicResponse =
                topicApplicationService.createTopic(createTopicCommand);
        log.info("Topic created: {}", createTopicResponse);

        return ResponseEntity.ok(createTopicResponse);
    }

    @GetMapping
    public ResponseEntity<QueryAllTopicsResponse> getAllTopics(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam Boolean fetchAll
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
    public ResponseEntity<DeleteTopicResponse> deleteTopic(@PathVariable UUID id) {
        DeleteTopicResponse deleteTopicResponse =
                topicApplicationService.deleteTopic(DeleteTopicCommand
                        .builder()
                        .topicId(id)
                        .build());
        log.info("Topic deleted: {}", id);
        return ResponseEntity.ok(deleteTopicResponse);
    }
}
