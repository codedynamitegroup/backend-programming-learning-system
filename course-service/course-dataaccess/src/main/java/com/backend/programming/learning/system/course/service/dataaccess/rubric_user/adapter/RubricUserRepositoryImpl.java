package com.backend.programming.learning.system.course.service.dataaccess.rubric_user.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.rubric_user.mapper.RubricUserDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.rubric_user.repository.RubricUserJpaRepository;
import com.backend.programming.learning.system.course.service.domain.entity.RubricUser;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.RubricUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    @Override
    public Page<RubricUser> findAllByUserId(UUID userId, Integer page, Integer size, String searchName) {
        Pageable paging = PageRequest.of(page, size);
        return rubricUserJpaRepository.findAllByUserId(userId, searchName, paging)
                .map(rubricUserDataAccessMapper::rubricUserEntityToRubricUser);
    }
}
