package com.backend.programming.learning.system.course.service.domain.implement.service.assignment;

import com.backend.programming.learning.system.course.service.domain.CourseDomainService;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.assignment.CreateAssignmentCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_assignment.CreateSubmissionAssignmentCommand;
import com.backend.programming.learning.system.course.service.domain.entity.Assignment;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.implement.service.submission_assignment.SubmissionAssignmentCommandHandler;
import com.backend.programming.learning.system.course.service.domain.implement.service.submission_assignment.SubmissionAssignmentCreateHelper;
import com.backend.programming.learning.system.course.service.domain.mapper.assignment.AssignmentDataMapper;
import com.backend.programming.learning.system.course.service.domain.mapper.submission_assignment.SubmissionAssignmentDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.AssignmentRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CourseRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.course.service.domain.valueobject.CourseId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Slf4j
@Component
public class AssignmentCreateHelper {

    private final CourseDomainService coureDomainService;
    private final AssignmentRepository assignmentRepository;
    private final CourseRepository courseRepository;

    private final UserRepository userRepository;
    private final SubmissionAssignmentCommandHandler submissionAssignmentCommandHandler;

    private final SubmissionAssignmentDataMapper submissionAssignmentDataMapper;

    private final SubmissionAssignmentCreateHelper submissionAssignmentCreateHelper;


    private final AssignmentDataMapper assignmentDataMapper;

    public AssignmentCreateHelper(CourseDomainService coureDomainService,
                                  AssignmentRepository assignmentRepository,
                                  CourseRepository courseRepository,
                                  UserRepository userRepository, SubmissionAssignmentCommandHandler submissionAssignmentCommandHandler, SubmissionAssignmentDataMapper submissionAssignmentDataMapper, SubmissionAssignmentCreateHelper submissionAssignmentCreateHelper, AssignmentDataMapper assignmentDataMapper) {
        this.coureDomainService = coureDomainService;
        this.assignmentRepository = assignmentRepository;
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
        this.submissionAssignmentCommandHandler = submissionAssignmentCommandHandler;
        this.submissionAssignmentDataMapper = submissionAssignmentDataMapper;
        this.submissionAssignmentCreateHelper = submissionAssignmentCreateHelper;
        this.assignmentDataMapper = assignmentDataMapper;
    }

    @Transactional
    public Assignment persistAssignment(CreateAssignmentCommand createAssignmentCommand) {
        Assignment assignment = assignmentDataMapper.createAssignmentCommandToAssignment(createAssignmentCommand);
        coureDomainService.createAssignment(assignment);
//        checkCourse(createAssignmentCommand.getCourseId());
        Assignment assignmentResult = saveAssignment(assignment);
        List<User> users = userRepository.findAllUserByAssignmentId(assignmentResult.getId().getValue());
        for(User user : users) {
            if(user.getRoleMoodle().getId().getValue().equals(5)) {
                CreateSubmissionAssignmentCommand createSubmissionAssignmentCommand = CreateSubmissionAssignmentCommand.builder()
                        .assignmentId(assignmentResult.getId().getValue())
                        .userId(user.getId().getValue())
                        .build();
                submissionAssignmentCommandHandler.createSubmissionAssignment(createSubmissionAssignmentCommand);
            }
        }
        return assignmentResult;
    }

    private Assignment saveAssignment(Assignment assignment) {
        Assignment savedAssignment = assignmentRepository.saveAssignment(assignment);
        if(savedAssignment == null) {
            log.error("Assignment is not saved");
            throw new RuntimeException("Assignment is not saved");
        }
        log.info("Assignment is saved");
        return savedAssignment;
    }

    private void checkCourse(UUID courseId) {
        if(courseRepository.findBy(new CourseId(courseId).getValue()) == null) {
            log.error("Course is not found");
            throw new RuntimeException("Course is not found");
        }
    }

}
