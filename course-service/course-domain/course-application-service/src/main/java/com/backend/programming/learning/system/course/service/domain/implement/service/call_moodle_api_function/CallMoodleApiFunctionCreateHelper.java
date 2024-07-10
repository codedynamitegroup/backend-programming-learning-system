package com.backend.programming.learning.system.course.service.domain.implement.service.call_moodle_api_function;

import com.backend.programming.learning.system.course.service.domain.CourseDomainService;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.call_moodle_api_function.CreateCallMoodleApiFunctionCommand;
import com.backend.programming.learning.system.course.service.domain.entity.CallMoodleApiFunction;
import com.backend.programming.learning.system.course.service.domain.mapper.call_moodle_api_function.CallMoodleApiFunctionDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CallMoodleApiFunctionRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.OrganizationRepository;
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
