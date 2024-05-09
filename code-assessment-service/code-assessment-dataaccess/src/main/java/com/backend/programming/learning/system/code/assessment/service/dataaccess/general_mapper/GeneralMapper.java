package com.backend.programming.learning.system.code.assessment.service.dataaccess.general_mapper;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.mapper.SharedSolutionFieldToSharedSolutionEntityField;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.SharedSolution;
import com.backend.programming.learning.system.domain.valueobject.QueryOrderBy;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class GeneralMapper {

    public Sort.Direction QueryOrderByToSortDirection(QueryOrderBy queryOrderBy){
        if(queryOrderBy == QueryOrderBy.ASC)
            return Sort.Direction.ASC;
        if(queryOrderBy == QueryOrderBy.DESC)
            return Sort.Direction.DESC;
        return Sort.Direction.DESC;
    }

}
