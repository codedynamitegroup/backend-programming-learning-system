package com.backend.programming.learning.system.course.service.dataaccess.call_moodle_api_function.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.call_moodle_api_function.mapper.CallMoodleApiFunctionDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.call_moodle_api_function.repository.CallMoodleApiFunctionJpaRepository;
import com.backend.programming.learning.system.course.service.domain.entity.CallMoodleApiFunction;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CallMoodleApiFunctionRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CallMoodleApiFunctionRepositoryImpl implements CallMoodleApiFunctionRepository {

    private final CallMoodleApiFunctionJpaRepository callMoodleApiFunctionJpaRepository;
    private final CallMoodleApiFunctionDataAccessMapper callMoodleApiFunctionDataAccessMapper;

    public CallMoodleApiFunctionRepositoryImpl(CallMoodleApiFunctionJpaRepository callMoodleApiFunctionJpaRepository, CallMoodleApiFunctionDataAccessMapper callMoodleApiFunctionDataAccessMapper) {
        this.callMoodleApiFunctionJpaRepository = callMoodleApiFunctionJpaRepository;
        this.callMoodleApiFunctionDataAccessMapper = callMoodleApiFunctionDataAccessMapper;
    }


    @Override
    public CallMoodleApiFunction saveCallMoodleApiFunction(CallMoodleApiFunction callMoodleApiFunction) {
        return callMoodleApiFunctionDataAccessMapper.callMoodleApiFunctionEntityToCallMoodleApiFunction(callMoodleApiFunctionJpaRepository
                .save(callMoodleApiFunctionDataAccessMapper
                        .callMoodleApiFunctionToCallMoodleApiFunctionEntity(callMoodleApiFunction)));
    }

    @Override
    public Optional<CallMoodleApiFunction> findById(UUID callMoodleApiFunctionId) {
        return callMoodleApiFunctionJpaRepository.findById(callMoodleApiFunctionId)
                .map(callMoodleApiFunctionDataAccessMapper::callMoodleApiFunctionEntityToCallMoodleApiFunction);
    }

    @Override
    public void deleteCallMoodleApiFunction(CallMoodleApiFunction callMoodleApiFunction) {

    }

    @Override
    public List<CallMoodleApiFunction> findAll() {
        return callMoodleApiFunctionDataAccessMapper.callMoodleApiFunctionEntityListToCallMoodleApiFunctionList(callMoodleApiFunctionJpaRepository.findAll());
    }
}
