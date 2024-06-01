package com.backend.programming.learning.system.course.service.domain.dto.method.query.question;

import com.backend.programming.learning.system.domain.valueobject.QuestionDifficulty;
import com.backend.programming.learning.system.domain.valueobject.QuestionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QuestionExamDTO {
    private UUID id;
    private QuestionDifficulty difficulty;
    private String name;
    private String questionText;
    private QuestionType qtype;
    private Integer page;
}
