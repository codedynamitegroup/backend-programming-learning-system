package com.backend.programming.learning.system.course.service.domain.ports.input.service.ai_grade_essay;

import com.backend.programming.learning.system.course.service.domain.dto.method.ai_grade_essay.AIGradeEssayCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.user.CreateUserCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.user.CreateUserResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.user.UpdateUserCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.user.UpdateUserResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.user.UserSubmissionAssignmentResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.AssignmentAIGradeReport;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

public interface AIGradeEssayApplicationService {
    String gradeEssay(AssignmentAIGradeReport assignmentAIGradeReport) throws JsonProcessingException;
    void createReportEssay(UUID assignmentId, UUID rubricId) throws JsonProcessingException;
}
