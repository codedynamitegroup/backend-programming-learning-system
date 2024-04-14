package com.backend.programming.learning.system.core.service.dataaccess.question.entity;

import javax.persistence.*;
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
    private Boolean single;
    private Boolean shuffleAnswers;
    private String correctFeedback;
    private String partiallyCorrectFeedback;
    private String incorrectFeedback;
    private String answerNumbering;
    private Integer showNumCorrect;
    private String showStandardInstruction;
}
