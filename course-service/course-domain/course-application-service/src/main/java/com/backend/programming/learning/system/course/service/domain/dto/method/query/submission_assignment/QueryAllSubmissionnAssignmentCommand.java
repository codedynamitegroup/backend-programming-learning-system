package com.backend.programming.learning.system.course.service.domain.dto.method.query.submission_assignment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QueryAllSubmissionnAssignmentCommand {
    @NotNull
    private final UUID assignmentId;

    @NotNull
    private final int pageNo;

    @NotNull
    private final int pageSize;


    private final String searchName;

    private final Boolean isGraded;
}
