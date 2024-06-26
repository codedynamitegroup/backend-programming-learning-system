package com.backend.programming.learning.system.course.service.dataaccess.exam.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.exam.entity.ExamEntity;
import com.backend.programming.learning.system.course.service.dataaccess.exam.mapper.ExamDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.exam.repository.ExamJpaRepository;
import com.backend.programming.learning.system.course.service.domain.entity.Exam;
import com.backend.programming.learning.system.course.service.domain.exception.ExamNotFoundException;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.ExamRepository;
import com.backend.programming.learning.system.course.service.domain.valueobject.CourseId;
import com.backend.programming.learning.system.course.service.domain.valueobject.ExamId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository
public class ExamRepositoryImpl implements ExamRepository {
    private final ExamJpaRepository examJpaRepository;
    private final ExamDataAccessMapper examDataAccessMapper;

    public ExamRepositoryImpl(ExamJpaRepository examJpaRepository, ExamDataAccessMapper examDataAccessMapper) {
        this.examJpaRepository = examJpaRepository;
        this.examDataAccessMapper = examDataAccessMapper;
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
                .orElseThrow(() -> new ExamNotFoundException("Exam not found"));
    }

    @Override
    public Page<Exam> findAll(CourseId courseId, String search, Integer pageNo, Integer pageSize) {
        return examJpaRepository.findAll(courseId.getValue(), search, PageRequest.of(pageNo, pageSize))
                .map(examDataAccessMapper::examEntityToExam);
    }

    @Override
    public void deleteById(ExamId examId) {
        ExamEntity examEntity = examJpaRepository.findById(examId.getValue())
                .orElseThrow(() -> new ExamNotFoundException("Exam not found"));
        examJpaRepository.delete(examEntity);
    }

    @Override
    public Optional<Exam> findByName(String name) {
        return examJpaRepository.findByName(name)
                .map(examDataAccessMapper::examEntityToExam);
    }

    @Override
    public Integer countStudent(ExamId examId) {
        return examJpaRepository.countStudent(examId.getValue());
    }

    @Override
    public List<Exam> findRecentExam() {
        return examJpaRepository.findRecentExam()
                .stream()
                .map(examDataAccessMapper::examEntityToExam)
                .toList();
    }

    @Override
    public List<Exam> findAllByCourseId(UUID courseId) {
        return examJpaRepository.findAllByCourseId(courseId)
                .stream()
                .map(examDataAccessMapper::examEntityToExam)
                .toList();
    }
}
