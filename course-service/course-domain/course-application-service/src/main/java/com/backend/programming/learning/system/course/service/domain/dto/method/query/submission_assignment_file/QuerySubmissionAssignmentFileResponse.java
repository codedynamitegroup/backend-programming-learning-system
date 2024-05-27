package com.backend.programming.learning.system.course.service.domain.dto.method.query.submission_assignment_file;

import com.backend.programming.learning.system.course.service.domain.entity.SubmissionFile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QuerySubmissionAssignmentFileResponse {
    private UUID submissionAssignmentFileId;
    private List<SubmissionFile> files;
}
