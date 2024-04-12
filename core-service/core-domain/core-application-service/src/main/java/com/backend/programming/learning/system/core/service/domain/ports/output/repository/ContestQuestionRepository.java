package com.backend.programming.learning.system.core.service.domain.ports.output.repository;

import com.backend.programming.learning.system.core.service.domain.entity.ContestQuestion;

public interface ContestQuestionRepository {
    ContestQuestion saveContestQuestion(ContestQuestion contestQuestion);
}
