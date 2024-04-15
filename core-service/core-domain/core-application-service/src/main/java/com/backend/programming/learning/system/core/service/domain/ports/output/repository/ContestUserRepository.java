package com.backend.programming.learning.system.core.service.domain.ports.output.repository;

import com.backend.programming.learning.system.core.service.domain.entity.ContestQuestion;
import com.backend.programming.learning.system.core.service.domain.entity.ContestUser;

public interface ContestUserRepository {
    ContestUser saveContestUser(ContestUser contestUser);
}
