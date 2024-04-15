package com.backend.programming.learning.system.course.service.dataaccess.call_moodle_api_function.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.call_moodle_api_function.entity.CallMoodleApiFunctionEntity;
import com.backend.programming.learning.system.entity.CallMoodleApiFunction;
import com.backend.programming.learning.system.valueobject.CallMoodleApiFunctionId;
import org.springframework.stereotype.Component;

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
}
