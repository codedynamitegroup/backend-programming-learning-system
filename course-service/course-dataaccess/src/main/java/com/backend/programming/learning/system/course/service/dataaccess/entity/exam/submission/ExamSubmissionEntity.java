package com.backend.programming.learning.system.course.service.dataaccess.entity.exam.submission;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * com.backend.programming.learning.system.course.service.dataaccess.entity.exam.submission
 * Create by Dang Ngoc Tien
 * Date 4/15/2024 - 12:00 AM
 * Description: ...
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "exam_submission", schema = "6bros_course")
@Entity
public class ExamSubmissionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long examId;
    private Long userId;
    private Long type; // sau sẽ chuyển thành enum
    private Long passStatus; // sau sẽ chuyển thành enum
}
