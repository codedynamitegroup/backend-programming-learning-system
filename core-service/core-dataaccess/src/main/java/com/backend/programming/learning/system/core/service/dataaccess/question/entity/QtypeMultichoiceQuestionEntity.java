package com.backend.programming.learning.system.core.service.dataaccess.question.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "qtype_multichoice_question")
public class QtypeMultichoiceQuestionEntity {
    @Id
    private UUID id;
    private UUID questionId;
    private Integer single;
    private Integer shuffleAnswers;
    private String correctFeedback;
    private String partiallyCorrectFeedback;
    private String incorrectFeedback;
    private String answerNumbering;
    private Integer showNumCorrect;
    private String showStandardInstruction;
}
