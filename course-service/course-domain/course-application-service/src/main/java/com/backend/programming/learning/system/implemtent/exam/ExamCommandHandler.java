package com.backend.programming.learning.system.implemtent.exam;

import com.backend.programming.learning.system.dto.create.CreateExamCommand;
import com.backend.programming.learning.system.dto.create.CreateExamResponse;
import com.backend.programming.learning.system.dto.query.QueryExamCommand;
import com.backend.programming.learning.system.dto.query.QueryExamResponse;
import com.backend.programming.learning.system.entity.Exam;
import com.backend.programming.learning.system.mapper.ExamDataMapper;
import com.backend.programming.learning.system.ports.output.repository.ExamRepository;
import com.backend.programming.learning.system.valueobject.ExamId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * com.backend.programming.learning.system.implemtent.exam
 * Create by Dang Ngoc Tien
 * Date 4/16/2024 - 2:28 AM
 * Description: ...
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class ExamCommandHandler {
    private final ExamCreateHelper examCreateHelper;
    private final ExamDeleteHelper examDeleteHelper;
    private final ExamDataMapper examDataMapper;
    private final ExamRepository examRepository;
    public CreateExamResponse createExam(CreateExamCommand createExamCommand) {
        Exam examCreated = examCreateHelper.persistExam(createExamCommand);
        log.info("Exam is created with id: {}", examCreated.getId());
        return examDataMapper.examToCreateExamResponse(examCreated, "Exam created successfully");
    }

    @Transactional(readOnly = true)
    public QueryExamResponse findBy(QueryExamCommand queryExamCommand) {
        Exam exam = examRepository.findBy(new ExamId(queryExamCommand.getExamId()));
        if (exam == null) {
            log.error("Exam not found with id: {}", queryExamCommand.getExamId());
            throw new RuntimeException("Exam not found with id: " + queryExamCommand.getExamId());
        }
        return examDataMapper.examToQueryExamResponse(exam, "Exam found successfully");
    }

    @Transactional(readOnly = true)
    public List<QueryExamResponse> findAll(String search) {
        List<Exam> exams = examRepository.findAll(search);
        return examDataMapper.examsToQueryExamResponse(exams);
    }
}
