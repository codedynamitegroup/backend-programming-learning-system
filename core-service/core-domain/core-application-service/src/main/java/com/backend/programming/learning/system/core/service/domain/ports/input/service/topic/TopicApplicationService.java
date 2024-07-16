package com.backend.programming.learning.system.core.service.domain.ports.input.service.topic;

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

import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

public interface TopicApplicationService {
    CreateTopicResponse createTopic(
            @Valid CreateTopicCommand createTopicCommand);

    QueryAllTopicsResponse queryAllTopics(
            @Valid QueryAllTopicsCommand queryAllTopicsCommand);

    TopicResponseEntity queryTopic(
            @Valid QueryTopicCommand queryTopicCommand);

    DeleteTopicResponse deleteTopic(
            @Valid DeleteTopicCommand deleteTopicCommand);

    UpdateTopicResponse updateTopic(
            @Valid UpdateTopicCommand updateTopicCommand);

    QueryAllProgrammingLanguageResponse queryAllProgrammingLanguages(String search, Integer pageNo, Integer pageSize, List<UUID> selectedProgrammingLanguages);

    QueryAllProgrammingLanguageResponse queryAllProgrammingLanguagesById(String search, Integer pageNo, Integer pageSize, List<UUID> selectedProgrammingLanguageIds);
}
