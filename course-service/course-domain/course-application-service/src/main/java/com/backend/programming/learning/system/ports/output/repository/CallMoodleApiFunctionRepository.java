package com.backend.programming.learning.system.ports.output.repository;

import com.backend.programming.learning.system.entity.CallMoodleApiFunction;

public interface CallMoodleApiFunctionRepository {
    CallMoodleApiFunction saveCallMoodleApiFunction(CallMoodleApiFunction callMoodleApiFunction);
}
