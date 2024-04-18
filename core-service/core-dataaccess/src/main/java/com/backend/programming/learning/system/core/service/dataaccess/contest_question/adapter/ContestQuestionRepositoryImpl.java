package com.backend.programming.learning.system.core.service.dataaccess.contest_question.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.contest_question.mapper.ContestQuestionDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.contest_question.repository.ContestQuestionJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.ContestQuestion;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ContestQuestionRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

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

    @Override
    public List<ContestQuestion> findAllContestQuestionsByContestId(UUID contestId) {
        return contestQuestionDataAccessMapper.contestQuestionEntityListToContestQuestionList(
                contestQuestionJpaRepository.findAllContestQuestionsByContestId(contestId)
        );
    }
}
