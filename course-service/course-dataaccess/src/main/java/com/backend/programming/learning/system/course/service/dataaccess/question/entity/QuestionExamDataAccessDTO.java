package com.backend.programming.learning.system.course.service.dataaccess.question.entity;

import com.backend.programming.learning.system.domain.valueobject.QuestionDifficulty;
import com.backend.programming.learning.system.domain.valueobject.QuestionType;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@Builder
public class QuestionExamDataAccessDTO {
    private UUID id;
    private QuestionDifficulty difficulty;
    private String name;
    private String questionText;
    private QuestionType qtype;
    private Integer page;
    private Float defaultMark;

    public QuestionExamDataAccessDTO(UUID id, QuestionDifficulty difficulty, String name, String questionText, QuestionType qtype, Integer page, Float defaultMark) {
        this.id = id;
        this.difficulty = difficulty;
        this.name = name;
        this.questionText = questionText;
        this.qtype = qtype;
        this.page = page;
        this.defaultMark = defaultMark;
    }
}
