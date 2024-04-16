package com.backend.programming.learning.system.core.service.domain.dto.query.certificatecourse;

import com.backend.programming.learning.system.core.service.domain.dto.query.chapter.QueryChapterResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.review.QueryReviewResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.topic.QueryTopicResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.user.QueryUserResponse;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QueryCertificateCourseResponse {
    @NotNull
    private final UUID certificateCourseId;
    @NotNull
    private final String name;
    @NotNull
    private final String description;
    @NotNull
    private final String skillLevel;
    @NotNull
    private final Float avgRating;
    @NotNull
    private final ZonedDateTime startTime;
    @NotNull
    private final ZonedDateTime endTime;
    @NotNull
    private final QueryTopicResponse topic;
    @NotNull
    private final Boolean isDeleted;
    @NotNull
    private final QueryUserResponse createdBy;
    @NotNull
    private final QueryUserResponse updatedBy;
    @NotNull
    private final ZonedDateTime createdAt;
    @NotNull
    private final ZonedDateTime updatedAt;
}
