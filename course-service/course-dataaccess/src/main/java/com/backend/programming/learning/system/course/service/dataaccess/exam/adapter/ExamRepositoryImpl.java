package com.backend.programming.learning.system.course.service.dataaccess.exam.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.exam.mapper.ExamDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.exam.repository.ExamJpaRepository;
import com.backend.programming.learning.system.entity.Exam;
import com.backend.programming.learning.system.ports.output.repository.ExamRepository;
import org.springframework.stereotype.Repository;

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
}
