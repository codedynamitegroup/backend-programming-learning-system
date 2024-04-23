package com.backend.programming.learning.system.implement.call_moodle_api_function;

import com.backend.programming.learning.system.CourseDomainService;
import com.backend.programming.learning.system.dto.method.create.call_moodle_api_function.CreateCallMoodleApiFunctionCommand;
import com.backend.programming.learning.system.entity.CallMoodleApiFunction;
import com.backend.programming.learning.system.mapper.assignment.AssignmentDataMapper;
import com.backend.programming.learning.system.mapper.call_moodle_api_function.CallMoodleApiFunctionDataMapper;
import com.backend.programming.learning.system.ports.output.repository.AssignmentRepository;
import com.backend.programming.learning.system.ports.output.repository.CallMoodleApiFunctionRepository;
import com.backend.programming.learning.system.ports.output.repository.CourseRepository;
import com.backend.programming.learning.system.ports.output.repository.OrganizationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class CallMoodleApiFunctionCreateHelper {
    private final CourseDomainService coureDomainService;
   private final OrganizationRepository organizationRepository;

   private final CallMoodleApiFunctionRepository callMoodleApiFunctionRepository;

   private final CallMoodleApiFunctionDataMapper callMoodleApiFunctionDataMapper;

    public CallMoodleApiFunctionCreateHelper(CourseDomainService coureDomainService,
                                      CallMoodleApiFunctionRepository callMoodleApiFunctionRepository,
                                      CallMoodleApiFunctionDataMapper callMoodleApiFunctionDataMapper,
                                      OrganizationRepository organizationRepository) {
         this.coureDomainService = coureDomainService;
         this.callMoodleApiFunctionRepository = callMoodleApiFunctionRepository;
         this.callMoodleApiFunctionDataMapper = callMoodleApiFunctionDataMapper;
         this.organizationRepository = organizationRepository;
    }


    @Transactional
    public CallMoodleApiFunction persistCallMoodleApiFunction(CreateCallMoodleApiFunctionCommand createCallMoodleApiFunctionCommand) {
        CallMoodleApiFunction callMoodleApiFunction = callMoodleApiFunctionDataMapper.createCallMoodleApiFunctionCommandToCallMoodleApiFunction(createCallMoodleApiFunctionCommand);
        coureDomainService.createCallMoodleApiFunction(callMoodleApiFunction);
        CallMoodleApiFunction callMoodleApiFunctionResult = saveCallMoodleApiFunction(callMoodleApiFunction);
        return callMoodleApiFunctionResult;
    }

    private CallMoodleApiFunction saveCallMoodleApiFunction(CallMoodleApiFunction callMoodleApiFunction) {
        CallMoodleApiFunction savedCallMoodleApiFunction = callMoodleApiFunctionRepository.saveCallMoodleApiFunction(callMoodleApiFunction);
        if(savedCallMoodleApiFunction == null) {
            log.error("CallMoodleApiFunction is not saved");
            throw new RuntimeException("CallMoodleApiFunction is not saved");
        }
        log.info("CallMoodleApiFunction is saved");
        return savedCallMoodleApiFunction;
    }

}
