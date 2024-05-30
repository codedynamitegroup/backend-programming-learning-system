package com.backend.programming.learning.system.course.service.domain.mapper.submission_assignment_file;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_assignment_file.CreateSubmissionAssignmentFileCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_assignment_file.CreateSubmissionAssignmentFileResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.submission_assignment_file.SubmissionAssignmentFileResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.submission_file.SubmissionFileResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.SubmissionAssignmentFile;
import com.backend.programming.learning.system.course.service.domain.entity.SubmissionFile;
import com.backend.programming.learning.system.course.service.domain.mapper.submission_file.SubmissionFileDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.SubmissionFileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SubmissionAssignmentFileDataMapper {


    private final SubmissionFileDataMapper submissionFileDataMapper;
    private final SubmissionFileRepository submissionFileRepository;

    public SubmissionAssignmentFile createSubmissionAssignmentFileCommandToSubmissionAssignmentFile(CreateSubmissionAssignmentFileCommand createSubmissionAssignmentFileCommand) {
        return SubmissionAssignmentFile.builder()
                .num_file(createSubmissionAssignmentFileCommand.getNum_file())
                .build();
    }

    public CreateSubmissionAssignmentFileResponse submissionAssignmentFileToCreateSubmissionAssignmentFileResponse(SubmissionAssignmentFile submissionAssignmentFile, String message) {
        return CreateSubmissionAssignmentFileResponse.builder()
                .submissionAssignmentFileId(submissionAssignmentFile.getId().getValue())
                .message(message)
                .build();
    }

    public SubmissionAssignmentFileResponseEntity submissionAssignmentFileToSubmissionAssignmentFileResponseEntity(SubmissionAssignmentFile submissionAssignmentFile) {
        List<SubmissionFile> submissionFile = submissionFileRepository.
                findBySubmissionAssignmentFileId(submissionAssignmentFile.getId().getValue()).stream().toList();
        List<SubmissionFileResponseEntity> submissionFileResponseEntity=null;
        if(submissionFile!=null&&submissionFile.size()!=0)
        {
            submissionFileResponseEntity=submissionFileDataMapper.
                    submissionFileListToSubmissionFileResponseEntityList(submissionFile);
        }
        return SubmissionAssignmentFileResponseEntity.builder()
                .id(submissionAssignmentFile.getId().getValue())
                .files(submissionFileResponseEntity)
                .build();
    }
}
