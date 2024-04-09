package com.backend.programming.learning.system.course.service.dataaccess.entity.question;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * com.backend.programming.learning.system.course.service.dataaccess.entity.question
 * Create by Dang Ngoc Tien
 * Date 3/26/2024 - 10:37 PM
 * Description: ...
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "question", schema = "6bros_course")
@Entity
public class QuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long orgId;
    private String name;
    private String questionText;
    private String generalFeedback;
    private Boolean defaultMark;
    private Long createdBy;
    private Long updatedBy;
    private String qtype;
    private String difficulty;
}
