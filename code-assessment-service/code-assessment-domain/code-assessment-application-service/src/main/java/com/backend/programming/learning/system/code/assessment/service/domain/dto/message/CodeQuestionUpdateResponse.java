package com.backend.programming.learning.system.code.assessment.service.domain.dto.message;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.create.commandentity.TestCase;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;
@Getter
@Builder
@AllArgsConstructor
public class CodeQuestionUpdateResponse {
    private UUID id;
    private UUID questionId;
    private String problemStatement;
    private String inputFormat;
    private String outputFormat;
    private CopyState state;
    private String constraints;
}
