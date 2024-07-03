package com.backend.programming.learning.system.course.service.dataaccess.rubric_user.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.rubric_user.mapper.RubricUserDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.rubric_user.repository.RubricUserJpaRepository;
import com.backend.programming.learning.system.course.service.domain.entity.RubricUser;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.RubricUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;


@Repository
@RequiredArgsConstructor
public class RubricUserRepositoryImpl implements RubricUserRepository {
    private final RubricUserDataAccessMapper rubricUserDataAccessMapper;
    private final RubricUserJpaRepository rubricUserJpaRepository;
    @Override
    public RubricUser save(RubricUser rubricUser) {
        return rubricUserDataAccessMapper
                .rubricUserEntityToRubricUser(rubricUserJpaRepository
                        .save(rubricUserDataAccessMapper
                                .rubricUserToRubricUserEntity(rubricUser)));
    }

    @Override
    public Optional<RubricUser> findRubricUser(UUID rubricUserId) {
        return rubricUserJpaRepository.findById(rubricUserId)
                .map(rubricUserDataAccessMapper::rubricUserEntityToRubricUser);
    }
}
