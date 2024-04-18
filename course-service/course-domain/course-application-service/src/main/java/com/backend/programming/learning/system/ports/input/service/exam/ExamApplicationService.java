package com.backend.programming.learning.system.ports.input.service.exam;

import com.backend.programming.learning.system.dto.method.create.exam.CreateExamCommand;
import com.backend.programming.learning.system.dto.method.create.exam.CreateExamResponse;
import com.backend.programming.learning.system.dto.method.query.exam.QueryExamCommand;
import com.backend.programming.learning.system.dto.method.query.exam.QueryExamResponse;

import javax.validation.Valid;
import java.util.List;

/**
 * com.backend.programming.learning.system.ports.input.service
 * Create by Dang Ngoc Tien
 * Date 4/16/2024 - 2:18 AM
 * Description: ...
 */
public interface ExamApplicationService {

    CreateExamResponse createExam(@Valid CreateExamCommand createExamCommand);

    QueryExamResponse findBy(QueryExamCommand queryExamCommand);

    List<QueryExamResponse> findAll(String search);
}
