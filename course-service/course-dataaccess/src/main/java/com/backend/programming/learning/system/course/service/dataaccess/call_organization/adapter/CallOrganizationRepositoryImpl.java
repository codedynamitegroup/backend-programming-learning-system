package com.backend.programming.learning.system.course.service.dataaccess.call_organization.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.call_organization.mapper.CallOrganizationDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.call_organization.repository.CallOrganizationJpaRepository;
import com.backend.programming.learning.system.course.service.domain.entity.CallOrganization;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CallOrganizationRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CallOrganizationRepositoryImpl implements CallOrganizationRepository {
    private final CallOrganizationJpaRepository callOrganizationJpaRepository;
    private final CallOrganizationDataAccessMapper callOrganizationDataAccessMapper;

    public CallOrganizationRepositoryImpl(CallOrganizationJpaRepository callOrganizationJpaRepository, CallOrganizationDataAccessMapper callOrganizationDataAccessMapper) {
        this.callOrganizationJpaRepository = callOrganizationJpaRepository;
        this.callOrganizationDataAccessMapper = callOrganizationDataAccessMapper;
    }
    @Override
    public CallOrganization saveCallOrganization(CallOrganization callOrganization) {
        return callOrganizationDataAccessMapper
                .callOrganizationEntityToCallOrganization(callOrganizationJpaRepository
                        .save(callOrganizationDataAccessMapper
                                .callOrganizationToCallOrganizationEntity(callOrganization)));
    }
}
