package com.backend.programming.learning.system.mapper.call_moodle_api_function;

import com.backend.programming.learning.system.dto.method.create.call_moodle_api_function.CreateCallMoodleApiFunctionCommand;
import com.backend.programming.learning.system.dto.method.create.call_moodle_api_function.CreateCallMoodleApiFunctionResponse;
import com.backend.programming.learning.system.dto.method.query.call_moodle_api_function.QueryAllCallMoodleApiFunctionResponse;
import com.backend.programming.learning.system.dto.responseentity.call_moodle_api_function.CallMoodleApiFunctionResponseEntity;
import com.backend.programming.learning.system.entity.CallMoodleApiFunction;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CallMoodleApiFunctionDataMapper {
    public CallMoodleApiFunction createCallMoodleApiFunctionCommandToCallMoodleApiFunction(CreateCallMoodleApiFunctionCommand createCallMoodleApiFunctionCommand) {
        return CallMoodleApiFunction.builder()
                .area(createCallMoodleApiFunctionCommand.getArea())
                .name(createCallMoodleApiFunctionCommand.getName())
                .description(createCallMoodleApiFunctionCommand.getDescription())
                .build();
    }


    public CreateCallMoodleApiFunctionResponse callMoodleApiFunctionToCreateCallMoodleApiFunctionResponse(CallMoodleApiFunction callMoodleApiFunction,String message) {
        return CreateCallMoodleApiFunctionResponse.builder()
                .callMoodleApiFunctionId(callMoodleApiFunction.getId().getValue())
                .message(message)
                .build();
    }
    public CallMoodleApiFunctionResponseEntity callMoodleApiFunctionToCallMoodleApiFunctionResponseEntity(CallMoodleApiFunction callMoodleApiFunction) {
        return CallMoodleApiFunctionResponseEntity.builder()
                .callMoodleApiFunctionId(callMoodleApiFunction.getId().getValue())
                .area(callMoodleApiFunction.getArea())
                .name(callMoodleApiFunction.getName())
                .description(callMoodleApiFunction.getDescription())
                .build();
    }

    public QueryAllCallMoodleApiFunctionResponse callMoodleApiFunctionListToQueryAllCallMoodleApiFunctionResponse(List<CallMoodleApiFunction> callMoodleApiFunctions) {
       return QueryAllCallMoodleApiFunctionResponse.builder()
               .callMoodleApiFunctionResponseEntities(callMoodleApiFunctions.stream().map(this::callMoodleApiFunctionToCallMoodleApiFunctionResponseEntity).toList())
               .build();
    }
}
