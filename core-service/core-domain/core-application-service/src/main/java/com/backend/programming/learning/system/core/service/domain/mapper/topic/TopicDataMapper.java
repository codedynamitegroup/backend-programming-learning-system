package com.backend.programming.learning.system.core.service.domain.mapper.topic;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.topic.CreateTopicCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.topic.CreateTopicResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.topic.QueryAllProgrammingLanguageResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.topic.UpdateTopicResponse;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.programminglanguage.ProgrammingLanguageIdResponseEntity;
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
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TopicDataMapper {
    private final UserDataMapper userDataMapper;
    private final ProgrammingLanguageDataMapper programmingLanguageDataMapper;

    public TopicDataMapper(UserDataMapper userDataMapper,
                           ProgrammingLanguageDataMapper programmingLanguageDataMapper) {
        this.userDataMapper = userDataMapper;
        this.programmingLanguageDataMapper = programmingLanguageDataMapper;
    }

    public Topic createTopicCommandToTopic(CreateTopicCommand createTopicCommand) {
        return Topic.builder()
                .name(createTopicCommand.getName())
                .description(createTopicCommand.getDescription())
                .thumbnailUrl(createTopicCommand.getThumbnailUrl())
                .isSingleProgrammingLanguage(createTopicCommand.getIsSingleProgrammingLanguage())
                .numOfCertificateCourses(null)
                .createdBy(User
                        .builder()
                        .id(new UserId(createTopicCommand.getCreatedBy()))
                        .build())
                .updatedBy(User
                        .builder()
                        .id(new UserId(createTopicCommand.getUpdatedBy()))
                        .build())
                .createdAt(ZonedDateTime.now(ZoneId.of("UTC")))
                .updatedAt(ZonedDateTime.now(ZoneId.of("UTC")))
                .build();
    }

    public CreateTopicResponse topicToCreateTopicResponse(Topic topic, String message) {
        return CreateTopicResponse.builder()
                .topicId(topic.getId().getValue())
                .message(message)
                .build();
    }

    public TopicResponseEntity topicToQueryTopicResponse(Topic topic) {
        UserResponseEntity createdByResponse = userDataMapper.userToUserResponseEntity(topic.getCreatedBy());
        UserResponseEntity updatedByResponse = userDataMapper.userToUserResponseEntity(topic.getUpdatedBy());
        List<ProgrammingLanguageResponseEntity> programmingLanguages = new ArrayList<>();
        if (topic.getProgrammingLanguages() != null) {
            for (ProgrammingLanguage programmingLanguage : topic.getProgrammingLanguages()) {
                programmingLanguages.add(programmingLanguageDataMapper
                        .programmingLanguageToQueryProgrammingLanguageResponse(programmingLanguage));
            }
        }

        return TopicResponseEntity.builder()
                .topicId(topic.getId().getValue())
                .name(topic.getName())
                .description(topic.getDescription())
                .thumbnailUrl(topic.getThumbnailUrl())
                .isSingleProgrammingLanguage(topic.getSingleProgrammingLanguage())
                .programmingLanguages(programmingLanguages)
                .numOfCertificateCourses(topic.getNumOfCertificateCourses())
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

    public Topic queryTopicResponseToTopic(TopicResponseEntity topicResponseEntity) {
        return Topic.builder()
                .id(new TopicId(topicResponseEntity.getTopicId()))
                .name(topicResponseEntity.getName())
                .description(topicResponseEntity.getDescription())
                .thumbnailUrl(topicResponseEntity.getThumbnailUrl())
                .isSingleProgrammingLanguage(topicResponseEntity.getIsSingleProgrammingLanguage())
                .numOfCertificateCourses(topicResponseEntity.getNumOfCertificateCourses())
                .createdBy(userDataMapper.userResponseEntityToUser(topicResponseEntity.getCreatedBy()))
                .updatedBy(userDataMapper.userResponseEntityToUser(topicResponseEntity.getUpdatedBy()))
                .createdAt(topicResponseEntity.getCreatedAt())
                .updatedAt(topicResponseEntity.getUpdatedAt())
                .build();
    }

    private ProgrammingLanguageIdResponseEntity programmingLanguageToQueryProgrammingLanguageIdResponseEntity(ProgrammingLanguage programmingLanguage) {
        return ProgrammingLanguageIdResponseEntity.builder()
                .id(programmingLanguage.getId().getValue())
                .name(programmingLanguage.getName())
                .compilerApiId(programmingLanguage.getCompilerApiId())
                .timeLimit(programmingLanguage.getTimeLimit())
                .memoryLimit(programmingLanguage.getMemoryLimit())
                .build();
    }

    private List<ProgrammingLanguageIdResponseEntity> programmingLanguageListToQueryProgrammingLanguageIdListResponseEntity(List<ProgrammingLanguage> programmingLanguages) {
        return programmingLanguages.stream()
                .map(this::programmingLanguageToQueryProgrammingLanguageIdResponseEntity)
                .collect(Collectors.toList());
    }

    public QueryAllProgrammingLanguageResponse programmingLanguagePageToQueryAllProgrammingLanguageResponse(Page<ProgrammingLanguage> programmingLanguages) {
        return QueryAllProgrammingLanguageResponse.builder()
                .programmingLanguages(programmingLanguageListToQueryProgrammingLanguageIdListResponseEntity(programmingLanguages.getContent()))
                .currentPage(programmingLanguages.getNumber())
                .totalItems(programmingLanguages.getTotalElements())
                .totalPages(programmingLanguages.getTotalPages())
                .build();
    }
}
