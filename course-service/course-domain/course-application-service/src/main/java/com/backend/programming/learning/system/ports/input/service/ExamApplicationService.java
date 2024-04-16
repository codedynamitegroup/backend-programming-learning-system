package com.backend.programming.learning.system.ports.input.service;

import com.backend.programming.learning.system.dto.create.CreateExamCommand;
import com.backend.programming.learning.system.dto.create.CreateExamResponse;
import com.backend.programming.learning.system.dto.query.QueryExamCommand;
import com.backend.programming.learning.system.dto.query.QueryExamResponse;

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
