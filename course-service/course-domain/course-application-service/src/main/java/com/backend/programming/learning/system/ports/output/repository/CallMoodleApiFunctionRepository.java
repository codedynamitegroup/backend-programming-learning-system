package com.backend.programming.learning.system.ports.output.repository;

import com.backend.programming.learning.system.entity.CallMoodleApiFunction;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CallMoodleApiFunctionRepository {
    CallMoodleApiFunction saveCallMoodleApiFunction(CallMoodleApiFunction callMoodleApiFunction);

    Optional<CallMoodleApiFunction> findById(UUID callMoodleApiFunctionId);

    void deleteCallMoodleApiFunction(CallMoodleApiFunction callMoodleApiFunction);

    List<CallMoodleApiFunction> findAll();
}
