package com.backend.programming.learning.system.core.service.domain.ports.input.service.topic;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.topic.CreateTopicCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.topic.CreateTopicResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.topic.DeleteTopicCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.topic.DeleteTopicResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.topic.QueryAllTopicsCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.topic.QueryAllTopicsResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.topic.QueryTopicCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.topic.QueryTopicResponse;

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
