package com.backend.programming.learning.system.core.service.domain.mapper.certificatecourse;

import com.backend.programming.learning.system.core.service.domain.dto.create.certificatecourse.CreateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.certificatecourse.CreateCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.certificatecourse.QueryAllCertificateCoursesResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.certificatecourse.QueryCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.chapter.QueryChapterResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.review.QueryReviewResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.topic.QueryTopicResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.user.QueryUserResponse;
import com.backend.programming.learning.system.core.service.domain.entity.*;
import com.backend.programming.learning.system.core.service.domain.mapper.chapter.ChapterDataMapper;
import com.backend.programming.learning.system.core.service.domain.mapper.review.ReviewDataMapper;
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

    public CertificateCourseDataMapper(TopicDataMapper topicDataMapper,
                                       UserDataMapper userDataMapper) {
        this.topicDataMapper = topicDataMapper;
        this.userDataMapper = userDataMapper;
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

    public QueryCertificateCourseResponse certificateCourseToQueryCertificateCourseResponse(
            CertificateCourse certificateCourse) {
        QueryTopicResponse queryTopicResponse = topicDataMapper.
                topicToQueryTopicResponse(certificateCourse.getTopic());
        QueryUserResponse createdByResponse = userDataMapper.userToQueryUserResponse(certificateCourse.getCreatedBy());
        QueryUserResponse updatedByResponse = userDataMapper.userToQueryUserResponse(certificateCourse.getUpdatedBy());

        return QueryCertificateCourseResponse.builder()
                .certificateCourseId(certificateCourse.getId().getValue())
                .name(certificateCourse.getName())
                .description(certificateCourse.getDescription())
                .skillLevel(certificateCourse.getSkillLevel().name())
                .avgRating(certificateCourse.getAvgRating())
                .startTime(certificateCourse.getStartTime())
                .endTime(certificateCourse.getEndTime())
                .topic(queryTopicResponse)
                .isDeleted(certificateCourse.getDeleted())
                .createdBy(createdByResponse)
                .updatedBy(updatedByResponse)
                .createdAt(certificateCourse.getCreatedAt())
                .updatedAt(certificateCourse.getUpdatedAt())
                .build();
    }

    public QueryAllCertificateCoursesResponse certificateCoursesToQueryAllCertificateCoursesResponse(
            Page<CertificateCourse> certificateCourses) {
        List<QueryCertificateCourseResponse> queryCertificateCourseResponses = new ArrayList<>();
        for (CertificateCourse certificateCourse : certificateCourses) {
            queryCertificateCourseResponses.add(certificateCourseToQueryCertificateCourseResponse(certificateCourse));
        }
        return QueryAllCertificateCoursesResponse.builder()
                .certificateCourses(queryCertificateCourseResponses)
                .currentPage(certificateCourses.getNumber())
                .totalPages(certificateCourses.getTotalPages())
                .totalItems(certificateCourses.getTotalElements())
                .build();
    }
}
