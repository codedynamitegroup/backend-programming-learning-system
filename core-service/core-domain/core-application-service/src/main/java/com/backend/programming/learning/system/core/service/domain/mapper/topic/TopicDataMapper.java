package com.backend.programming.learning.system.core.service.domain.mapper.topic;

import com.backend.programming.learning.system.core.service.domain.dto.create.review.CreateReviewCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.review.CreateReviewResponse;
import com.backend.programming.learning.system.core.service.domain.dto.create.topic.CreateTopicCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.topic.CreateTopicResponse;
import com.backend.programming.learning.system.core.service.domain.entity.Review;
import com.backend.programming.learning.system.core.service.domain.entity.Topic;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.exception.TopicNotFoundException;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

@Component
public class TopicDataMapper {
    private final UserRepository userRepository;

    public TopicDataMapper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Topic createTopicCommandToTopic(CreateTopicCommand createTopicCommand) {
        User createdBy = userRepository.findUser(new UserId(createTopicCommand.getCreatedBy()).getValue())
                .orElseThrow(() -> new TopicNotFoundException("User not found with id: " +
                        createTopicCommand.getCreatedBy()));
        User updatedBy = userRepository.findUser(new UserId(createTopicCommand.getUpdatedBy()).getValue())
                .orElseThrow(() -> new TopicNotFoundException("User not found with id: " +
                        createTopicCommand.getUpdatedBy()));
        return Topic.builder()
                .name(createTopicCommand.getName())
                .description(createTopicCommand.getDescription())
                .createdBy(createdBy)
                .updatedBy(updatedBy)
                .build();
    }

    public CreateTopicResponse topicToCreateTopicResponse(Topic topic, String message) {
        return CreateTopicResponse.builder()
                .topic(topic)
                .message(message)
                .build();
    }

}
