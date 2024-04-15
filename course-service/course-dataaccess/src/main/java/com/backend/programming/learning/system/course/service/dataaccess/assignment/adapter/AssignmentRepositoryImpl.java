package com.backend.programming.learning.system.course.service.dataaccess.assignment.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.assignment.entity.AssignmentEntity;
import com.backend.programming.learning.system.course.service.dataaccess.assignment.mapper.AssignmentDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.assignment.repository.AssignmentJpaRepository;
import com.backend.programming.learning.system.entity.Assignment;
import com.backend.programming.learning.system.ports.output.repository.AssignmentRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class AssignmentRepositoryImpl implements AssignmentRepository {

    private final AssignmentJpaRepository assignmentJpaRepository;
    private final AssignmentDataAccessMapper assignmentDataAccessMapper;


    public AssignmentRepositoryImpl(AssignmentJpaRepository assignmentJpaRepository, AssignmentDataAccessMapper assignmentDataAccessMapper) {
        this.assignmentJpaRepository = assignmentJpaRepository;
        this.assignmentDataAccessMapper = assignmentDataAccessMapper;
    }


    @Override
    public Assignment saveAssignment(Assignment assignment) {
        return assignmentDataAccessMapper.assignmentEntityToAssignment(assignmentJpaRepository
                .save(assignmentDataAccessMapper
                        .assignmentToAssignmentEntity(assignment)));
    }
}
