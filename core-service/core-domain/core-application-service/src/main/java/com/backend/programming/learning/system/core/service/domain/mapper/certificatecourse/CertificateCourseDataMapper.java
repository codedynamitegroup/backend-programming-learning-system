package com.backend.programming.learning.system.core.service.domain.mapper.certificatecourse;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.certificatecourse.CreateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.certificatecourse.CreateCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.certificatecourse.QueryAllCertificateCourseWithPageResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.certificatecourse.QueryAllCertificateCoursesResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.certificatecourse.QueryAllMostEnrolledCertificateCoursesResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.certificatecourse.QueryAllMyCompletedCertificateCoursesResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.certificatecourse.UpdateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.certificatecourse.UpdateCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.certificatecourse.CertificateCourseResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.chapter.ChapterResourceResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.question.QuestionResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.topic.TopicResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.user.UserResponseEntity;
import com.backend.programming.learning.system.core.service.domain.entity.*;
import com.backend.programming.learning.system.core.service.domain.mapper.chapter_resource.ChapterResourceDataMapper;
import com.backend.programming.learning.system.core.service.domain.mapper.question.QuestionDataMapper;
import com.backend.programming.learning.system.core.service.domain.mapper.topic.TopicDataMapper;
import com.backend.programming.learning.system.core.service.domain.mapper.user.UserDataMapper;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.core.service.domain.valueobject.SkillLevel;
import com.backend.programming.learning.system.core.service.domain.valueobject.TopicId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class CertificateCourseDataMapper {
    private final TopicDataMapper topicDataMapper;
    private final UserDataMapper userDataMapper;
    private final ChapterResourceDataMapper chapterResourceDataMapper;

    public CertificateCourseDataMapper(TopicDataMapper topicDataMapper,
                                       UserDataMapper userDataMapper,
                                       ChapterResourceDataMapper chapterResourceDataMapper) {
        this.topicDataMapper = topicDataMapper;
        this.userDataMapper = userDataMapper;
        this.chapterResourceDataMapper = chapterResourceDataMapper;
    }

    public List<CertificateCourse> queryAllCertificateCoursesResponseToCertificateCourses(
            QueryAllCertificateCoursesResponse queryAllCertificateCoursesResponse) {
        List<CertificateCourse> certificateCourses = new ArrayList<>();
        for (CertificateCourseResponseEntity certificateCourseResponseEntity : queryAllCertificateCoursesResponse.getCertificateCourses()) {
            certificateCourses.add(certificateCourseResponseEntityToCertificateCourse(certificateCourseResponseEntity));
        }

        return certificateCourses;
    }

    public CertificateCourse certificateCourseResponseEntityToCertificateCourse(
            CertificateCourseResponseEntity certificateCourseResponseEntity) {
        return CertificateCourse.builder()
                .id(new CertificateCourseId(certificateCourseResponseEntity.getCertificateCourseId()))
                .name(certificateCourseResponseEntity.getName())
                .description(certificateCourseResponseEntity.getDescription())
                .skillLevel(SkillLevel.valueOf(certificateCourseResponseEntity.getSkillLevel().toUpperCase()))
                .avgRating(certificateCourseResponseEntity.getAvgRating())
                .startTime(certificateCourseResponseEntity.getStartTime())
                .endTime(certificateCourseResponseEntity.getEndTime())
                .topic(topicDataMapper.queryTopicResponseToTopic(certificateCourseResponseEntity.getTopic()))
                .numOfStudents(certificateCourseResponseEntity.getNumOfStudents())
                .numOfResources(certificateCourseResponseEntity.getNumOfResources())
                .numOfCompletedResources(certificateCourseResponseEntity.getNumOfCompletedResources())
                .numOfReviews(certificateCourseResponseEntity.getNumOfReviews())
                .isRegistered(certificateCourseResponseEntity.getIsRegistered())
                .createdBy(userDataMapper.userResponseEntityToUser(certificateCourseResponseEntity.getCreatedBy()))
                .updatedBy(userDataMapper.userResponseEntityToUser(certificateCourseResponseEntity.getUpdatedBy()))
                .createdAt(certificateCourseResponseEntity.getCreatedAt())
                .updatedAt(certificateCourseResponseEntity.getUpdatedAt())
                .numOfOneStarReviews(certificateCourseResponseEntity.getNumOfOneStarReviews())
                .numOfTwoStarReviews(certificateCourseResponseEntity.getNumOfTwoStarReviews())
                .numOfThreeStarReviews(certificateCourseResponseEntity.getNumOfThreeStarReviews())
                .numOfFourStarReviews(certificateCourseResponseEntity.getNumOfFourStarReviews())
                .numOfFiveStarReviews(certificateCourseResponseEntity.getNumOfFiveStarReviews())
                .build();
    }

    public CertificateCourse createCertificateCourseCommandToCertificateCourse(
            CreateCertificateCourseCommand createCertificateCourseCommand) {
        return CertificateCourse.builder()
                .name(createCertificateCourseCommand.getName())
                .description(createCertificateCourseCommand.getDescription())
                .skillLevel(SkillLevel.valueOf(createCertificateCourseCommand.getSkillLevel().toUpperCase()))
                .startTime(createCertificateCourseCommand.getStartTime())
                .endTime(createCertificateCourseCommand.getEndTime())
                .topic(Topic
                        .builder()
                        .id(new TopicId(createCertificateCourseCommand.getTopicId()))
                        .build())
                .createdAt(ZonedDateTime.now(ZoneId.of("UTC")))
                .updatedAt(ZonedDateTime.now(ZoneId.of("UTC")))
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
        ChapterResourceResponseEntity chapterResourceResponseEntity = certificateCourse.getCurrentResource() == null
                ? null
                : chapterResourceDataMapper.chapterResourceToChapterResourceResponse(certificateCourse.getCurrentResource());

        return CertificateCourseResponseEntity.builder()
                .certificateCourseId(certificateCourse.getId().getValue())
                .name(certificateCourse.getName())
                .description(certificateCourse.getDescription())
                .skillLevel(certificateCourse.getSkillLevel().name())
                .avgRating(certificateCourse.getAvgRating())
                .startTime(certificateCourse.getStartTime())
                .endTime(certificateCourse.getEndTime())
                .topic(topicResponseEntity)
                .numOfStudents(certificateCourse.getNumOfStudents())
                .numOfResources(certificateCourse.getNumOfResources())
                .numOfCompletedResources(certificateCourse.getNumOfCompletedResources())
                .currentResource(chapterResourceResponseEntity)
                .numOfReviews(certificateCourse.getNumOfReviews())
                .isRegistered(certificateCourse.getRegistered())
                .createdBy(createdByResponse)
                .updatedBy(updatedByResponse)
                .createdAt(certificateCourse.getCreatedAt())
                .updatedAt(certificateCourse.getUpdatedAt())
                .numOfOneStarReviews(certificateCourse.getNumOfOneStarReviews())
                .numOfTwoStarReviews(certificateCourse.getNumOfTwoStarReviews())
                .numOfThreeStarReviews(certificateCourse.getNumOfThreeStarReviews())
                .numOfFourStarReviews(certificateCourse.getNumOfFourStarReviews())
                .numOfFiveStarReviews(certificateCourse.getNumOfFiveStarReviews())
                .build();
    }

    public QueryAllCertificateCoursesResponse certificateCoursesToQueryAllCertificateCoursesResponse(
            List<CertificateCourse> certificateCourses) {
        List<CertificateCourseResponseEntity> certificateCourseResponseEntities = new ArrayList<>();
        for (CertificateCourse certificateCourse : certificateCourses) {
            certificateCourseResponseEntities.add(certificateCourseToQueryCertificateCourseResponse(certificateCourse));
        }

        return QueryAllCertificateCoursesResponse.builder()
                .certificateCourses(certificateCourseResponseEntities)
                .build();
    }

    public QueryAllMostEnrolledCertificateCoursesResponse certificateCoursesToQueryAllMostEnrolledCertificateCoursesResponse(
            List<CertificateCourse> certificateCourses) {
        List<CertificateCourseResponseEntity> certificateCourseResponseEntities = new ArrayList<>();
        for (CertificateCourse certificateCourse : certificateCourses) {
            certificateCourseResponseEntities.add(certificateCourseToQueryCertificateCourseResponse(certificateCourse));
        }

        return QueryAllMostEnrolledCertificateCoursesResponse.builder()
                .mostEnrolledCertificateCourses(certificateCourseResponseEntities)
                .build();
    }

    public UpdateCertificateCourseResponse certificateCourseToUpdateCertificateCourseResponse(
            CertificateCourseId certificateCourseId, String message) {
        return UpdateCertificateCourseResponse.builder()
                .certificateCourseId(certificateCourseId.getValue())
                .message(message)
                .build();
    }

//    public CertificateCourse updateCertificateCourseCommandToCertificateCourse(
//            UpdateCertificateCourseCommand updateCertificateCourseCommand) {
//        return CertificateCourse.builder()
//                .id(new CertificateCourseId(updateCertificateCourseCommand.getCertificateCourseId()))
//                .name(updateCertificateCourseCommand.getName())
//                .description(updateCertificateCourseCommand.getDescription())
//                .skillLevel(SkillLevel.valueOf(updateCertificateCourseCommand.getSkillLevel().toUpperCase()))
//                .startTime(updateCertificateCourseCommand.getStartTime())
//                .endTime(updateCertificateCourseCommand.getEndTime())
//                .updatedBy(User
//                        .builder()
//                        .id(new UserId(updateCertificateCourseCommand.getUpdatedBy()))
//                        .build())
//                .updatedAt(ZonedDateTime.now(ZoneId.of("UTC")))
//                .build();
//    }

    public QueryAllCertificateCourseWithPageResponse certificateCoursesPageToQueryAllCertificateCourseWithPageResponse(
            Page<CertificateCourse> certificateCourses) {
        List<CertificateCourseResponseEntity> certificateCourseResponseEntities = certificateCourses
                .map(this::certificateCourseToQueryCertificateCourseResponse).getContent();

        return QueryAllCertificateCourseWithPageResponse.builder()
                .certificateCourses(certificateCourseResponseEntities)
                .currentPage(certificateCourses.getNumber())
                .totalItems(certificateCourses.getTotalElements())
                .totalPages(certificateCourses.getTotalPages())
                .build();
    }

    public QueryAllMyCompletedCertificateCoursesResponse certificateCoursesToQueryAllMyCompletedCertificateCoursesResponse(
            Page<CertificateCourse> certificateCourses) {
        List<CertificateCourseResponseEntity> certificateCourseResponseEntities = certificateCourses
                .map(this::certificateCourseToQueryCertificateCourseResponse).getContent();

        return QueryAllMyCompletedCertificateCoursesResponse.builder()
                .certificateCourses(certificateCourseResponseEntities)
                .currentPage(certificateCourses.getNumber())
                .totalItems(certificateCourses.getTotalElements())
                .totalPages(certificateCourses.getTotalPages())
                .build();
    }
}
