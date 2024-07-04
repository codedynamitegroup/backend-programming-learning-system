package com.backend.programming.learning.system.course.service.domain.ports.input.service.rubric_user;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.report_grade_essay_ai.ReportGradeEssayAICommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.rubric_user.CreateRubricUserCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.rubric_user.QueryAllRubricsByUserIdCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.rubric_user.QueryAllRubricsByUserIdResponse;
import com.backend.programming.learning.system.course.service.domain.entity.AssignmentAIGradeReport;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.Valid;

import java.util.UUID;

public interface RubricUserApplicationService {
    QueryAllRubricsByUserIdResponse queryAllRubricsByUserId(QueryAllRubricsByUserIdCommand queryAllRubricsByUserIdCommand);
    void createReportEssay(@Valid CreateRubricUserCommand createRubricUserCommand);

}
