package com.backend.programming.learning.system.implement.call_moodle_api_function;

import com.backend.programming.learning.system.entity.CallMoodleApiFunction;
import com.backend.programming.learning.system.ports.output.repository.CallMoodleApiFunctionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class CallMoodleApiFunctionQueryHelper {
    private final CallMoodleApiFunctionRepository callMoodleApiFunctionRepository;

    public CallMoodleApiFunctionQueryHelper(CallMoodleApiFunctionRepository callMoodleApiFunctionRepository) {
        this.callMoodleApiFunctionRepository = callMoodleApiFunctionRepository;
    }

    @Transactional(readOnly = true)
    List<CallMoodleApiFunction> queryAllCallMoodleApiFunctions() {
        return callMoodleApiFunctionRepository.findAll();
    }

    @Transactional(readOnly = true)
    CallMoodleApiFunction queryCallMoodleApiFunctionById(UUID callMoodleApiFunctionId) {
        Optional<CallMoodleApiFunction> callMoodleApiFunction = callMoodleApiFunctionRepository.findById(callMoodleApiFunctionId);
        if (callMoodleApiFunction.isEmpty()) {
            log.error("CallMoodleApiFunction not found with id: {}", callMoodleApiFunctionId);
            throw new RuntimeException("CallMoodleApiFunction not found with id: " + callMoodleApiFunctionId);
        }
        return callMoodleApiFunction.get();
    }
}
