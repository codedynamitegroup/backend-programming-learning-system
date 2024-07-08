package com.backend.programming.learning.system.core.service.domain.ports.output.redis;

import com.backend.programming.learning.system.core.service.domain.dto.method.query.contest.QueryAllContestsResponse;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestStartTimeFilter;

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
