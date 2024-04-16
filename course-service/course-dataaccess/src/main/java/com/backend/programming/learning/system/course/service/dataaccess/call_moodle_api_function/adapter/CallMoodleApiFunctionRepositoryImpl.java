package com.backend.programming.learning.system.course.service.dataaccess.call_moodle_api_function.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.call_moodle_api_function.mapper.CallMoodleApiFunctionDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.call_moodle_api_function.repository.CallMoodleApiFunctionJpaRepository;
import com.backend.programming.learning.system.entity.CallMoodleApiFunction;
import com.backend.programming.learning.system.ports.output.repository.CallMoodleApiFunctionRepository;
import org.springframework.stereotype.Repository;

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
}
