package com.backend.programming.learning.system.implemtent.exam;

import com.backend.programming.learning.system.dto.create.CreateExamCommand;
import com.backend.programming.learning.system.dto.create.CreateExamResponse;
import com.backend.programming.learning.system.dto.query.QueryExamCommand;
import com.backend.programming.learning.system.dto.query.QueryExamResponse;
import com.backend.programming.learning.system.ports.input.service.ExamApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * com.backend.programming.learning.system.implemtent.exam
 * Create by Dang Ngoc Tien
 * Date 4/16/2024 - 2:25 AM
 * Description: ...
 */
@Slf4j
@Validated
@Service
@RequiredArgsConstructor
public class ExamApplicationServiceImpl implements ExamApplicationService {
    private final ExamCommandHandler examCommandHandler;

    @Override
    public CreateExamResponse createExam(CreateExamCommand createExamCommand) {
       return examCommandHandler.createExam(createExamCommand);
    }

    @Override
    public QueryExamResponse findBy(QueryExamCommand queryExamCommand) {
        return examCommandHandler.findBy(queryExamCommand);
    }

    @Override
    public List<QueryExamResponse> findAll(String search) {
        return examCommandHandler.findAll(search);
    }
}
