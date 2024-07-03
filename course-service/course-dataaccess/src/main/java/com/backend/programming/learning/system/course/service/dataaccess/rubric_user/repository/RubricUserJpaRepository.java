package com.backend.programming.learning.system.course.service.dataaccess.rubric_user.repository;

import com.backend.programming.learning.system.course.service.dataaccess.rubric_user.entity.RubricUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RubricUserJpaRepository extends JpaRepository<RubricUserEntity, UUID>{

}
