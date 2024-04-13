package com.backend.programming.learning.system.core.service.domain.ports.input.service.topic;

import com.backend.programming.learning.system.core.service.domain.dto.create.review.CreateReviewCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.review.CreateReviewResponse;
import com.backend.programming.learning.system.core.service.domain.dto.create.topic.CreateTopicCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.topic.CreateTopicResponse;

import javax.validation.Valid;

public interface TopicApplicationService {
    CreateTopicResponse createTopic(
            @Valid CreateTopicCommand createTopicCommand);
}
