package com.backend.programming.learning.system.course.service.dataaccess.synchronize_state.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.synchronize_state.mapper.SynchronizeStateDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.synchronize_state.repository.SynchronizeStateJpaRepostiory;
import com.backend.programming.learning.system.course.service.domain.entity.SynchronizeState;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.SynchronizeStateRepository;
import com.backend.programming.learning.system.domain.valueobject.SynchronizeStatus;
import com.backend.programming.learning.system.domain.valueobject.SynchronizeStep;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class SynchronizeStateRepositoryImpl implements SynchronizeStateRepository {
    private final SynchronizeStateJpaRepostiory synchronizeStateJpaRepostiory;
    private final SynchronizeStateDataAccessMapper synchronizeStateDataAccessMapper;
    @Override
    public SynchronizeState save(SynchronizeState synchronizeState) {
        return
                synchronizeStateDataAccessMapper
                        .synchronizeStateEntityToSynchronizeState(synchronizeStateJpaRepostiory
                                .save(synchronizeStateDataAccessMapper
                                        .synchronizeStateToSynchronizeStateEntity(synchronizeState)));

    }

    @Override
    public List<SynchronizeState> findAllByOrganizationId(UUID organizationId) {
        return
                synchronizeStateJpaRepostiory.findAllByOrganizationId(organizationId)
                        .stream()
                        .map(synchronizeStateDataAccessMapper::synchronizeStateEntityToSynchronizeState)
                        .toList();
    }

    @Override
    public SynchronizeState findByOrganizationIdAndSynchronizeStep(UUID organizationId, SynchronizeStep synchronizeStep) {
        return synchronizeStateDataAccessMapper
                .synchronizeStateEntityToSynchronizeState(synchronizeStateJpaRepostiory
                        .findByOrganizationIdAndStep(organizationId, synchronizeStep));
    }

    @Override
    public List<SynchronizeState> findByStatus(SynchronizeStatus status) {
        return
                synchronizeStateJpaRepostiory.findByStatus(status)
                        .stream()
                        .map(synchronizeStateDataAccessMapper::synchronizeStateEntityToSynchronizeState)
                        .toList();
    }

    @Override
    public SynchronizeState findSynchronizeStateByOrganizationIdAndStep(UUID organizationId, String step) {
        return synchronizeStateDataAccessMapper
                .synchronizeStateEntityToSynchronizeState(synchronizeStateJpaRepostiory
                        .findSynchronizeStateByOrganizationIdAndStep(organizationId, step));
    }
}
