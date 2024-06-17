package com.backend.programming.learning.system.core.service.domain.ports.input.service.contest;

import com.backend.programming.learning.system.core.service.domain.dto.method.query.certificatecourse.QueryAllCertificateCoursesResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.contest.QueryAllContestsResponse;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestStartTimeFilter;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.UUID;

public interface ContestRedisService {
    void clearAllContests(); // clear cache
    QueryAllContestsResponse getAllContests(
            ContestStartTimeFilter startTimeFilter,
            Integer pageNo,
            Integer pageSize,
            Boolean isAdmin,
            UUID orgId,
            Boolean isOrgAdmin);
    void saveAllContests(QueryAllContestsResponse queryAllContestsResponse,
                         ContestStartTimeFilter startTimeFilter,
                         Integer pageNo,
                         Integer pageSize,
                         Boolean isAdmin,
                         UUID orgId,
                         Boolean isOrgAdmin);
}
