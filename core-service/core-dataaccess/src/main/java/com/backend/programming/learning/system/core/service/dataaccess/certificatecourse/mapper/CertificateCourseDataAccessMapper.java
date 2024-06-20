package com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.entity.CertificateCourseEntity;
import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.projection.MostEnrolledCertificateCourseProjection;
import com.backend.programming.learning.system.core.service.dataaccess.topic.entity.TopicEntity;
import com.backend.programming.learning.system.core.service.dataaccess.topic.mapper.TopicDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.certificatecourse.MostEnrolledWithStudentResponse;
import com.backend.programming.learning.system.core.service.domain.entity.*;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Component
public class CertificateCourseDataAccessMapper {
    private final UserDataAccessMapper userDataAccessMapper;
    private final TopicDataAccessMapper topicDataAccessMapper;

    public CertificateCourseDataAccessMapper(UserDataAccessMapper userDataAccessMapper,
                                             TopicDataAccessMapper topicDataAccessMapper) {
        this.userDataAccessMapper = userDataAccessMapper;
        this.topicDataAccessMapper = topicDataAccessMapper;
    }

    public CertificateCourseEntity certificateCourseToCertificateCourseEntity(CertificateCourse certificateCourse) {
        TopicEntity topic = topicDataAccessMapper.topicToTopicEntity(certificateCourse.getTopic());

        return CertificateCourseEntity.builder()
                .id(certificateCourse.getId().getValue())
                .name(certificateCourse.getName())
                .description(certificateCourse.getDescription())
                .skillLevel(certificateCourse.getSkillLevel())
                .avgRating(certificateCourse.getAvgRating())
                .topic(topic)
                .startTime(certificateCourse.getStartTime())
                .endTime(certificateCourse.getEndTime())
                .createdBy(userDataAccessMapper.userToUserEntityHideSensitiveData(certificateCourse.getCreatedBy()))
                .updatedBy(userDataAccessMapper.userToUserEntityHideSensitiveData(certificateCourse.getUpdatedBy()))
                .createdAt(certificateCourse.getCreatedAt())
                .updatedAt(certificateCourse.getUpdatedAt())
//                .numOfOneStarReviews(certificateCourse.getNumOfOneStarReviews())
//                .numOfTwoStarReviews(certificateCourse.getNumOfTwoStarReviews())
//                .numOfThreeStarReviews(certificateCourse.getNumOfThreeStarReviews())
//                .numOfFourStarReviews(certificateCourse.getNumOfFourStarReviews())
//                .numOfFiveStarReviews(certificateCourse.getNumOfFiveStarReviews())
                .build();
    }

    public CertificateCourse certificateCourseEntityToCertificateCourse(
            CertificateCourseEntity certificateCourseEntity) {
        Topic topic = topicDataAccessMapper.topicEntityToTopic(certificateCourseEntity.getTopic());

        return CertificateCourse.builder()
                .id(new CertificateCourseId(certificateCourseEntity.getId()))
                .name(certificateCourseEntity.getName())
                .description(certificateCourseEntity.getDescription())
                .skillLevel(certificateCourseEntity.getSkillLevel())
                .avgRating(certificateCourseEntity.getAvgRating())
                .topic(topic)
                .startTime(certificateCourseEntity.getStartTime())
                .endTime(certificateCourseEntity.getEndTime())
                .createdBy(userDataAccessMapper.userEntityToUserHideSensitiveData(certificateCourseEntity.getCreatedBy()))
                .updatedBy(userDataAccessMapper.userEntityToUserHideSensitiveData(certificateCourseEntity.getUpdatedBy()))
                .createdAt(certificateCourseEntity.getCreatedAt())
                .updatedAt(certificateCourseEntity.getUpdatedAt())
//                .numOfOneStarReviews(certificateCourseEntity.getNumOfOneStarReviews())
//                .numOfTwoStarReviews(certificateCourseEntity.getNumOfTwoStarReviews())
//                .numOfThreeStarReviews(certificateCourseEntity.getNumOfThreeStarReviews())
//                .numOfFourStarReviews(certificateCourseEntity.getNumOfFourStarReviews())
//                .numOfFiveStarReviews(certificateCourseEntity.getNumOfFiveStarReviews())
                .build();
    }

    public List<String> splitWords(String search) {
        if(search == null) return null;

        ArrayList<String> words = Stream.of(search.split(" ")).filter(i-> !i.isEmpty()).collect(Collectors.toCollection(ArrayList::new));

        return words;
    }

    public MostEnrolledWithStudentResponse MostEnrolledCertificateCourseProjectionToMostEnrolledWithStudentResponse(
            MostEnrolledCertificateCourseProjection mostEnrolledCertificateCourseProjection) {

        return MostEnrolledWithStudentResponse.builder()
                .certificateCourseId(mostEnrolledCertificateCourseProjection.getCertificateCourseId())
                .certificateCourseName(mostEnrolledCertificateCourseProjection.getCertificateCourseName())
                .numOfStudents(mostEnrolledCertificateCourseProjection.getNumOfStudents())
                .build();
    }
}
