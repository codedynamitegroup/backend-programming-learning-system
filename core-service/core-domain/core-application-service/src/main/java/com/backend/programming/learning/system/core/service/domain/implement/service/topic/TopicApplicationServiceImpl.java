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
import com.backend.programming.learning.system.core.service.domain.ports.input.service.topic.TopicApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

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
    public TopicResponseEntity queryTopic(QueryTopicCommand queryTopicCommand) {
        return topicCommandHandler.queryTopicResponse(queryTopicCommand);
    }

    @Override
    public DeleteTopicResponse deleteTopic(DeleteTopicCommand deleteTopicCommand) {
        return topicCommandHandler.deleteTopicResponse(deleteTopicCommand);
    }

    @Override
    public UpdateTopicResponse updateTopic(UpdateTopicCommand updateTopicCommand) {
        return topicCommandHandler.updateTopicResponse(updateTopicCommand);
    }

    @Override
    public QueryAllProgrammingLanguageResponse queryAllProgrammingLanguages(String search, Integer pageNo, Integer pageSize, List<UUID> selectedProgrammingLanguages) {
        return topicCommandHandler.queryAllProgrammingLanguage(search, pageNo, pageSize, selectedProgrammingLanguages);
    }

    @Override
    public QueryAllProgrammingLanguageResponse queryAllProgrammingLanguagesById(
            String search,
            Integer pageNo,
            Integer pageSize,
            List<UUID> selectedProgrammingLanguageIds) {
        return topicCommandHandler.queryAllProgrammingLanguageById(search, pageNo, pageSize, selectedProgrammingLanguageIds);
    }
}
