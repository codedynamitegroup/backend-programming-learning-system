package com.backend.programming.learning.system.code.assessment.service.domain.implement.service.shared_solution.tag;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.tag.AddTagsToSharedSolutionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.shared_solution.tag.DeleteSharedSolutionTagCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SharedSolutionTagHandler {
    final SharedSolutionTagHelper sharedSolutionTagHelper;

    public SharedSolutionTagHandler(SharedSolutionTagHelper sharedSolutionTagHelper) {
        this.sharedSolutionTagHelper = sharedSolutionTagHelper;
    }

    public void addTagToSolution(AddTagsToSharedSolutionCommand command) {
        sharedSolutionTagHelper.addTagToSolution(command);
    }

    public void deleteSharedSolutionTag(DeleteSharedSolutionTagCommand command) {
        sharedSolutionTagHelper.deleteSharedSolutionTag(command);
    }
}
