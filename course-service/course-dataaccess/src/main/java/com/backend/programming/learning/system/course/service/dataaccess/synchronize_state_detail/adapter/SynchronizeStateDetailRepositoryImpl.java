package com.backend.programming.learning.system.course.service.dataaccess.synchronize_state_detail.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.synchronize_state_detail.entity.SynchronizeStateDetailEntity;
import com.backend.programming.learning.system.course.service.dataaccess.synchronize_state_detail.mapper.SynchronizeStateDetailDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.synchronize_state_detail.repository.SynchronizeStateDetailJpaRepostiory;
import com.backend.programming.learning.system.course.service.domain.entity.SynchronizeState;
import com.backend.programming.learning.system.course.service.domain.entity.SynchronizeStateDetail;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.SynchronizeStateDetailRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.SynchronizeStateRepository;
import com.backend.programming.learning.system.domain.valueobject.SynchronizeStatus;
import com.backend.programming.learning.system.domain.valueobject.SynchronizeStep;
import com.backend.programming.learning.system.domain.valueobject.TypeSynchronizeStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class SynchronizeStateDetailRepositoryImpl implements SynchronizeStateDetailRepository {
    private final SynchronizeStateDetailJpaRepostiory synchronizeStateDetailJpaRepostiory;
    private final SynchronizeStateDetailDataAccessMapper synchronizeStateDetailDataAccessMapper;


    @Override
    public SynchronizeStateDetail save(SynchronizeStateDetail synchronizeStateDetail) {
        SynchronizeStateDetailEntity synchronizeStateDetailEntity = synchronizeStateDetailDataAccessMapper.synchronizeStateDetailToSynchronizeStateDetailEntity(synchronizeStateDetail);
        SynchronizeStateDetailEntity savedSynchronizeStateDetailEntity = synchronizeStateDetailJpaRepostiory.save(synchronizeStateDetailEntity);
        return synchronizeStateDetailDataAccessMapper.synchronizeStateDetailEntityToSynchronizeStateDetail(savedSynchronizeStateDetailEntity);
    }

    @Override
    public List<SynchronizeStateDetail> findSynchronizeStateDetailByOrganizationIdAndStatus(UUID organizationId, TypeSynchronizeStatus status) {
        return synchronizeStateDetailDataAccessMapper.synchronizeStateDetailEntityToSynchronizeStateDetail(
                        synchronizeStateDetailJpaRepostiory.findSynchronizeStateDetailByOrganizationIdAndStatus(organizationId, status)
                );
    }


    @Override
    public List<SynchronizeStateDetail> findSynchronizeStateDetailByStatus(TypeSynchronizeStatus status){
        return
            synchronizeStateDetailDataAccessMapper.synchronizeStateDetailEntityToSynchronizeStateDetail(
                synchronizeStateDetailJpaRepostiory.findSynchronizeStateDetailByStatus(status)
            );
    }

    @Override
    public void delete(SynchronizeStateDetail synchronizeStateDetail) {
        synchronizeStateDetailJpaRepostiory.delete(synchronizeStateDetailDataAccessMapper.synchronizeStateDetailToSynchronizeStateDetailEntity(synchronizeStateDetail));
    }

}
