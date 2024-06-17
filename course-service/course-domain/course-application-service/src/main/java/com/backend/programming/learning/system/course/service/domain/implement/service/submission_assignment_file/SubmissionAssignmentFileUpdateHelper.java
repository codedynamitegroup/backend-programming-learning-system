package com.backend.programming.learning.system.course.service.domain.implement.service.submission_assignment_file;

import com.backend.programming.learning.system.course.service.domain.dto.method.update.submission_assignment_file.UpdateSubmissionAssignmentFileCommand;
import com.backend.programming.learning.system.course.service.domain.entity.SubmissionAssignment;
import com.backend.programming.learning.system.course.service.domain.entity.SubmissionAssignmentFile;
import com.backend.programming.learning.system.course.service.domain.exception.SubmissionAssignmentNotFoundException;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.SubmissionAssignmentFileRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.SubmissionAssignmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class SubmissionAssignmentFileUpdateHelper {
    private final SubmissionAssignmentFileRepository submissionAssignmentFileRepository;
    private final SubmissionAssignmentRepository submissionAssignmentRepository;

    @Transactional
    public void persistSubmissionAssignmentFile(UpdateSubmissionAssignmentFileCommand updateSubmissionAssignmentFileCommand, UUID id)
    {
        SubmissionAssignmentFile submissionAssignmentFile = getSubmissionAssignmentFile(id);
        SubmissionAssignment submissionAssignment = submissionAssignmentRepository.findById(updateSubmissionAssignmentFileCommand.getSubmissionAssignmentId()).get();
        if(updateSubmissionAssignmentFileCommand.getSubmissionAssignmentId()!=null)
        {
            submissionAssignmentFile.setSubmissionAssignment(submissionAssignment);
        }

        if(updateSubmissionAssignmentFileCommand.getFileName()!=null)
        {
            submissionAssignmentFile.setFileName(updateSubmissionAssignmentFileCommand.getFileName());
        }
        if(updateSubmissionAssignmentFileCommand.getFileSize()!=null)
        {
            submissionAssignmentFile.setFileSize(updateSubmissionAssignmentFileCommand.getFileSize());
        }
        if(updateSubmissionAssignmentFileCommand.getMimetype()!=null)
        {
            submissionAssignmentFile.setMimetype(updateSubmissionAssignmentFileCommand.getMimetype());
        }
        if(updateSubmissionAssignmentFileCommand.getFileUrl()!=null)
        {
            submissionAssignmentFile.setFileUrl(updateSubmissionAssignmentFileCommand.getFileUrl());
        }
        if(updateSubmissionAssignmentFileCommand.getTimemodified()!=null)
        {
            submissionAssignmentFile.setTimemodified(updateSubmissionAssignmentFileCommand.getTimemodified());
        }
        submissionAssignmentFileRepository.saveSubmissionAssignmentFile(submissionAssignmentFile);
    }


    public SubmissionAssignmentFile getSubmissionAssignmentFile(UUID id)
    {
        Optional<SubmissionAssignmentFile> submissionAssignmentFile = submissionAssignmentFileRepository.findById(id);
        if (submissionAssignmentFile.isEmpty()) {
            log.error("SubmissionAssignmentFile not found with id: {}", id);
            throw new SubmissionAssignmentNotFoundException("SubmissionAssignmentFile not found with id: " + id);
        }
        return submissionAssignmentFile.get();
    }


}
