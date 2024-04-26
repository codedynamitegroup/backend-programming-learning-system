package com.backend.programming.learning.system.course.service.dataaccess.exam_question.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.exam_question.mapper.ExamQuestionDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.exam_question.repository.ExamQuestionJpaRepository;
import com.backend.programming.learning.system.course.service.domain.entity.ExamQuestion;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.ExamQuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class ExamQuestionRepositoryImpl implements ExamQuestionRepository {

    private final ExamQuestionJpaRepository examQuestionJpaRepository;
    private final ExamQuestionDataAccessMapper examQuestionDataAccessMapper;

    @Override
    public ExamQuestion saveExamQuestion(ExamQuestion examQuestion) {
        return examQuestionDataAccessMapper.examQuestionEntityToExamQuestion(examQuestionJpaRepository
                .save(examQuestionDataAccessMapper
                        .examQuestionToExamQuestionEntity(examQuestion)));
    }

    @Override
    public void assignExamToQuestions(List<ExamQuestion> examQuestions) {
        examQuestionJpaRepository.saveAll(examQuestionDataAccessMapper.examQuestionListToExamQuestionEntityList(examQuestions));
    }

    @Override
    public void deleteByExamIdAndQuestionIdIn(UUID examId, List<UUID> questionIds) {
        examQuestionJpaRepository.deleteByExamIdAndQuestionIdIn(examId, questionIds);
    }
}
