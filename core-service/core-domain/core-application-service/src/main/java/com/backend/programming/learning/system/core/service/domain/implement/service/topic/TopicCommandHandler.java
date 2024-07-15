package com.backend.programming.learning.system.core.service.domain.implement.service.topic;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.topic.CreateTopicCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.topic.CreateTopicResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.topic.DeleteTopicCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.topic.DeleteTopicResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.topic.QueryAllProgrammingLanguageResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.topic.QueryAllTopicsCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.topic.QueryAllTopicsResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.topic.QueryTopicCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.topic.UpdateTopicCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.topic.UpdateTopicResponse;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.topic.TopicResponseEntity;
import com.backend.programming.learning.system.core.service.domain.entity.ProgrammingLanguage;
import com.backend.programming.learning.system.core.service.domain.entity.Topic;
import com.backend.programming.learning.system.core.service.domain.mapper.topic.TopicDataMapper;
import com.backend.programming.learning.system.core.service.domain.valueobject.TopicId;
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
    private final TopicUpdateHelper topicUpdateHelper;
    private final TopicDataMapper topicDataMapper;

    public TopicCommandHandler(TopicCreateHelper topicCreateHelper,
                               TopicQueryHelper topicQueryHelper,
                               TopicDeleteHelper topicDeleteHelper,
                                 TopicUpdateHelper topicUpdateHelper,
                               TopicDataMapper topicDataMapper) {
        this.topicCreateHelper = topicCreateHelper;
        this.topicQueryHelper = topicQueryHelper;
        this.topicDeleteHelper = topicDeleteHelper;
        this.topicUpdateHelper = topicUpdateHelper;
        this.topicDataMapper = topicDataMapper;
    }

    @Transactional(readOnly = true)
    public TopicResponseEntity queryTopicResponse(
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

    @Transactional
    public UpdateTopicResponse updateTopicResponse(
            UpdateTopicCommand updateTopicCommand) {
        topicUpdateHelper.persistTopic(updateTopicCommand);

        log.info("Topic updated with id: {}", updateTopicCommand.getTopicId());

        return topicDataMapper.topicToUpdateTopicResponse(
                new TopicId(updateTopicCommand.getTopicId()),
                "Topic updated successfully");
    }

    @Transactional(readOnly = true)
    public QueryAllProgrammingLanguageResponse queryAllProgrammingLanguage(String search, Integer pageNo, Integer pageSize) {
        Page<ProgrammingLanguage> programmingLanguages = topicQueryHelper.queryAllProgrammingLanguage(search, pageNo, pageSize);

        return topicDataMapper.programmingLanguagePageToQueryAllProgrammingLanguageResponse(programmingLanguages);
    }
}
