package com.backend.programming.learning.system.core.service.dataaccess.question.entity;

import com.backend.programming.learning.system.core.service.domain.entity.Question;
import lombok.*;

import jakarta.persistence.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "answer_of_question")
public class AnswerOfQuestionEntity {
    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "question_id")
    private UUID questionId;
    private String answer;
    private String feedback;
    private float fraction;
}
