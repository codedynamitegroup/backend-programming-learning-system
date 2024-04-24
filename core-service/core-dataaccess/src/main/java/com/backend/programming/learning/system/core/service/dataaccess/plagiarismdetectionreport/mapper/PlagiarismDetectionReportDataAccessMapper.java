package com.backend.programming.learning.system.core.service.dataaccess.plagiarismdetectionreport.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.plagiarismdetectionreport.entity.PlagiarismDetectionReportEntity;
import com.backend.programming.learning.system.core.service.dataaccess.programminglanguage.entity.ProgrammingLanguageEntity;
import com.backend.programming.learning.system.core.service.dataaccess.programminglanguage.mapper.ProgrammingLanguageDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QuestionEntity;
import com.backend.programming.learning.system.core.service.dataaccess.question.mapper.QuestionDataAccessMapper;
import com.backend.programming.learning.system.core.service.domain.entity.PlagiarismDetectionReport;
import com.backend.programming.learning.system.core.service.domain.entity.ProgrammingLanguage;
import com.backend.programming.learning.system.core.service.domain.entity.Question;
import com.backend.programming.learning.system.core.service.domain.valueobject.ExamId;
import com.backend.programming.learning.system.core.service.domain.valueobject.PlagiarismDetectionReportId;
import com.backend.programming.learning.system.domain.valueobject.ProgrammingLanguageId;
import org.springframework.stereotype.Component;

@Component
public class PlagiarismDetectionReportDataAccessMapper {
    private final ProgrammingLanguageDataAccessMapper programmingLanguageDataAccessMapper;
    private final QuestionDataAccessMapper questionDataAccessMapper;

    public PlagiarismDetectionReportDataAccessMapper(ProgrammingLanguageDataAccessMapper programmingLanguageDataAccessMapper, QuestionDataAccessMapper questionDataAccessMapper) {
        this.programmingLanguageDataAccessMapper = programmingLanguageDataAccessMapper;
        this.questionDataAccessMapper = questionDataAccessMapper;
    }

    public PlagiarismDetectionReportEntity plagiarismDetectionReportToPlagiarismDetectionReportEntity(
            PlagiarismDetectionReport plagiarismDetectionReport) {
        ProgrammingLanguageEntity programmingLanguageEntity = programmingLanguageDataAccessMapper
                .programmingLanguageToProgrammingLanguageEntity(plagiarismDetectionReport.getProgrammingLanguage());
        QuestionEntity questionEntity = questionDataAccessMapper.questionToQuestionEntity(plagiarismDetectionReport.getQuestion());
        return PlagiarismDetectionReportEntity.builder()
                .id(plagiarismDetectionReport.getId().getValue())
                .name(plagiarismDetectionReport.getName())
                .examId(plagiarismDetectionReport.getExamId().getValue())
                .programmingLanguage(programmingLanguageEntity)
                .question(questionEntity)
                .status(plagiarismDetectionReport.getStatus())
                .comparedExamIds(plagiarismDetectionReport.getComparedExamIds())
                .pairsJsonContent(plagiarismDetectionReport.getPairsJsonContent())
                .createdAt(plagiarismDetectionReport.getCreatedAt())
                .build();
    }

    public PlagiarismDetectionReport plagiarismDetectionReportEntityToPlagiarismDetectionReport(
            PlagiarismDetectionReportEntity plagiarismDetectionReportEntity) {
        ProgrammingLanguage programmingLanguage = programmingLanguageDataAccessMapper
                .programmingLanguageEntityToProgrammingLanguage(plagiarismDetectionReportEntity.getProgrammingLanguage());
        Question question = questionDataAccessMapper.questionEntityToQuestion(plagiarismDetectionReportEntity.getQuestion());
        return PlagiarismDetectionReport.builder()
                .id(new PlagiarismDetectionReportId(plagiarismDetectionReportEntity.getId()))
                .name(plagiarismDetectionReportEntity.getName())
                .examId(new ExamId(plagiarismDetectionReportEntity.getExamId()))
                .programmingLanguage(programmingLanguage)
                .question(question)
                .status(plagiarismDetectionReportEntity.getStatus())
                .comparedExamIds(plagiarismDetectionReportEntity.getComparedExamIds())
                .pairsJsonContent(plagiarismDetectionReportEntity.getPairsJsonContent())
                .createdAt(plagiarismDetectionReportEntity.getCreatedAt())
                .build();
    }
}
