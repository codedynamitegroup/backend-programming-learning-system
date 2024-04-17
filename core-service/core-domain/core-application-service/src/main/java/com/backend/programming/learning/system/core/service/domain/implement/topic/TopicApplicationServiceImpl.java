package com.backend.programming.learning.system.core.service.domain.implement.topic;

import com.backend.programming.learning.system.core.service.domain.dto.create.review.CreateReviewCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.review.CreateReviewResponse;
import com.backend.programming.learning.system.core.service.domain.dto.create.topic.CreateTopicCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.topic.CreateTopicResponse;
import com.backend.programming.learning.system.core.service.domain.dto.delete.topic.DeleteTopicCommand;
import com.backend.programming.learning.system.core.service.domain.dto.delete.topic.DeleteTopicResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.topic.QueryAllTopicsCommand;
import com.backend.programming.learning.system.core.service.domain.dto.query.topic.QueryAllTopicsResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.topic.QueryTopicCommand;
import com.backend.programming.learning.system.core.service.domain.dto.query.topic.QueryTopicResponse;
import com.backend.programming.learning.system.core.service.domain.entity.Topic;
import com.backend.programming.learning.system.core.service.domain.implement.review.ReviewCommandHandler;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.review.ReviewApplicationService;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.topic.TopicApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Service
@Validated
@Slf4j
class TopicApplicationServiceImpl implements TopicApplicationService {
    private final TopicCommandHandler topicCommandHandler;

    public TopicApplicationServiceImpl(TopicCommandHandler topicCommandHandler) {
        this.topicCommandHandler = topicCommandHandler;
    }

    @Override
    public CreateTopicResponse createTopic(@Valid CreateTopicCommand createTopicCommand) {
        return topicCommandHandler.createTopicResponse(createTopicCommand);
    }

    @Override
    public QueryAllTopicsResponse queryAllTopics(QueryAllTopicsCommand queryAllTopicsCommand) {
        return topicCommandHandler.queryAllTopicsResponse(queryAllTopicsCommand);
    }

    @Override
    public QueryTopicResponse queryTopic(QueryTopicCommand queryTopicCommand) {
        return topicCommandHandler.queryTopicResponse(queryTopicCommand);
    }

    @Override
    public DeleteTopicResponse deleteTopic(DeleteTopicCommand deleteTopicCommand) {
        return topicCommandHandler.deleteTopicResponse(deleteTopicCommand);
    }
}
