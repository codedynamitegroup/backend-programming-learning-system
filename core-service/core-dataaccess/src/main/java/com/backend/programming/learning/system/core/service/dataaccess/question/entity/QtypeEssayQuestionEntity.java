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
@Table(name = "qtype_essay_question", schema = "public")
public class QtypeEssayQuestionEntity {
    @Id
    @Column(name = "id")
    private UUID id;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "question_id", referencedColumnName = "id")
    private QuestionEntity question;

    private String responseFormat;
    private Integer responseRequired;
    private Integer responseFieldLines;
    private Integer minWordLimit;
    private Integer maxWordLimit;
    private Integer attachments;
    private Integer attachmentsRequired;
    private String graderInfo;
    private String graderInfoFormat;
    private String responseTemplate;
    private Integer maxBytes;
    private String fileTypesList;
}
