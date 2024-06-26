package com.backend.programming.learning.system.course.service.dataaccess.call_moodle_api_function.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.call_moodle_api_function.entity.CallMoodleApiFunctionEntity;
import com.backend.programming.learning.system.course.service.domain.entity.CallMoodleApiFunction;
import com.backend.programming.learning.system.course.service.domain.valueobject.CallMoodleApiFunctionId;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CallMoodleApiFunctionDataAccessMapper {
    public CallMoodleApiFunctionEntity callMoodleApiFunctionToCallMoodleApiFunctionEntity(CallMoodleApiFunction callMoodleApiFunction) {
        return CallMoodleApiFunctionEntity.builder()
                .id(callMoodleApiFunction.getId().getValue())
                .area(callMoodleApiFunction.getArea())
                .name(callMoodleApiFunction.getName())
                .description(callMoodleApiFunction.getDescription())
                .build();
    }

    public CallMoodleApiFunction callMoodleApiFunctionEntityToCallMoodleApiFunction(CallMoodleApiFunctionEntity callMoodleApiFunctionEntity) {
        return CallMoodleApiFunction.builder()
                .id(new CallMoodleApiFunctionId(callMoodleApiFunctionEntity.getId()))
                .area(callMoodleApiFunctionEntity.getArea())
                .name(callMoodleApiFunctionEntity.getName())
                .description(callMoodleApiFunctionEntity.getDescription())
                .build();
    }

    public List<CallMoodleApiFunction> callMoodleApiFunctionEntityListToCallMoodleApiFunctionList(List<CallMoodleApiFunctionEntity> all) {
        return all.stream().map(this::callMoodleApiFunctionEntityToCallMoodleApiFunction).toList();
    }
}
