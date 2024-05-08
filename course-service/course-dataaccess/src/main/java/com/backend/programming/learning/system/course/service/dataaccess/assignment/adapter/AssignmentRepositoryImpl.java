package com.backend.programming.learning.system.course.service.dataaccess.assignment.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.assignment.mapper.AssignmentDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.assignment.repository.AssignmentJpaRepository;
import com.backend.programming.learning.system.course.service.domain.entity.Assignment;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.AssignmentRepository;
import com.backend.programming.learning.system.course.service.domain.valueobject.CourseId;
import org.springframework.stereotype.Component;

import java.util.List;
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

    @Override
    public Optional<Assignment> findById(UUID assignmentId) {
        return assignmentJpaRepository.findById(assignmentId).map(assignmentDataAccessMapper::assignmentEntityToAssignment);
    }

    @Override
    public List<Assignment> findAllByCourseId(CourseId courseId) {
        return assignmentDataAccessMapper.assignmentEntityListToAssignmentList(
                assignmentJpaRepository.findAllByCourseId(courseId.getValue()));
    }

    @Override
    public Optional<Assignment> findByAssignmentIdMoodle(Integer assignmentIdMoodle) {
        return assignmentJpaRepository.findByAssignmentIdMoodle(assignmentIdMoodle)
                .map(assignmentDataAccessMapper::assignmentEntityToAssignment);
    }

    @Override
    public void deleteAssignmentById(UUID assignmentId) {
        assignmentJpaRepository.deleteById(assignmentId);

    }

}
