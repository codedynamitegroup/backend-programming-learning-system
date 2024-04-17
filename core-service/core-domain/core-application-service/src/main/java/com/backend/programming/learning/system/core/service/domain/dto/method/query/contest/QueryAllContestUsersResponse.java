package com.backend.programming.learning.system.core.service.domain.dto.method.query.contest;

import com.backend.programming.learning.system.core.service.domain.dto.responseentity.certificatecourse.CertificateCourseUserResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.contest.ContestUserResponseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class QueryAllContestUsersResponse {
    @NotNull
    private final List<ContestUserResponseEntity> contestUsers;
    @NotNull
    private final int currentPage;
    @NotNull
    private final long totalItems;
    @NotNull
    private final int totalPages;
}
