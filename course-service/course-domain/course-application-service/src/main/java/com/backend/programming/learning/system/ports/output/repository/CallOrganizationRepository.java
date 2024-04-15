package com.backend.programming.learning.system.ports.output.repository;

import com.backend.programming.learning.system.entity.CallOrganization;

public interface CallOrganizationRepository {
    CallOrganization saveCallOrganization(CallOrganization callOrganization);
}
