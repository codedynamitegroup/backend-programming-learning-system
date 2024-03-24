package com.backend.programming.learning.system.course.service.dataaccess.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.entity.ExamEntity;
import com.backend.programming.learning.system.course.service.dataaccess.mapper.ExamDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.repository.ExamJpaRepository;
import com.backend.programming.learning.system.course.service.domain.entity.Exam;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.ExamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * com.backend.programming.learning.system.course.service.dataaccess.adapter
 * Create by Dang Ngoc Tien
 * Date 3/21/2024 - 10:39 PM
 * Description: ...
 */
@Component
@RequiredArgsConstructor
public class ExamRepositoryImpl implements ExamRepository {
    private final ExamJpaRepository examJpaRepository;
    private final ExamDataAccessMapper examDataAccessMapper;

    @Override
    public Exam createExam(Exam exam) {
        return examDataAccessMapper.examEntityToExam(
                examJpaRepository.save(examDataAccessMapper.examToExamEntity(exam)));
    }

    @Override
    public List<Exam> findAll(String search) {
        return examJpaRepository.findAll()
                .stream().map(examDataAccessMapper::examEntityToExam)
                .toList();
    }

    @Override
    public void deleteExam(Long examId) {
        examJpaRepository.deleteById(examId);
    }

    @Override
    public Exam updateExam(Long examId, Exam exam) {
        ExamEntity examEntity = examJpaRepository.findById(examId)
                .orElseThrow(() -> new RuntimeException("Exam not found"));
        ExamEntity updatedExamEntity = examDataAccessMapper.updateExamEntity(examEntity, exam);
        return examDataAccessMapper.examEntityToExam(examJpaRepository.save(updatedExamEntity));
    }

}
