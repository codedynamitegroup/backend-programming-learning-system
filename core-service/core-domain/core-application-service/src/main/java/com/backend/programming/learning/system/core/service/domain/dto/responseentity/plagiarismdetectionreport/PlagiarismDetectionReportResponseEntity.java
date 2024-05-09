package com.backend.programming.learning.system.core.service.domain.dto.responseentity.plagiarismdetectionreport;

import com.backend.programming.learning.system.core.service.domain.dto.responseentity.QuestionResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.programminglanguage.ProgrammingLanguageResponseEntity;
import com.backend.programming.learning.system.core.service.domain.valueobject.PlagiarismDetectionReportStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class PlagiarismDetectionReportResponseEntity {
    @NotNull
    private final UUID plagiarismDetectionReportId;
    @NotNull
    private final ProgrammingLanguageResponseEntity programmingLanguage;
    @NotNull
    private final UUID examId;
    @NotNull
    private final QuestionResponseEntity question;
    @NotNull
    private final String name;
    @NotNull
    private final PlagiarismDetectionReportStatus status;
    @NotNull
    private final String comparedExamIds;
    @NotNull
    private final String pairsJsonContent;
    @NotNull
    private final ZonedDateTime createdAt;
}
