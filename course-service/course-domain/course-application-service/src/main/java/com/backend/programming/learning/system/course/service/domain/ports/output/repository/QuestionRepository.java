package com.backend.programming.learning.system.course.service.domain.ports.output.repository;

import com.backend.programming.learning.system.course.service.domain.dto.method.query.question.QuestionExamDTO;
import com.backend.programming.learning.system.course.service.domain.entity.Question;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface QuestionRepository {
    Question saveQuestion(Question question);

    Page<Question> findAll(
            UUID questionBankCategoryId,
            String search,
            Integer page,
            Integer size);

    Question findById(UUID questionId);

    void deleteById(UUID questionId);

    Page<Question> findAllByExamId(UUID examId, String search, int pageNo, int pageSize);
    List<QuestionExamDTO> findAllByExamId(UUID examId, String search, Integer pageCurrent);
}
