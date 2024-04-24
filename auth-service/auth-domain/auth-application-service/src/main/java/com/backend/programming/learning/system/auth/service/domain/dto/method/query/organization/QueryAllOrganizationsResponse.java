package com.backend.programming.learning.system.auth.service.domain.dto.method.query.organization;

import javax.validation.constraints.*;

import com.backend.programming.learning.system.auth.service.domain.dto.response_entity.organization.OrganizationEntityResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class QueryAllOrganizationsResponse {
    @NotNull
    private final List<OrganizationEntityResponse> organizations;
    @NotNull
    private final int currentPage;
    @NotNull
    private final long totalItems;
    @NotNull
    private final int totalPages;
}
