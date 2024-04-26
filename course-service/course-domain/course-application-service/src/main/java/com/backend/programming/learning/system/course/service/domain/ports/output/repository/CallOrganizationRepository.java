package com.backend.programming.learning.system.course.service.domain.ports.output.repository;

import com.backend.programming.learning.system.course.service.domain.entity.CallOrganization;

public interface CallOrganizationRepository {
    CallOrganization saveCallOrganization(CallOrganization callOrganization);
}
