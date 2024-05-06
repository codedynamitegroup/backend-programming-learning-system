package com.backend.programming.learning.system.code.assessment.service.domain.implement.service.shared_solution;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.CreateSharedSolutionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.CreateSharedSolutionResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution.GetSharedSolutionByCodeQuestionIdCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution.GetSharedSolutionDetailCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution.GetSharedSolutionResponseItem;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.input.service.SharedSolutionApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
@Slf4j
public class SharedSolutionApplicationServiceImpl implements SharedSolutionApplicationService {
    private final SharedSolutionCommandHanlder hanlder;

    public SharedSolutionApplicationServiceImpl(SharedSolutionCommandHanlder hanlder) {
        this.hanlder = hanlder;
    }

    @Override
    public CreateSharedSolutionResponse createSharedSolution(CreateSharedSolutionCommand command) {

        return hanlder.createSharedSolution(command);
    }

    @Override
    public GetSharedSolutionResponseItem getDetailSharedSolution(GetSharedSolutionDetailCommand command) {

        return hanlder.getDetailSharedSolution(command);
    }

    @Override
    public List<GetSharedSolutionResponseItem> getSharedSolutions(GetSharedSolutionByCodeQuestionIdCommand command) {
        return hanlder.getSharedSolutions(command);
    }
}
