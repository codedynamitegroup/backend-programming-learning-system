package com.backend.programming.learning.system.core.service.dataaccess.question.entity;

import jakarta.persistence.*;

import com.backend.programming.learning.system.core.service.domain.entity.Question;
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

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "question_id", referencedColumnName = "id")
    private QuestionEntity question;
    private String dslTemplate;
    private String problemStatement;
    private String name;
    private Boolean isPublic;
    private Float maxGrade;
}
