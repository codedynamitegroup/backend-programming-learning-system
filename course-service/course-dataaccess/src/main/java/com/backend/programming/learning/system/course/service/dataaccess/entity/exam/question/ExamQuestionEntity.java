package com.backend.programming.learning.system.course.service.dataaccess.entity.exam.question;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
