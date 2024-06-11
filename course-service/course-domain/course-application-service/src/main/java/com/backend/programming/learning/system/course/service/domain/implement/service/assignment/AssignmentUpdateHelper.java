package com.backend.programming.learning.system.course.service.domain.implement.service.assignment;

import com.backend.programming.learning.system.course.service.domain.dto.method.update.assignment.UpdateAssignmentCommand;
import com.backend.programming.learning.system.course.service.domain.entity.Assignment;
import com.backend.programming.learning.system.course.service.domain.exception.AssignmentNotFoundException;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.AssignmentRepository;
import com.backend.programming.learning.system.course.service.domain.valueobject.AssignmentId;
import com.backend.programming.learning.system.course.service.domain.valueobject.Type;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class AssignmentUpdateHelper {
    private final AssignmentRepository assignmentRepository;

    public AssignmentUpdateHelper(AssignmentRepository assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }

    @Transactional(readOnly = true)
    public void persistAssignment(UpdateAssignmentCommand updateAssignmentCommand) {
        Assignment assignment = getAssignment(updateAssignmentCommand.getAssignmentId());
        if(updateAssignmentCommand.getTitle() != null)
        {
            assignment.setTitle(updateAssignmentCommand.getTitle());
        }

        if(updateAssignmentCommand.getIntro() != null)
        {
            assignment.setIntro(updateAssignmentCommand.getIntro());
        }



        if(updateAssignmentCommand.getMaxScore() != null)
        {
            assignment.setMaxScores(updateAssignmentCommand.getMaxScore());
        }

        if(updateAssignmentCommand.getTimeClose() != null)
        {
            assignment.setTime_close(updateAssignmentCommand.getTimeClose());
        }

        if(updateAssignmentCommand.getTimeLimit() != null)
        {
            assignment.setTime_limit(updateAssignmentCommand.getTimeLimit());
        }

        if(updateAssignmentCommand.getType() != null)
        {
            assignment.setType(Type.valueOf(updateAssignmentCommand.getType().toUpperCase()));
        }

        if(updateAssignmentCommand.getVisible() != null)
        {
            assignment.setVisible(updateAssignmentCommand.getVisible());
        }
        updateAssignment(assignment);
    }

    private Assignment getAssignment(UUID assignmentId) {
        Optional<Assignment> assignment = assignmentRepository.findById(new AssignmentId(assignmentId).getValue());
        if (assignment.isEmpty()) {
            log.warn("Assignment with id: {} not found", assignmentId);
            throw new AssignmentNotFoundException("Could not find assignment with id: " + assignmentId);
        }
        return assignment.get();
    }

    private void updateAssignment(Assignment assignment)
    {
       Assignment updateedAssignment = assignmentRepository.saveAssignment(assignment);

        if (updateedAssignment == null) {
            log.error("Failed to update assignment with id: {}", assignment.getId());
            throw new AssignmentNotFoundException("Failed to update assignment with id: " + assignment.getId());
        }

        log.info("Assignment with id: {} updated successfully", assignment.getId());

    }
}
