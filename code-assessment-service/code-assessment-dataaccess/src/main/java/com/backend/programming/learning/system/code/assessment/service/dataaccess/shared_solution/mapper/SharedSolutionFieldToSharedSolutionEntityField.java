package com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.mapper;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.entity.SharedSolutionEntity;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.SharedSolution;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SharedSolutionFieldToSharedSolutionEntityField {
//    SharedSolutionEntity a;
    final Map<String, String> fieldMapper =
        Map.ofEntries(
                Map.entry(SharedSolution.SortedFields.totalVote.name(), SharedSolutionEntity.Fields.totalVoteCount),
                Map.entry(SharedSolution.SortedFields.viewNumber.name(), SharedSolutionEntity.Fields.viewNumber),
                Map.entry(SharedSolution.SortedFields.createdAt.name(), SharedSolutionEntity.Fields.createdAt));
}
