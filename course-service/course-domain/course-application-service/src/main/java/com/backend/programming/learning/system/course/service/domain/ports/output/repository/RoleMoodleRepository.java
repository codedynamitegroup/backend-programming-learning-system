package com.backend.programming.learning.system.course.service.domain.ports.output.repository;

import com.backend.programming.learning.system.course.service.domain.entity.RoleMoodle;

import java.util.List;
import java.util.Optional;

public interface RoleMoodleRepository {
    RoleMoodle save(RoleMoodle roleMoodle);

    Optional<RoleMoodle> findById(Integer id);

    RoleMoodle findByRoleName(String roleName);

    void delete(RoleMoodle roleMoodle);

    void deleteById(Integer id);

    List<RoleMoodle> findAll();
}
