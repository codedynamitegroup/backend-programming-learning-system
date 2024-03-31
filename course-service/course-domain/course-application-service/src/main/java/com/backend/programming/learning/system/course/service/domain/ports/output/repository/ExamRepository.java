package com.backend.programming.learning.system.course.service.domain.ports.output.repository;

import com.backend.programming.learning.system.course.service.domain.entity.exam.Exam;

import java.util.List;

/**
 * com.backend.programming.learning.system.course.service.domain.ports.output.repository
 * Create by Dang Ngoc Tien
 * Date 3/21/2024 - 12:24 AM
 * Description: ...
 */
public interface ExamRepository {
    Exam createExam(Exam exam);

    List<Exam> findAll(String search);

    void deleteExam(Long examId);

    Exam updateExam(Long examId, Exam exam);

    Exam getExam(Long examId);
}
