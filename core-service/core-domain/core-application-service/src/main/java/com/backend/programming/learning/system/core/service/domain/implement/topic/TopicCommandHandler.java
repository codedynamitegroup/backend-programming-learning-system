package com.backend.programming.learning.system.core.service.domain.implement.topic;

import com.backend.programming.learning.system.core.service.domain.dto.create.review.CreateReviewCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.review.CreateReviewResponse;
import com.backend.programming.learning.system.core.service.domain.dto.create.topic.CreateTopicCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.topic.CreateTopicResponse;
import com.backend.programming.learning.system.core.service.domain.entity.Review;
import com.backend.programming.learning.system.core.service.domain.entity.Topic;
import com.backend.programming.learning.system.core.service.domain.implement.review.ReviewCreateHelper;
import com.backend.programming.learning.system.core.service.domain.mapper.review.ReviewDataMapper;
import com.backend.programming.learning.system.core.service.domain.mapper.topic.TopicDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ReviewRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.TopicRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
public class TopicCommandHandler {
    private final TopicCreateHelper topicCreateHelper;
    private final TopicDataMapper topicDataMapper;
    private final TopicRepository topicRepository;

    public TopicCommandHandler(TopicCreateHelper topicCreateHelper,
                               TopicDataMapper topicDataMapper,
                               TopicRepository topicRepository) {
        this.topicCreateHelper = topicCreateHelper;
        this.topicDataMapper = topicDataMapper;
        this.topicRepository = topicRepository;
    }

    @Transactional
    public CreateTopicResponse createTopicResponse(
            CreateTopicCommand createTopicCommand) {
        Topic topic = topicCreateHelper.persistTopic(createTopicCommand);

        log.info("Topic created with id: {}", topic.getId().getValue());

        return topicDataMapper.topicToCreateTopicResponse(topic,
                "Topic created successfully");
    }

}
