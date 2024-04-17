package com.backend.programming.learning.system.core.service.domain.mapper.certificatecourse;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.certificatecourse.CreateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.certificatecourse.CreateCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.certificatecourse.QueryAllCertificateCourseUsersResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.certificatecourse.QueryAllCertificateCoursesResponse;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.certificatecourse.CertificateCourseResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.certificatecourse.CertificateCourseUserResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.topic.TopicResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.user.UserResponseEntity;
import com.backend.programming.learning.system.core.service.domain.entity.*;
import com.backend.programming.learning.system.core.service.domain.mapper.certificatecourse_user.CertificateCourseUserDataMapper;
import com.backend.programming.learning.system.core.service.domain.mapper.topic.TopicDataMapper;
import com.backend.programming.learning.system.core.service.domain.mapper.user.UserDataMapper;
import com.backend.programming.learning.system.core.service.domain.valueobject.SkillLevel;
import com.backend.programming.learning.system.core.service.domain.valueobject.TopicId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CertificateCourseDataMapper {
    private final TopicDataMapper topicDataMapper;
    private final UserDataMapper userDataMapper;
    private final CertificateCourseUserDataMapper certificateCourseUserDataMapper;

    public CertificateCourseDataMapper(TopicDataMapper topicDataMapper,
                                       UserDataMapper userDataMapper,
                                       CertificateCourseUserDataMapper certificateCourseUserDataMapper) {
        this.topicDataMapper = topicDataMapper;
        this.userDataMapper = userDataMapper;
        this.certificateCourseUserDataMapper = certificateCourseUserDataMapper;
    }

    public CertificateCourse createCertificateCourseCommandToCertificateCourse(
            CreateCertificateCourseCommand createCertificateCourseCommand) {
        return CertificateCourse.builder()
                .name(createCertificateCourseCommand.getName())
                .skillLevel(SkillLevel.valueOf(createCertificateCourseCommand.getSkillLevel().toUpperCase()))
                .startTime(createCertificateCourseCommand.getStartTime())
                .endTime(createCertificateCourseCommand.getEndTime())
                .topic(Topic
                        .builder()
                        .id(new TopicId(createCertificateCourseCommand.getTopicId()))
                        .build())
                .isDeleted(false)
                .createdBy(User
                        .builder()
                        .id(new UserId(createCertificateCourseCommand.getCreatedBy()))
                        .build())
                .updatedBy(User
                        .builder()
                        .id(new UserId(createCertificateCourseCommand.getUpdatedBy()))
                        .build())
                .build();
    }

    public CreateCertificateCourseResponse certificateCourseToCreateCertificateCourseResponse(
            CertificateCourse certificateCourse, String message) {
        return CreateCertificateCourseResponse.builder()
                .certificateCourseId(certificateCourse.getId().getValue())
                .name(certificateCourse.getName())
                .message(message)
                .build();
    }

    public CertificateCourseResponseEntity certificateCourseToQueryCertificateCourseResponse(
            CertificateCourse certificateCourse) {
        TopicResponseEntity topicResponseEntity = topicDataMapper.
                topicToQueryTopicResponse(certificateCourse.getTopic());
        UserResponseEntity createdByResponse = userDataMapper.userToUserResponseEntity(certificateCourse.getCreatedBy());
        UserResponseEntity updatedByResponse = userDataMapper.userToUserResponseEntity(certificateCourse.getUpdatedBy());

        return CertificateCourseResponseEntity.builder()
                .certificateCourseId(certificateCourse.getId().getValue())
                .name(certificateCourse.getName())
                .description(certificateCourse.getDescription())
                .skillLevel(certificateCourse.getSkillLevel().name())
                .avgRating(certificateCourse.getAvgRating())
                .startTime(certificateCourse.getStartTime())
                .endTime(certificateCourse.getEndTime())
                .topic(topicResponseEntity)
                .isDeleted(certificateCourse.getDeleted())
                .createdBy(createdByResponse)
                .updatedBy(updatedByResponse)
                .createdAt(certificateCourse.getCreatedAt())
                .updatedAt(certificateCourse.getUpdatedAt())
                .build();
    }

    public QueryAllCertificateCoursesResponse certificateCoursesToQueryAllCertificateCoursesResponse(
            Page<CertificateCourse> certificateCourses) {
        List<CertificateCourseResponseEntity> certificateCourseResponsEntities = new ArrayList<>();
        for (CertificateCourse certificateCourse : certificateCourses) {
            certificateCourseResponsEntities.add(certificateCourseToQueryCertificateCourseResponse(certificateCourse));
        }
        return QueryAllCertificateCoursesResponse.builder()
                .certificateCourses(certificateCourseResponsEntities)
                .currentPage(certificateCourses.getNumber())
                .totalPages(certificateCourses.getTotalPages())
                .totalItems(certificateCourses.getTotalElements())
                .build();
    }

    public QueryAllCertificateCourseUsersResponse certificateCourseUsersToQueryAllCertificateCourseUsersResponse(
            Page<CertificateCourseUser> certificateCourseUsers) {
        List<CertificateCourseUserResponseEntity> certificateCourseUserResponseEntities = new ArrayList<>();
        for (CertificateCourseUser certificateCourseUser : certificateCourseUsers) {
            certificateCourseUserResponseEntities.add(certificateCourseUserDataMapper
                    .certificateCourseUserToCertificateCourseUserResponseEntity(certificateCourseUser));
        }
        return QueryAllCertificateCourseUsersResponse.builder()
                .certificateCourseUsers(certificateCourseUserResponseEntities)
                .currentPage(certificateCourseUsers.getNumber())
                .totalPages(certificateCourseUsers.getTotalPages())
                .totalItems(certificateCourseUsers.getTotalElements())
                .build();
    }
}
