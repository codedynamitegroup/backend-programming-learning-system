package com.backend.programming.learning.system.core.service.dataaccess.question.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "qtype_code_question")
public class QtypeCodeQuestionEntity {
    @Id
    @Column(name = "id")
    private UUID id;
    private UUID questionId;
    private String dslTemplate;
}
