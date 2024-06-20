package com.backend.programming.learning.system.course.service.domain.dto.responseentity.assignment;

import com.backend.programming.learning.system.course.service.domain.dto.responseentity.intro_attachment.IntroAttachmentResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.user.UserSubmissionAssignmentResponseEntity;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class ListSubmissionAssignmentResponseEntity {
    @NotNull
    private final UUID id;
    @NotNull
    private final String title;

    private final String courseName;

    private final List<UserSubmissionAssignmentResponseEntity> users;


}
