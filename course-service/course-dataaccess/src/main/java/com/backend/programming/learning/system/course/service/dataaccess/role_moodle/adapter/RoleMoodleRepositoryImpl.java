package com.backend.programming.learning.system.course.service.dataaccess.role_moodle.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.role_moodle.mapper.RoleMoodleDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.role_moodle.repository.RoleMoodleJpaRepository;
import com.backend.programming.learning.system.course.service.domain.entity.RoleMoodle;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.RoleMoodleRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class RoleMoodleRepositoryImpl implements RoleMoodleRepository {
    private final RoleMoodleJpaRepository roleMoodleJpaRepository;
    private final RoleMoodleDataAccessMapper roleMoodleDataAccessMapper;


    @Override
    public RoleMoodle save(RoleMoodle roleMoodle) {
        return roleMoodleDataAccessMapper
                .roleMoodleEntityToRoleMoodle(roleMoodleJpaRepository
                        .save(roleMoodleDataAccessMapper
                                .roleMoodleToRoleMoodleEntity(roleMoodle)));
    }

    @Override
    public Optional<RoleMoodle> findById(Integer id) {
        return roleMoodleJpaRepository.findById(id)
                .map(roleMoodleDataAccessMapper::roleMoodleEntityToRoleMoodle);
    }

    @Override
    public RoleMoodle findByRoleName(String roleName) {
        return roleMoodleDataAccessMapper
                .roleMoodleEntityToRoleMoodle(roleMoodleJpaRepository
                        .findByName(roleName).get());
    }

    @Override
    public void delete(RoleMoodle roleMoodle) {
        roleMoodleJpaRepository.delete(roleMoodleDataAccessMapper
                .roleMoodleToRoleMoodleEntity(roleMoodle));
    }

    @Override
    public void deleteById(Integer id) {
        roleMoodleJpaRepository.deleteById(id);
    }

    @Override
    public List<RoleMoodle> findAll() {
        return roleMoodleDataAccessMapper
                .roleMoodleToRoleMoodleEntityList(roleMoodleJpaRepository.findAll());
    }
}
