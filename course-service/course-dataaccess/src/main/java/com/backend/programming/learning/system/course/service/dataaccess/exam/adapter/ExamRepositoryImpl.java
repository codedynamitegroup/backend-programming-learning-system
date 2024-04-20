package com.backend.programming.learning.system.course.service.dataaccess.exam.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.exam.mapper.ExamDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.exam.repository.ExamJpaRepository;
import com.backend.programming.learning.system.entity.Exam;
import com.backend.programming.learning.system.ports.output.repository.ExamRepository;
import com.backend.programming.learning.system.valueobject.ExamId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ExamRepositoryImpl implements ExamRepository {
    private final ExamJpaRepository examJpaRepository;
    private final ExamDataAccessMapper examDataAccessMapper;

    public ExamRepositoryImpl(ExamJpaRepository examJpaRepository, ExamDataAccessMapper examDataAccessMapper) {
        this.examJpaRepository = examJpaRepository;
        this.examDataAccessMapper = examDataAccessMapper;
    }


    @Override
    public Exam saveExam(Exam exam) {
        return examDataAccessMapper.examEntityToExam(examJpaRepository
                .save(examDataAccessMapper
                        .examToExamEntity(exam)));
    }

    @Override
    public Exam save(Exam exam) {

        return examDataAccessMapper.examEntityToExam(
                examJpaRepository.save(examDataAccessMapper.examToExamEntity(exam)));
    }

    @Override
    public Exam findBy(ExamId examId) {
        return examJpaRepository.findById(examId.getValue())
                .map(examDataAccessMapper::examEntityToExam)
                .orElseThrow(() -> new RuntimeException("Exam not found"));
    }

    @Override
    public Page<Exam> findAll(String search, Integer pageNo, Integer pageSize) {
        return examJpaRepository.findAll(PageRequest.of(pageNo, pageSize))
                .map(examDataAccessMapper::examEntityToExam);
    }

    @Override
    public void deleteById(ExamId examId) {
        examJpaRepository.deleteById(examId.getValue());
    }
}
