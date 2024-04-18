package com.backend.programming.learning.system.core.service.domain.ports.output.repository;

import com.backend.programming.learning.system.core.service.domain.entity.ContestQuestion;

import java.util.List;
import java.util.UUID;

public interface ContestQuestionRepository {
    ContestQuestion saveContestQuestion(ContestQuestion contestQuestion);

    List<ContestQuestion> findAllContestQuestionsByContestId(UUID contestId);
}
