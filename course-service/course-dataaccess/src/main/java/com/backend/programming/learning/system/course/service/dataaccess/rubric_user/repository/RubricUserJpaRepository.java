package com.backend.programming.learning.system.course.service.dataaccess.rubric_user.repository;

import com.backend.programming.learning.system.course.service.dataaccess.rubric_user.entity.RubricUserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RubricUserJpaRepository extends JpaRepository<RubricUserEntity, UUID>{

    @Query(value = """
        select ru.*
        from rubric_user ru
        join public.user u ON ru.user_id = u.id
        where ru.user_id = u.id
        and ru.user_id = ?1
        """, nativeQuery = true)
    Page<RubricUserEntity> findAllByUserId(UUID userId, String searchName, Pageable pageable);
}
