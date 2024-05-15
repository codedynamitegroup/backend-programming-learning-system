package com.backend.programming.learning.system.core.service.domain.mapper.plagiarismdetectionreport;

import com.backend.programming.learning.system.core.service.domain.dto.method.query.plagiarismdetectionreport.QueryAllPlagiarismDetectionReportsResponse;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.question.QuestionResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.plagiarismdetectionreport.PlagiarismDetectionReportResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.programminglanguage.ProgrammingLanguageResponseEntity;
import com.backend.programming.learning.system.core.service.domain.entity.*;
import com.backend.programming.learning.system.core.service.domain.mapper.programminglanguage.ProgrammingLanguageDataMapper;
import com.backend.programming.learning.system.core.service.domain.mapper.question.QuestionDataMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PlagiarismDetectionReportDataMapper {
    private final ProgrammingLanguageDataMapper programmingLanguageDataMapper;
    private final QuestionDataMapper questionDataMapper;

    public PlagiarismDetectionReportDataMapper(ProgrammingLanguageDataMapper programmingLanguageDataMapper,
                                               QuestionDataMapper questionDataMapper) {
        this.programmingLanguageDataMapper = programmingLanguageDataMapper;
        this.questionDataMapper = questionDataMapper;
    }

    public PlagiarismDetectionReportResponseEntity plagiarismDetectionReportToPlagiarismDetectionReportResponse(
            PlagiarismDetectionReport plagiarismDetectionReport) {
        QuestionResponseEntity questionResponseEntity = questionDataMapper.questionToQuestionResponseEntity(plagiarismDetectionReport.getQuestion());
        ProgrammingLanguageResponseEntity programmingLanguageResponseEntity =
                programmingLanguageDataMapper.
                        programmingLanguageToQueryProgrammingLanguageResponse(
                                plagiarismDetectionReport.getProgrammingLanguage());
        return PlagiarismDetectionReportResponseEntity.builder()
                .plagiarismDetectionReportId(plagiarismDetectionReport.getId().getValue())
                .programmingLanguage(programmingLanguageResponseEntity)
                .examId(plagiarismDetectionReport.getExamId().getValue())
                .question(questionResponseEntity)
                .name(plagiarismDetectionReport.getName())
                .status(plagiarismDetectionReport.getStatus())
                .comparedExamIds(plagiarismDetectionReport.getComparedExamIds())
                .pairsJsonContent(plagiarismDetectionReport.getPairsJsonContent())
                .createdAt(plagiarismDetectionReport.getCreatedAt())
                .build();
    }

    public QueryAllPlagiarismDetectionReportsResponse plagiarismDetectionReportsToQueryAllPlagiarismDetectionReportsResponse(
            Page<PlagiarismDetectionReport> plagiarismDetectionReports) {
        List<PlagiarismDetectionReportResponseEntity> plagiarismDetectionReportResponseEntities = new ArrayList<>();
        for (PlagiarismDetectionReport plagiarismDetectionReport : plagiarismDetectionReports) {
            plagiarismDetectionReportResponseEntities.add(plagiarismDetectionReportToPlagiarismDetectionReportResponse(plagiarismDetectionReport));
        }
        return QueryAllPlagiarismDetectionReportsResponse.builder()
                .plagiarismDetectionReports(plagiarismDetectionReportResponseEntities)
                .currentPage(plagiarismDetectionReports.getNumber())
                .totalPages(plagiarismDetectionReports.getTotalPages())
                .totalItems(plagiarismDetectionReports.getTotalElements())
                .build();
    }
}
