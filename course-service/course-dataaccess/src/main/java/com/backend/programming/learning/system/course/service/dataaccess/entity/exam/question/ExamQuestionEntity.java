package com.backend.programming.learning.system.course.service.dataaccess.entity.exam.question;

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
 * com.backend.programming.learning.system.course.service.dataaccess.entity.exam.question
 * Create by Dang Ngoc Tien
 * Date 3/27/2024 - 10:28 PM
 * Description: ...
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "exam_question", schema = "6bros_course")
@Entity
public class ExamQuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long examId;
    private Long questionId;
}
