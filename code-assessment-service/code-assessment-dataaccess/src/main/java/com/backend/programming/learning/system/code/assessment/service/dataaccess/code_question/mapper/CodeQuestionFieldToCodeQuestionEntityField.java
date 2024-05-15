package com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.mapper;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.entity.CodeQuestionEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.entity.SharedSolutionEntity;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeQuestion;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.SharedSolution;
import org.springframework.stereotype.Component;

import java.util.Map;
@Component
public class CodeQuestionFieldToCodeQuestionEntityField {
    final Map<String, String> fieldMapper =
            Map.ofEntries(
                    Map.entry(CodeQuestion.Fields.name.name(), CodeQuestionEntity.Fields.name),
                    Map.entry(CodeQuestion.Fields.difficulty.name(), CodeQuestionEntity.Fields.difficulty),
                    Map.entry(CodeQuestion.Fields.createdAt.name(), CodeQuestionEntity.Fields.createdAt));

}
