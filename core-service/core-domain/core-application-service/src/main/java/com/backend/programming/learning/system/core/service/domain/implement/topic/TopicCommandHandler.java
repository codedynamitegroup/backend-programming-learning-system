package com.backend.programming.learning.system.core.service.domain.implement.topic;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.topic.CreateTopicCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.topic.CreateTopicResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.topic.DeleteTopicCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.topic.DeleteTopicResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.topic.QueryAllTopicsCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.topic.QueryAllTopicsResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.topic.QueryTopicCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.topic.QueryTopicResponse;
import com.backend.programming.learning.system.core.service.domain.entity.Topic;
import com.backend.programming.learning.system.core.service.domain.mapper.topic.TopicDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
public class TopicCommandHandler {
    private final TopicCreateHelper topicCreateHelper;
    private final TopicQueryHelper topicQueryHelper;
    private final TopicDeleteHelper topicDeleteHelper;
    private final TopicDataMapper topicDataMapper;

    public TopicCommandHandler(TopicCreateHelper topicCreateHelper,
                               TopicQueryHelper topicQueryHelper,
                               TopicDeleteHelper topicDeleteHelper,
                               TopicDataMapper topicDataMapper) {
        this.topicCreateHelper = topicCreateHelper;
        this.topicQueryHelper = topicQueryHelper;
        this.topicDeleteHelper = topicDeleteHelper;
        this.topicDataMapper = topicDataMapper;
    }

    @Transactional(readOnly = true)
    public QueryTopicResponse queryTopicResponse(
            QueryTopicCommand queryTopicCommand) {
        Topic topic = topicQueryHelper.queryTopicById(queryTopicCommand.getTopicId());

        log.info("Topic found with id: {}", topic.getId().getValue());

        return topicDataMapper.topicToQueryTopicResponse(topic);
    }

    @Transactional
    public CreateTopicResponse createTopicResponse(
            CreateTopicCommand createTopicCommand) {
        Topic topic = topicCreateHelper.persistTopic(createTopicCommand);

        log.info("Topic created with id: {}", topic.getId().getValue());

        return topicDataMapper.topicToCreateTopicResponse(topic,
                "Topic created successfully");
    }

    @Transactional(readOnly = true)
    public QueryAllTopicsResponse queryAllTopicsResponse(
            QueryAllTopicsCommand queryAllTopicsCommand) {
        Page<Topic> topics = topicQueryHelper
                .queryAllTopics(
                        queryAllTopicsCommand.getPageNo(),
                        queryAllTopicsCommand.getPageSize(),
                        queryAllTopicsCommand.getFetchAll());

        return topicDataMapper.topicsToQueryAllTopicsResponse(topics);
    }

    @Transactional
    public DeleteTopicResponse deleteTopicResponse(
            DeleteTopicCommand deleteTopicCommand) {
        topicDeleteHelper.deleteTopicById(
                deleteTopicCommand.getTopicId());

        return DeleteTopicResponse.builder()
                .topicId(deleteTopicCommand.getTopicId())
                .message("Topic deleted successfully")
                .build();
    }

}
