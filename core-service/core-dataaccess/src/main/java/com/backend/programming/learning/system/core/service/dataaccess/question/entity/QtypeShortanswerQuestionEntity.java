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
@Table(name = "qtype_shortanswer_question")
public class QtypeShortanswerQuestionEntity {
    @Id
    private UUID id;
    private UUID questionId;
    private Boolean caseSensitive;
}
