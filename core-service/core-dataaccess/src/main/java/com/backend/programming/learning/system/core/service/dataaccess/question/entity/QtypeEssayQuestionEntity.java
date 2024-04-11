package com.backend.programming.learning.system.core.service.dataaccess.question.entity;

import jakarta.persistence.Column;
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
@Table(name = "qtype_essay_question")
public class QtypeEssayQuestionEntity {
    @Id
    @Column(name = "id")
    private UUID id;
    private UUID questionId;
    private String responseFormat;
    private Integer responseRequired;
    private Integer responseFieldLines;
    private Integer minWordLimit;
    private Integer maxWordLimit;
    private Integer attachments;
    private Integer attachmentsRequired;
    private String graderInfo;
    private Integer graderInfoFormat;
    private String responseTemplate;
    private Integer maxBytes;
    private String fileTypesList;
}
