package com.backend.programming.learning.system.core.service.domain.mapper.topic;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.topic.CreateTopicCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.topic.CreateTopicResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.topic.UpdateTopicResponse;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.programminglanguage.ProgrammingLanguageResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.topic.QueryAllTopicsResponse;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.topic.TopicResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.user.UserResponseEntity;
import com.backend.programming.learning.system.core.service.domain.entity.ProgrammingLanguage;
import com.backend.programming.learning.system.core.service.domain.entity.Topic;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.mapper.programminglanguage.ProgrammingLanguageDataMapper;
import com.backend.programming.learning.system.core.service.domain.mapper.user.UserDataMapper;
import com.backend.programming.learning.system.core.service.domain.valueobject.TopicId;
import com.backend.programming.learning.system.domain.valueobject.ProgrammingLanguageId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class TopicDataMapper {
    private final ProgrammingLanguageDataMapper programmingLanguageDataMapper;
    private final UserDataMapper userDataMapper;

    public TopicDataMapper(ProgrammingLanguageDataMapper programmingLanguageDataMapper,
                           UserDataMapper userDataMapper) {
        this.programmingLanguageDataMapper = programmingLanguageDataMapper;
        this.userDataMapper = userDataMapper;
    }

    public Topic createTopicCommandToTopic(CreateTopicCommand createTopicCommand) {
        List<ProgrammingLanguage> programmingLanguages = new ArrayList<>();

        for (UUID programmingLanguageId : createTopicCommand.getProgrammingLanguageIds()) {
            programmingLanguages.add(ProgrammingLanguage
                    .builder()
                    .id(new ProgrammingLanguageId(programmingLanguageId))
                    .build());
        }

        return Topic.builder()
                .name(createTopicCommand.getName())
                .description(createTopicCommand.getDescription())
                .programmingLanguages(programmingLanguages)
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
                .topicId(topic.getId().getValue())
                .message(message)
                .build();
    }

    public TopicResponseEntity topicToQueryTopicResponse(Topic topic) {
        List<ProgrammingLanguageResponseEntity> programmingLanguages = programmingLanguageDataMapper
                .programmingLanguagesToQueryProgrammingLanguageResponses(topic.getProgrammingLanguages());
        UserResponseEntity createdByResponse = userDataMapper.userToUserResponseEntity(topic.getCreatedBy());
        UserResponseEntity updatedByResponse = userDataMapper.userToUserResponseEntity(topic.getUpdatedBy());

        return TopicResponseEntity.builder()
                .topicId(topic.getId().getValue())
                .name(topic.getName())
                .description(topic.getDescription())
                .programmingLanguages(programmingLanguages)
                .createdBy(createdByResponse)
                .updatedBy(updatedByResponse)
                .createdAt(topic.getCreatedAt())
                .updatedAt(topic.getUpdatedAt())
                .build();
    }

    public QueryAllTopicsResponse topicsToQueryAllTopicsResponse(Page<Topic> topics) {
        return QueryAllTopicsResponse.builder()
                .topics(topics.getContent().stream()
                        .map(this::topicToQueryTopicResponse)
                        .collect(Collectors.toList()))
                .currentPage(topics.getNumber())
                .totalPages(topics.getTotalPages())
                .totalItems(topics.getTotalElements())
                .build();
    }

    public UpdateTopicResponse topicToUpdateTopicResponse(TopicId topicId, String message) {
        return UpdateTopicResponse.builder()
                .topicId(topicId.getValue())
                .message("Topic updated successfully")
                .build();
    }

}
