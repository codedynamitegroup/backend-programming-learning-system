package com.backend.programming.learning.system.core.service.domain.mapper.certificatecourse;

import com.backend.programming.learning.system.core.service.domain.dto.create.certificatecourse.CreateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.certificatecourse.CreateCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.certificatecourse.QueryCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.query.certificatecourse.QueryCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.entity.*;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.core.service.domain.valueobject.SkillLevel;
import com.backend.programming.learning.system.core.service.domain.valueobject.TopicId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class CertificateCourseDataMapper {
    public CertificateCourse createCertificateCourseCommandToCertificateCourse(
            CreateCertificateCourseCommand createCertificateCourseCommand) {
        return CertificateCourse.builder()
                .name(createCertificateCourseCommand.getName())
                .skillLevel(SkillLevel.valueOf(createCertificateCourseCommand.getSkillLevel()))
                .startTime(createCertificateCourseCommand.getStartTime())
                .endTime(createCertificateCourseCommand.getEndTime())
                .topic(Topic
                        .builder()
                        .id(new TopicId(createCertificateCourseCommand.getTopicId()))
                        .build())
                .chapters(new ArrayList<>())
                .reviews(new ArrayList<>())
                .registeredUsers(new ArrayList<>())
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
        return QueryCertificateCourseResponse.builder()
                .certificateCourse(certificateCourse)
                .message("Certificate course found successfully")
                .build();
    }
}
