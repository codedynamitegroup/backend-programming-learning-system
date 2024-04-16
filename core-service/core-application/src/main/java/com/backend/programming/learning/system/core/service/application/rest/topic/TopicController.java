package com.backend.programming.learning.system.core.service.application.rest.topic;

import com.backend.programming.learning.system.core.service.domain.dto.create.review.CreateReviewCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.review.CreateReviewResponse;
import com.backend.programming.learning.system.core.service.domain.dto.create.topic.CreateTopicCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.topic.CreateTopicResponse;
import com.backend.programming.learning.system.core.service.domain.dto.delete.contest.DeleteContestResponse;
import com.backend.programming.learning.system.core.service.domain.dto.delete.topic.DeleteTopicResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.contest.QueryAllContestsResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.contest.QueryContestResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.review.QueryAllTopicsResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.topic.QueryTopicResponse;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.review.ReviewApplicationService;
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
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<QueryTopicResponse> getTopic(@PathVariable UUID id) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteTopicResponse> deleteTopic(@PathVariable UUID id) {
        return null;
    }

}
