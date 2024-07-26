package com.backend.programming.learning.system.course.service.dataaccess.assignment.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.assignment.mapper.AssignmentDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.assignment.repository.AssignmentJpaRepository;
import com.backend.programming.learning.system.course.service.domain.entity.Assignment;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.AssignmentRepository;
import com.backend.programming.learning.system.course.service.domain.valueobject.CourseId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public Optional<Assignment> findByAssignmentIdMoodleAndCourseId(Integer assignmentIdMoodle, UUID courseId) {
        return assignmentJpaRepository.findByAssignmentIdMoodleAndCourseId(assignmentIdMoodle, courseId)
                .map(assignmentDataAccessMapper::assignmentEntityToAssignment);
    }

    @Override
    public void deleteAssignmentById(UUID assignmentId) {
        assignmentJpaRepository.deleteById(assignmentId);

    }

    @Override
    public List<Assignment> findAll() {
        return assignmentDataAccessMapper.assignmentEntityListToAssignmentList(assignmentJpaRepository.findAll());
    }

    @Override
    public List<Assignment> findRecentAssignment() {
        return assignmentDataAccessMapper
                .assignmentEntityListToAssignmentList(assignmentJpaRepository.findRecentAssignment());
    }

    @Override
    public List<Assignment> findListGradeAssignmentByCourseId(UUID courseId, UUID userId, String searchName, Integer page, Integer size) {
        Pageable paging = PageRequest.of(page, size);
        return assignmentJpaRepository.findListGradeAssignmentByCourseId(courseId, userId, searchName)
                .stream()
                .map(assignmentDataAccessMapper::assignmentEntityToAssignment).toList();
    }

    @Override
    public List<Assignment> findAllGradeStudentAssignment(UUID courseId) {
        return assignmentDataAccessMapper.assignmentEntityListToAssignmentList(
                assignmentJpaRepository.findAllGradeStudentAssignment(courseId));
    }

}
