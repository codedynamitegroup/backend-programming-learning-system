package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_submission;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
@AllArgsConstructor
public class SubmissionHeadMapItem {
    String date;
    Integer numOfSubmission;
}
