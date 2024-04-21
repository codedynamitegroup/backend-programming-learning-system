package com.backend.programming.learning.system.ports.output.repository;

import com.backend.programming.learning.system.entity.QuestionBank;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface QuestionBankRepository {
    QuestionBank save(QuestionBank questionBank);

    Page<QuestionBank> findAll(String search, Integer pageNo, Integer pageSize);

    QuestionBank findById(UUID questionBankId);

    void deleteById(UUID value);
}
