package com.backend.programming.learning.system.course.service.domain.dto.method.query.assignment;

import com.backend.programming.learning.system.course.service.domain.dto.responseentity.intro_attachment.IntroAttachmentResponseEntity;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QueryAssignmentAIGradeResponse {

    @NotNull
    private UUID id;

    private String intro;

    @NotNull
    private Float maxScore;
}
