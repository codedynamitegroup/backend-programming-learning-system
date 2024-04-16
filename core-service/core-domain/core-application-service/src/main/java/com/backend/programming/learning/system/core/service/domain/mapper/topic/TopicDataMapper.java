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

    public Topic createTopicCommandToTopic(CreateTopicCommand createTopicCommand) {
        return Topic.builder()
                .name(createTopicCommand.getName())
                .description(createTopicCommand.getDescription())
                .createdBy(User
                        .builder()
                        .id(new UserId(createTopicCommand.getCreatedBy()))
                        .build())
                .updatedBy(User
                        .builder()
                        .id(new UserId(createTopicCommand.getUpdatedBy()))
                        .build())
                .build();
    }

    public CreateTopicResponse topicToCreateTopicResponse(Topic topic, String message) {
        return CreateTopicResponse.builder()
                .topic(topic)
                .message(message)
                .build();
    }

}
