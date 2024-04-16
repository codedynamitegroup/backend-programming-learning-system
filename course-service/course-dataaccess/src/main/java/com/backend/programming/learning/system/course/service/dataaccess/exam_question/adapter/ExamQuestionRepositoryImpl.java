package com.backend.programming.learning.system.course.service.dataaccess.exam_question.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.exam_question.mapper.ExamQuestionDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.exam_question.repository.ExamQuestionJpaRepository;
import com.backend.programming.learning.system.entity.ExamQuestion;
import com.backend.programming.learning.system.ports.output.repository.ExamQuestionRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ExamQuestionRepositoryImpl implements ExamQuestionRepository {

    private final ExamQuestionJpaRepository examQuestionJpaRepository;
    private final ExamQuestionDataAccessMapper examQuestionDataAccessMapper;

    public ExamQuestionRepositoryImpl(ExamQuestionJpaRepository examQuestionJpaRepository, ExamQuestionDataAccessMapper examQuestionDataAccessMapper) {
        this.examQuestionJpaRepository = examQuestionJpaRepository;
        this.examQuestionDataAccessMapper = examQuestionDataAccessMapper;
    }

    @Override
    public ExamQuestion saveExamQuestion(ExamQuestion examQuestion) {
        return examQuestionDataAccessMapper.examQuestionEntityToExamQuestion(examQuestionJpaRepository
                .save(examQuestionDataAccessMapper
                        .examQuestionToExamQuestionEntity(examQuestion)));
    }
}
