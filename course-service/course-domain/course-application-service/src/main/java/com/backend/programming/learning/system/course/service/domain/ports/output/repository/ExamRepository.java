package com.backend.programming.learning.system.course.service.domain.ports.output.repository;

import com.backend.programming.learning.system.course.service.domain.entity.Exam;
import com.backend.programming.learning.system.course.service.domain.valueobject.CourseId;
import com.backend.programming.learning.system.course.service.domain.valueobject.ExamId;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface ExamRepository {
    Exam save(Exam exam);

    Exam findBy(ExamId examId);

    Page<Exam> findAll(CourseId courseId, String search, Integer pageNo, Integer pageSize);

    void deleteById(ExamId examId);

    Optional<Exam> findByName(String name);

    Integer countStudent(ExamId examId);

    List<Exam> findRecentExam();

    List<Exam> findAllByCourseId(UUID courseId);
}
