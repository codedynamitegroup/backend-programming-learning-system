package com.backend.programming.learning.system.course.service.domain.dto.method.query.rubric_user;

import com.backend.programming.learning.system.course.service.domain.dto.responseentity.rubric_user.RubricUserEntityResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.submission_assignment.SubmissionAssignmentResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.RubricUser;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class QueryAllRubricsByUserIdResponse {
    private final List<RubricUserEntityResponse> rubricUsers;
    @NotNull
    private final int currentPage;
    @NotNull
    private final long totalItems;
    @NotNull
    private final int totalPages;
}
