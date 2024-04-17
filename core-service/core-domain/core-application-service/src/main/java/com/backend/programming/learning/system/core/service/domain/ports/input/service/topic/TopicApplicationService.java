package com.backend.programming.learning.system.core.service.domain.ports.input.service.topic;

import com.backend.programming.learning.system.core.service.domain.dto.create.review.CreateReviewCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.review.CreateReviewResponse;
import com.backend.programming.learning.system.core.service.domain.dto.create.topic.CreateTopicCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.topic.CreateTopicResponse;
import com.backend.programming.learning.system.core.service.domain.dto.delete.topic.DeleteTopicCommand;
import com.backend.programming.learning.system.core.service.domain.dto.delete.topic.DeleteTopicResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.contest.QueryAllContestsCommand;
import com.backend.programming.learning.system.core.service.domain.dto.query.contest.QueryAllContestsResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.topic.QueryAllTopicsCommand;
import com.backend.programming.learning.system.core.service.domain.dto.query.topic.QueryAllTopicsResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.topic.QueryTopicCommand;
import com.backend.programming.learning.system.core.service.domain.dto.query.topic.QueryTopicResponse;

import javax.validation.Valid;

public interface TopicApplicationService {
    CreateTopicResponse createTopic(
            @Valid CreateTopicCommand createTopicCommand);

    QueryAllTopicsResponse queryAllTopics(
            @Valid QueryAllTopicsCommand queryAllTopicsCommand);

    QueryTopicResponse queryTopic(
            @Valid QueryTopicCommand queryTopicCommand);

    DeleteTopicResponse deleteTopic(
            @Valid DeleteTopicCommand deleteTopicCommand);
}
