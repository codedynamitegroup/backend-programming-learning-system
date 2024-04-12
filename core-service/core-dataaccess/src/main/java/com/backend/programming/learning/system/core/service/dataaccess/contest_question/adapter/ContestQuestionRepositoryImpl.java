package com.backend.programming.learning.system.core.service.dataaccess.contest_question.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.contest_question.mapper.ContestQuestionDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.contest_question.repository.ContestQuestionJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.ContestQuestion;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ContestQuestionRepository;
import org.springframework.stereotype.Component;

@Component
public class ContestQuestionRepositoryImpl implements ContestQuestionRepository {
    private final ContestQuestionJpaRepository contestQuestionJpaRepository;
    private final ContestQuestionDataAccessMapper contestQuestionDataAccessMapper;

    public ContestQuestionRepositoryImpl(ContestQuestionJpaRepository contestQuestionJpaRepository, ContestQuestionDataAccessMapper contestQuestionDataAccessMapper) {
        this.contestQuestionJpaRepository = contestQuestionJpaRepository;
        this.contestQuestionDataAccessMapper = contestQuestionDataAccessMapper;
    }

    @Override
    public ContestQuestion saveContestQuestion(ContestQuestion contestQuestion) {
        return contestQuestionDataAccessMapper.contestQuestionEntityToContestQuestion(
                contestQuestionJpaRepository.save(
                        contestQuestionDataAccessMapper.contestQuestionToContestQuestionEntity(contestQuestion)
                )
        );
    }
}
